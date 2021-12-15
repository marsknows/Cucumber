package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedReview {
    String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    static String token_f;
    @Test
    public void aGenerateToken(){
        RequestSpecification preparedRequest = given().header("Content_Type","application/json").body("{\n" +
                "  \"email\": \"mars1@aol.com\",\n" +
                "  \"password\": \"deeznutz\"\n" +
                "}");

        Response response = preparedRequest.when().post("/generateToken.php");
        String token = response.jsonPath().getString("token");
        System.out.println(token);
        token_f="Bearer "+token;
    }
    @Test
    public void bCreateAnEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization",token_f)
                .header("Content-Type","application/json").body("{\n" +
                        "  \"emp_firstname\": \"Bruce\",\n" +
                        "  \"emp_lastname\": \"Wayne\",\n" +
                        "  \"emp_middle_name\": \"Mars\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1985-11-07\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Caped Crusader\"\n" +
                        "}");
        Response response = preparedRequest.when().post("/createEmployee.php");
    }
}
