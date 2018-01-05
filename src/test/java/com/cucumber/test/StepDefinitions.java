package com.cucumber.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.cucumber.utils.Datahelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Listeners(InvokedMethodListener.class)
public class StepDefinitions {

	public List<HashMap<String, String>> logindata;

	public StepDefinitions() {
		logindata = Datahelper.data(System.getProperty("user.dir") + "\\TestScript.xlsx", "UserRegistration");
	}

	public static WebDriver driver;

	@Given("^User navigates to URL with excel row \"([^\"]*)\" dataset$")
	public void user_navigates_to_URL_with_excel_row_dataset(String row_index) throws Throwable {
		/*
		 * int index = Integer.parseInt(row_index) - 1;
		 * System.out.println("\n---------------------------------------------")
		 * ;
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Kumar\\workspace6\\Cucumber_Maven_Project_Ext\\BroswerDirvers\\chromedriver.exe"
		 * ); driver = new ChromeDriver(); //
		 * System.out.println(logindata.get(index).get("UserName"));
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.get(logindata.get(index).get("URL"));
		 * 
		 * System.out.println("\n" + logindata.get(index).get("URL"));
		 * driver.quit();
		 * 
		 * 
		 */

		int a = 1;
		int b = 2;
		String str = "Failure: I was expecting %d to be equal to %d";

		Assert.assertTrue(a == b, String.format(str, a, b));

	}

	public static String shortenedStackTrace(Exception e, int maxLines) {
		// TODO Auto-generated method stub
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		String[] lines = writer.toString().split("\n");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.min(lines.length, maxLines); i++) {
			sb.append(lines[i]).append("\n");
		}
		return sb.toString();

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
	}

	@Then("^click on signIn button$")
	public void click_on_signIn_button() throws Throwable {

	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {

	}

}
