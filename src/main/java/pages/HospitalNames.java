package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class HospitalNames extends Base {
	List<Float> ratingNew;
	List<String> allHoursNew;
	List<String> hospitalNamesNew;

	public void selectCity() {
		WebElement city = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']"));
		city.clear();
		city.sendKeys("Banglore");
	}

	public void cityDropDown() throws InterruptedException {

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@data-qa-id='omni-suggestion-city'][1]//span[@class='c-omni-suggestion-item__content']")));
		driver.findElement(By
				.xpath("//div[@data-qa-id='omni-suggestion-city'][1]//span[@class='c-omni-suggestion-item__content']"))
				.click();

	}

	public void selectHospital() {
		WebElement hospital = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-keyword']"));
		hospital.clear();
		hospital.sendKeys("Hospital");
	}

	public void hospitalDropDown() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='c-omni-suggestion-group']/div[2]/span//div[text()='Hospital']")));
		driver.findElement(By.xpath("//div[@class='c-omni-suggestion-group']/div[2]/span//div[text()='Hospital']"))
				.click();
	}

	public void validation() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 3000)");
//		storing the elements into list

		for (int p = 1; p <= 4; p++) {

			String s = String.format(

					"(//div[@class=\'c-estb-card\'])[%d]/div[2]/div[1]/a", p * 10);

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,1000)", "");

			js.executeScript("window.scrollBy(0,1700)", "");

		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='c-estb-info']/a")));
		List<WebElement> hospitalNames = driver.findElements(By.xpath("//div[@class='c-estb-info']/a"));
		List<WebElement> allHours = driver.findElements(By.xpath("//span[@class='uv2-spacer--lg-left']//span"));
		List<WebElement> rating = driver.findElements(By.xpath("//div[@class='text-1']/SPAN[1]"));
		// changing the list datatype
		ratingNew = new ArrayList<Float>();
		allHoursNew = new ArrayList<String>();
		hospitalNamesNew = new ArrayList<String>();

		for (WebElement element1 : allHours) {
			String value1 = element1.getText();
			allHoursNew.add(value1);
		}
		for (WebElement element : rating) {
			String texts = element.getText();
			Float value = Float.parseFloat(texts);
			ratingNew.add((float) value);
		}

		for (WebElement element2 : hospitalNames) {
			String value2 = element2.getText();
			hospitalNamesNew.add(value2);
		}
	}

	public void printTheValidatedDetails() throws InterruptedException {
		System.out.println("-----------------------");
		System.out.println("The 24/7 Hospitals are");
		Thread.sleep(5000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 3000)");

		for (int i = 0; i < ratingNew.size(); i++) {

			if (allHoursNew.get(i).equals("MON - SUN 00:00AM - 11:59PM") && ratingNew.get(i) > 3.5) {

				System.out.println(hospitalNamesNew.get(i));
			}
		}

	}
}
