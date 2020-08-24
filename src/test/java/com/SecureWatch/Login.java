package com.SecureWatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.FacilityPage;
import pageObjects.LoginPage;
import utilities.WebActions;

public class Login extends WebActions {

	@BeforeMethod
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://infos2307.riskwatch.com/platform");
		waitForLoading();
		login();
	}

	public void login() {
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		input(login.username, "swathik@info-sun.com", "User Name");
		input(login.password, "Info-123", "Password");
		click(login.submitBtn, "Login");
		waitForLoading(By.xpath("//*[@class='ng-star-inserted']"));//....1
		waitForLoading();
	}

	@Test
	public void AddRegionForFacility() {
		
		boolean status = false;
		
		FacilityPage facility = PageFactory.initElements(driver, FacilityPage.class);
		
		waitForLoading(By.xpath("//div[starts-with(@class,'loading-position-text')]"));//using the same method passing different xpath
		
		delay(5);
		
		click(findObject(facility.menuname, "${value}", "Facility"), "Facility");

		List<WebElement> facilityNames = findObjects(facility.menulist, "${value}", "Facility");

		for (WebElement ele : facilityNames) {

			if (ele.getText().contains("Region")) {
				ele.click();
				status = true;
				break;
			}
		}

		if (status) {
			System.out.println("Region is available");
			
		} else {
			System.out.println("Failed -- Region is not available in the facility list");
		}
		
		waitForLoading(By.xpath("//*[@class='ng-star-inserted']")); 
		click(facility.addRegionTab,"Add RegionTab");
		input(facility.regionName,"Hyderabad Region","Region Name");
		input(facility.description,"Describing trhe hyderabad region","Region Description");
		click(facility.saveBtn,"AddRegionSaveButton");
		System.out.println("Region is added");
		
		

	}
	
	

	@AfterMethod
	public void verifyTestStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {

			System.out.println("Pass");

		} else if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Fail");

		} else if (result.getStatus() == ITestResult.SKIP) {

			System.out.println("Skipped");

		}
		// driver.close();
	}

}
