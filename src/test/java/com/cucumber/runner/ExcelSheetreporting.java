package com.cucumber.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, features = { "src/test/resources/excelsheet.feature" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:", }, glue = { "com.cucumber.test" }, dryRun = false)
public class ExcelSheetreporting extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void setUp() {
		System.out.println("Before Class...!");
	}

	@AfterClass
	public static void reportSetup() {
		System.out.println("After Class...!");
	}

	@Test
	public void test() {
		System.out.println("Sample test...!");
	}

}
