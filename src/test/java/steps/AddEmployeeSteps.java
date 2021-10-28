package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firtName, "Noor");
        sendText(addEmployeePage.middleName, "007breakmanager");
        sendText(addEmployeePage.lastName, "khan");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeId.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);
    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.createUsername, "noor10272021234");
        sendText(addEmployeePage.createPassword, "Hum@nhrm123");
        sendText(addEmployeePage.rePassword, "Hum@nhrm123");
    }

}
