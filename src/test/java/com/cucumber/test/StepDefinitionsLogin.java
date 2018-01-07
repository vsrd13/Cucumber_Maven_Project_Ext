package com.cucumber.test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.utils.Datahelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionsLogin {

	public List<HashMap<String, String>> data;

	public WebDriver driver;

	public StepDefinitionsLogin() {
		super();
		data = Datahelper.data(System.getProperty("user.dir") + "\\TestScript.xlsx", "UserRegistration");
	}

	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kumar\\workspace6\\Cucumber_Maven_Project_Ext\\BroswerDirvers\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("htts://www.google.com");
	}

	@When("^some other precondition$")
	public void some_other_precondition() throws Throwable {
		driver.quit();
	}

	@Then("^I complete action$")
	public void i_complete_action() throws Throwable {

	}

}
