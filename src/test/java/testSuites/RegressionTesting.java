package testSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.CorporateWellness;
import pages.HospitalNames;
import pages.TopCities;

public class RegressionTesting extends Base{
	
		HospitalNames hn = new HospitalNames();
		TopCities tc = new TopCities();
		CorporateWellness ca = new CorporateWellness();

		@BeforeTest
		public void invokeBrowser() throws IOException {
			hn.invokeBrowser();
			hn.openURL("websiteURLKey");
		}
		@Test
		public void testing() throws InterruptedException, IOException {
			hn.openURL("websiteURLKey");
			tc.getCities();
			tc.openURL("websiteURLKey");			
			ca.formFill();
			
		}
		@AfterTest
		public void closeBrowser() {
			ca.closeBrowser();
		}
}
	
