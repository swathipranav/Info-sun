package com.SecureWatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.FacilityPage;
import pageObjects.LoginPage;
import utilities.GlobalVariables;
import utilities.WebActions;

public class Login extends WebActions {

	@Test(priority = 1)
	public void addRegionForFacility() {
		try {
			boolean status = false;
			waitForLoading(By.xpath("//div[starts-with(@class,'loading-position-text')]"));// using the same method
			delay(2);
			// jsClick(findObject(facility.menuname, "${value}", "Facility"), "Facility");
			GlobalVariables.WEBELEMENTS = driver.findElements(By.xpath("//ul[@id='main-menu-navigation']/li"));
			for (int i = 1; i <= GlobalVariables.WEBELEMENTS.size(); i++) {
				GlobalVariables.WEBELEMENT = driver
						.findElement(By.xpath("//ul[@id='main-menu-navigation']/li[" + i + "]"));
				if (getText(GlobalVariables.WEBELEMENT).contains("Facility")) {
					click(GlobalVariables.WEBELEMENT, "Facility");
					break;
				}
			}
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
			click(facility.addRegionTab, "Add RegionTab");
			GlobalVariables.addedRegion = "Hyderabad Region" + getTimeStamp();
			input(facility.regionName, GlobalVariables.addedRegion, "Region Name");
			input(facility.description, "Describing the region", "Region Description");
			click(facility.saveBtn, "AddRegionSaveButton");
			delay(5);
			if (isElementDisplayed(facility.savebtn1)) {
				Assert.fail("Region is duplicate. Kindly add new region");
			} else
				System.out.println("Region is added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2, dependsOnMethods = "addRegionForFacility")
	public void verifyAddedRegion() {
		jsClick(driver.findElement(By.xpath(
				"(//div[@class='mat-paginator-page-size-label']/following::div[@class='mat-select-arrow-wrapper'])[1]")),
				"Drop down");
		click(driver.findElement(By.xpath("//mat-option[starts-with(@class,'mat-option')][last()]/span")),
				"Max Records");
		List<WebElement> Completetablecontent = driver
				.findElements(By.xpath("(//mat-table[@class='mat-table'])[1]/mat-row/mat-cell[2]/span[1]"));
		for (int i = 1; i <= Completetablecontent.size(); i++) {
			WebElement tabledata = driver.findElement(
					By.xpath("(//mat-table[@class='mat-table'])[1]/mat-row[" + i + "]/mat-cell[2]/span[1]"));
			String rowdata = tabledata.getText();
			if (rowdata.equals(GlobalVariables.addedRegion)) {
				System.out.println("Verified the added region");
				break;
			}
		}
	}

	@Test(priority = 3, dependsOnMethods = "verifyAddedRegion")
	public void toEditRegionDetails() {
		GlobalVariables.WEBELEMENT = findObject("//span[contains(text(),'${value}')]/following::mat-icon[1]",
				"${value}", GlobalVariables.addedRegion);
		click(GlobalVariables.WEBELEMENT, "Edit Icon");
		System.out.println("Edit region page is opened");
		if (isElementDisplayed(facility.savebtn1)) {
			System.out.println("Redirected to Edit Page");
		} else
			Assert.fail("Redirected to edit page is failed");
		input(facility.description, "description in edit region screen", "Region Description");
		click(facility.saveBtn, "Region SaveBtn");
		System.out.println("Region description is updated");
	}

	@AfterMethod
	public void verifyTestStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getName()+ "------ Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Fail");
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("Skipped");
		}
		// driver.close();
	}

}
