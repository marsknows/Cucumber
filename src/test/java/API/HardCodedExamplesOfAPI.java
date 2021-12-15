package API;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamplesOfAPI {
    //rest assured considers baseURL as baseURI
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzkwMTAyOTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzOTA1MzQ5MywidXNlcklkIjoiMzMyOCJ9._z8mrNViRodOdxXjaNqrdJna18MJKHGtgO6WrY3jIS0";
static String employee_id;
    //@Test
    public void dgetDetailsOfOneEmployee(){

        //given
        RequestSpecification preparedRequest =given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id","25660A");

        //when - hitting the endpoint
        Response response =preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        //then - result/assertion
        response.then().assertThat().statusCode(200);
    }

    //@Test
    public void acreateEmployee(){
        //given
        RequestSpecification preparedRequest =given().header("Authorization",token)
                .header("Content-Type","application/json").body("{\n" +
                        "  \"emp_firstname\": \"Json\",\n" +
                        "  \"emp_lastname\": \"Hees\",\n" +
                        "  \"emp_middle_name\": \"Vor\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1980-12-08\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Slasher\"\n" +
                        "}");
        //when
        Response response =preparedRequest.when().post("/createEmployee.php");
        //prettyPrint does the same job as sysout --> System.out.println(response.asString());
        response.prettyPrint();

        //jsonPath() we use this to get specific information from the json object
        employee_id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        //then
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Json"));
        response.then().assertThat().body("Message",equalTo("Employee Created"));
        response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
    }
    //@Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest =given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id",employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        String empID = response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpID = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpID);

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstName.contentEquals("Json"));
        String lastName = response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastName.contentEquals("Hees"));
    }
    //@Test
    public void cupdateCreatedEmployee(){
        RequestSpecification preparedRequest =given().header("Authorization",token)
                .header("Content-Type","application/json").body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Jack\",\n" +
                        "  \"emp_lastname\": \"PumpkinKing\",\n" +
                        "  \"emp_middle_name\": \"Skellington\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1993-10-31\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"Sandy Claws\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
    }

}
