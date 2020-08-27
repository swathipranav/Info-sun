package com.SecureWatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.GlobalVariables;
import utilities.WebActions;

public class DeleteAllRegions extends WebActions {

	@Test()
	public void toDeleteAllRegions() {
		boolean status = false;
		waitForLoading(By.xpath("//div[starts-with(@class,'loading-position-text')]"));// using the same method
		delay(2);
		/*
		 * click(findObject(facility.menuname, "${value}", "Facility"), "Facility Tab");
		 * GlobalVariables.WEBELEMENTS = findObjects(facility.menulist, "${value}",
		 * "Facility"); for (WebElement ele : GlobalVariables.WEBELEMENTS) { if
		 * (ele.getText().contains("Region")) { click(ele, "RegionTab"); status = true;
		 * //break; } if (status) {
		 * 
		 * System.out.println("Region is available"); } else {
		 * Assert.fail("Region is not available in the list"); } }
		 */
		GlobalVariables.WEBELEMENTS = facility.mainMenuNavigation;
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
				delay(1);
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
		
		//delay(3);
		
		waitForElementVisibility(facility.dataTableDropDownicon);

		jsClick(facility.dataTableDropDownicon, "Drop Down Icon");
		click(facility.maxRecordsInDropdown, "Max Records");
		GlobalVariables.WEBELEMENTS = findObjects("//span[contains(text(),'${value}')]/following::mat-icon[2]",
				"${value}", "Hyderabad");
		for (WebElement ele : GlobalVariables.WEBELEMENTS) {
			GlobalVariables.WEBELEMENT = driver
					.findElement(By.xpath("(//span[contains(text(),'Hyderabad')]/following::mat-icon[2])[1]"));
			scrollIntoElement(GlobalVariables.WEBELEMENT);
			jsClick(GlobalVariables.WEBELEMENT, "Delete icon");
			if (isElementDisplayed(facility.deleteYesBtn)) {
				System.out.println("Delete icon is clicked");
			} else {
				Assert.fail("Delete icon is not clicked");
			}
			click(driver.findElement(By.xpath("//span[contains(text(),'Yes')]")), "YesBtn");
			delay(5);
		}
		

	}

}
