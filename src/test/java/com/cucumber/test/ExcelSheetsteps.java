package com.cucumber.test;

import org.testng.Assert;

import com.cucumber.utils.ResultSheetHelper;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExcelSheetsteps extends ResultSheetHelper {

	public static String ScenarioName;

	@Before
	public void beforetest(Scenario scenario) {
		ScenarioName = scenario.getName();
		// StepName = scenario.getId();

		// String stepname=ScenarioName

	}

	@Given("^I want to write a step with name(\\d+)$")
	public void i_want_to_write_a_step_with_name(int name) throws Throwable {
		System.out.println("......" + ScenarioName);

		addLables();
		autoResizeColumns();
		// Assert.assertEquals("String1", "String2");
		int a = 12;
		int b = 20;

		try {
			// Assert.assertEquals(a, b);
			resultwriteScenario(ScenarioName, "I want to write a step with");
		} catch (Throwable e) {
			System.out.println("Exception Occurred");
			// String ex = throw e;
			resultwriteScenarioFail(ScenarioName, "I want to write a step with", e.getMessage() + "Custom Fail Message",
					"Expected Result");
		}
	}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable {

		try {
			// click(LP.Logout);
			resultwriteStepsPass("I check for the in step");
		} catch (Exception e) {
			resultwriteStepsFail("I check for the in step", e.getMessage() + "Custom Fail Message", "Expected Result");
		}
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step() throws Throwable {
		try {
			// click(LP.Logout);
			resultwriteStepsPass("I verify the success in step");
			// RowNo = RowNo + 1;
			// resultWritebook.write();
			// resultWritebook.close();
		} catch (Exception e) {
			resultwriteStepsFail("I verify the success in step", e.getMessage() + "Custom Fail Message",
					"Expected Result");
			// resultWritebook.write();
			// resultWritebook.close();
		}
	}

	@Given("^I want to write the excel reports name(\\d+)$")
	public void i_want_to_write_the_excel_reports_name(int arg1) throws Throwable {
		RowNo = RowNo + 1;
		// autoResizeColumns();
		try {
			// Assert.assertEquals(a, b);
			resultwriteScenario(ScenarioName, "I want to write the excel reports name");
		} catch (Throwable e) {
			System.out.println("Exception Occurred");
			// String ex = throw e;
			resultwriteScenarioFail(ScenarioName, "I want to write the excel reports name",
					e.getMessage() + "Custom Fail Message", "Expected Result");
		}
	}

	@When("^I want to check for the (\\d+) in step$")
	public void i_want_to_check_for_the_in_step(int arg1) throws Throwable {
		try {
			resultwriteStepsPass("I want to check for the...");
		} catch (Exception e) {
			resultwriteStepsFail("I want to check for the....", e.getMessage() + "Custom Fail Message",
					"Expected Result");
		}
	}

	@Given("^I want to write the excel sheet with third test name(\\d+)$")
	public void i_want_to_write_the_excel_sheet_with_third_test_name(int arg1) throws Throwable {
		RowNo = RowNo + 1;
		int a = 1;
		int b = 2;
		// autoResizeColumns();
		try {
			Assert.assertEquals(a, b);
			resultwriteScenario(ScenarioName, "I want to write the excel sheet with third test name");
		} catch (Throwable e) {
			System.out.println("Exception Occurred");
			// String ex = throw e;
			resultwriteScenarioFail(ScenarioName, "I want to write the excel sheet with third test name",
					e.getMessage() + "Custom Fail Message", "Expected Result");
		}
	}

	@When("^I want to check for the third test (\\d+) in step$")
	public void i_want_to_check_for_the_third_test_in_step(int arg1) throws Throwable {
		try {
			// click(LP.Logout);
			resultwriteStepsPass("I want to check for the third test...");
			RowNo = RowNo + 1;
			resultWritebook.write();
			resultWritebook.close();
		} catch (Exception e) {
			resultwriteStepsFail("I want to check for the third test....", e.getMessage() + "Custom Fail Message",
					"Expected Result");
			resultWritebook.write();
			resultWritebook.close();
		}

	}

}
