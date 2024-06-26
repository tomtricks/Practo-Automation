package testSuites;


import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.CorporateWellness;
import pages.HospitalNames;
import pages.TopCities;

public class TestCases extends Base {
	HospitalNames hn = new HospitalNames();
	TopCities tc = new TopCities();
	CorporateWellness ca = new CorporateWellness();

	@BeforeTest
	public void invokeBrowser() throws IOException {
		logger = report.createTest("Executing Test Cases");
		hn.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void hospitalNames() throws InterruptedException {

		hn.openURL("websiteURLKey");
		reportPass("URL is Opened");
		hn.selectCity();
		hn.cityDropDown();
		hn.selectHospital();
		hn.hospitalDropDown();
		hn.validation();
		hn.printTheValidatedDetails();
		reportPass("Hospitals are Retrieved");
	}

	@Test(priority = 2)
	public void TopCities() {
		hn.openURL("websiteURLKey");
		reportPass("Navigated Back to the Home Page");
		tc.getCities();
		reportPass("Top Cities are retrieved");
	}

	@Test(priority = 3)
	public void corporateWellness() throws InterruptedException, IOException {
		tc.openURL("websiteURLKey");
		reportPass("Navigated Back to the Home Page");
		ca.formFill();
		reportPass("Data is entered succesfully");
	}

	@AfterTest
	public void closeBrowser() {
		ca.endReport();
		ca.closeBrowser();
	}

}

