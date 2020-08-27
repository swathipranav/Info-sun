package com.SecureWatch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FacilityPage;
import utilities.GlobalVariables;
import utilities.WebActions;

public class AddFacilityTypeFunctionality extends WebActions {
	@Test(priority = 1)
	public void addFacilityType() {
		//delay(5);
		isElementDisplayed(By.xpath("//a[contains(text(),'Facility')]"));
		try {
			FacilityPage facility = PageFactory.initElements(driver, FacilityPage.class);
			boolean status = false;
			waitForLoading(By.xpath("//div[starts-with(@class,'loading-position-text')]"));// using the same method
			delay(2);
			GlobalVariables.WEBELEMENTS = driver.findElements(By.xpath("//ul[@id='main-menu-navigation']/li/a"));
			for (int i = 1; i <= GlobalVariables.WEBELEMENTS.size(); i++) {

				GlobalVariables.WEBELEMENT = driver
						.findElement(By.xpath("//ul[@id='main-menu-navigation']/li[" + i + "]/a"));

				if (GlobalVariables.WEBELEMENT.getText().contains("Facility")) {

					click(GlobalVariables.WEBELEMENT, "Facility Tab");
					break;
				}
			}
			GlobalVariables.WEBELEMENTS = driver.findElements(By.xpath("(//ul[@class='dropdown-menu show']/li)"));
			for (int i = 1; i <= GlobalVariables.WEBELEMENTS.size(); i++) {

				GlobalVariables.WEBELEMENT = driver
						.findElement(By.xpath("(//ul[@class='dropdown-menu show']/li)[" + i + "]"));
				if (GlobalVariables.WEBELEMENT.getText().contains("Facility Types")) {
					click(GlobalVariables.WEBELEMENT, "Facility Types Tab");
					status = true;
					break;
				}
			}

			if (status) {

				System.out.println("Facility Types is vailable in the list");
			} else {
				Assert.fail("Facility types is not available in the list");
			}
			click(facility.addFacilityTypeBtn, "Add facility type button");
			GlobalVariables.addedFacility = "Test Facility" + getTimeStamp();
			input(facility.facilityTypeName, GlobalVariables.addedFacility, "Facility Name");
			selectByVisibleText(facility.criticality, " 3 (Medium Low) ", "Criticality Drop Down");// Not selecting the
																									// criticality value
																									// from dropdown
			input(facility.facilityTypeDescription, "Test description", "Facility Description");
			click(facility.facilityTypeSaveBtn, "FacilityType SaveBtn");
			delay(5);
			if (facility.facilityTypeSaveBtn.isDisplayed()) {
				System.out.println("FacilityType name already exists");
			} else {
				System.out.println("Facility type is added successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void verifyAddedFacilityType() {
		FacilityPage facility = PageFactory.initElements(driver, FacilityPage.class);
		jsClick(facility.dataTableDropDownicon, "Drop Down Icon");
		click(facility.maxRecordsInDropdown, "Max Records");
		GlobalVariables.WEBELEMENTS = driver
				.findElements(By.xpath("(//mat-table[@class='mat-table'])[1]/mat-row/mat-cell[2]/span[1]"));
		for (int i = 1; i <= GlobalVariables.WEBELEMENTS.size(); i++) {
			GlobalVariables.WEBELEMENT = driver.findElement(
					By.xpath("(//mat-table[@class='mat-table'])[1]/mat-row[" + i + "]/mat-cell[2]/span[1]"));
			if (GlobalVariables.WEBELEMENT.getText().equals(GlobalVariables.addedFacility)) {

				System.out.println("Facility type is verified successfully in data table");
				break;
			}
		}
	}

	@Test(priority = 3)
	public void editaAddedFacilityType() throws AWTException {
		String xpath = "//span[contains(text(),'$value')]/following::mat-icon[1]";
		GlobalVariables.WEBELEMENT = findObject(xpath, "$value", GlobalVariables.addedFacility);
		click(GlobalVariables.WEBELEMENT, "Edit icon");
		if (facility.facilityTypeSaveBtn.isDisplayed()) {
			System.out.println("Redirected to edit facility type page");
		} else {
			System.out.println("Not redirected to edit facility type page");
		}

		input(facility.facilityTypeDescription, "updated facility type description", "Facility Description");
		click(facility.facilityTypeSaveBtn, "Facility SaveBtn");
		delay(5);
		//click(facility.facilityTypeUpdateNo,"No button While Updating facility type");
		//System.out.println("Facility type description is updated");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public String getPaginationNumber() {
		waitForElementVisibility(facility.paginationnumber);
		return getText(facility.paginationnumber).split("of")[1].trim();
	}

	@Test(priority = 4)
	public void toDeleteAddedFacilityType() {
		for (int i = 1; i <= 100; i++) {
			if (!isElementDisplayed(facility.savebtn1)) {
				break;
			}
		}
		jsClick(facility.dataTableDropDownicon, "Drop Down Icon");
		click(facility.maxRecordsInDropdown, "Max Records");
		String xpath = "//span[contains(text(),'$value')]/following::mat-icon[2]";
		GlobalVariables.WEBELEMENT = findObject(xpath, "$value", GlobalVariables.addedFacility);
		click(GlobalVariables.WEBELEMENT, "Delete icon");
		GlobalVariables.paginationCount = Integer.parseInt(getPaginationNumber());
		if (isElementDisplayed(facility.deleteYesBtn)) {
			System.out.println("Delete confirmation popup is displayed");
		} else {
			System.out.println("Delete confirmation popup is displayed");
		}
		click(facility.deleteYesBtn,"YesBtn");
		int i = 1;
		while (Integer.parseInt(getPaginationNumber()) == GlobalVariables.paginationCount) {
			if (i == 50) {
				break;
			}
			System.out.println("Iteration Count " + i);
			i++;
		}
		if (Integer.parseInt(getPaginationNumber()) != GlobalVariables.paginationCount) {
			System.out.println(GlobalVariables.addedFacility + " is deleted successfully");
		} else {
			Assert.fail(GlobalVariables.addedFacility + " is not deleted");
		}
	}

}
