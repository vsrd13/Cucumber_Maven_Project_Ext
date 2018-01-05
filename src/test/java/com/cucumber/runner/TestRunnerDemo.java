package com.cucumber.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(strict = true, features = { "src/test/resources/login.feature" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:" }, glue = { "com.cucumber.test" }, dryRun = false)
public class TestRunnerDemo extends AbstractTestNGCucumberTests {

	// C:\Users\Kumar\workspace6\Cucumber_Maven_Project_Ext\Reports

	@BeforeClass
	public void setUp() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		// extentProperties.setExtentXServerUrl("http://localhost:1337");
		// extentProperties.setProjectName("TestNGProject");
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		File file = new File(".//");
		extentProperties.setReportPath("output/myreport" + strDate + ".html");

		// ExtentCucumberFormatter.initiateExtentCucumberFormatter();
	}

	/*
	 * SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss"); Date
	 * curDate = new Date(); String strDate = sdf.format(curDate); File file =
	 * new File(".//"); String fileName = file.getCanonicalPath() +
	 * "\\ExtenReports\\report" + strDate + ".html";
	 */

	@AfterClass
	public static void reportSetup() {
		/*
		 * // ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		 * SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss"); Date
		 * curDate = new Date(); String strDate = sdf.format(curDate); File file
		 * = new File(".//"); String fileName = file.getCanonicalPath() +
		 * "\\ExtenReports\\report" + strDate + ".html"; File newFile = new
		 * File(fileName);
		 * ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,
		 * false); // Loads the extent config xml to customize on the report. //
		 * ExtentCucumberFormatter.loadConfig(new File(file.getCanonicalPath() +
		 * // "//config//extent-config.xml"));
		 * 
		 * Reporter.
		 */

		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		/*
		 * Properties p = System.getProperties(); p.list(System.out);
		 */

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("64 Bit", "Windows 10");
		Reporter.setSystemInfo("2.53.0", "Selenium");
		Reporter.setSystemInfo("3.3.9", "Maven");
		Reporter.setSystemInfo("1.8.0_66", "Java Version");
		Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");

	}

	@Test
	public void test() {
		System.out.println("Sample test...!");
	}

	@AfterSuite
	public void generateReport() {
		/*
		 * JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
		 * jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		 * jpegParams.setCompressionQuality(1f); try {
		 * Xl.generateReport("Report_Excel.xlsx"); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
