package com.cucumber.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.utils.Datahelper;
import com.cucumber.utils.ResultSheetHelper;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//@Listeners(InvokedMethodListener.class)
public class StepDefinitions extends ResultSheetHelper {

	public List<HashMap<String, String>> logindata;
	public static String ScenarioName;
	public static String StepName;

	public StepDefinitions() {
		logindata = Datahelper.data(System.getProperty("user.dir") + "\\TestScript.xlsx", "UserRegistration");
	}

	public static WebDriver driver;

	@Before
	public void beforetest(Scenario scenario) {
		ScenarioName = scenario.getName();
		// StepName = scenario.getId();

		// String stepname=ScenarioName

	}

	@Given("User navigates to URL with excel row \"([^\"]*)\" dataset$")
	public void user_navigates_to_URL_with_excel_row_dataset(String row_index) throws Throwable {
		System.out.println("......" + ScenarioName);
		addLables();
		autoResizeColumns();
		// Assert.assertEquals("String1", "String2");
		int a = 12;
		int b = 20;

		try {
			Assert.assertEquals(a, b);
			resultwriteScenario(ScenarioName, "User navigates to URL");
		} catch (Throwable e) {
			System.out.println("Exception Occurred");
			// String ex = throw e;
			resultwriteScenarioFail(ScenarioName, "User navigate to url", e.getMessage(), "Pass Method");
		}
	}

	@When("^User enter data using with excel row \"([^\"]*)\" dataset$")
	public void user_enter_data_using_with_excel_row_dataset(String row_index) throws Throwable {
		/*
		 * int index = Integer.parseInt(row_index) - 1;
		 * System.out.println("---------------------------------------------");
		 * System.out.println(logindata.get(index).get("FirstName"));
		 * System.out.println(logindata.get(index).get("LastName"));
		 * System.out.println(logindata.get(index).get("EmailAddress"));
		 * System.out.println(logindata.get(index).get("hear_about_us"));
		 * System.out.println(logindata.get(index).get("Password"));
		 * System.out.println(logindata.get(index).get("ConfirmPassword"));
		 * System.out.println(logindata.get(index).get("Verification Message"));
		 * System.out.println(logindata.get(index).get("phone"));
		 * System.out.println(logindata.get(index).get("phone1"));
		 */

		try {
			// click(LP.Logout);
			resultwriteStepsPass("user click on Logout button");
		} catch (Exception e) {
			resultwriteStepsFail("user not clicked on Logout button", e.getMessage(), "ClickLogout");
		}
	}

	@Then("^click on signIn button$")
	public void click_on_signIn_button() throws Throwable {

		try {
			// driver.quit();
			resultwriteStepsPass("user close the browser");
			RowNo = RowNo + 1;
			resultWritebook.write();
			resultWritebook.close();
		} catch (Exception e) {
			resultwriteStepsFail("user not close the browser", e.getMessage(), "closebrowser");
			resultWritebook.write();
			resultWritebook.close();
		}
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {

	}

}
