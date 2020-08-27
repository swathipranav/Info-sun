package com.SecureWatch;

import java.util.List;

//div[@class='toast-title ng-star-inserted'] - error msg of delete facility type

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.GlobalVariables;
import utilities.WebActions;

public class DeleteAllFacilityTypes extends WebActions{
	@Test()
	public void toDeleteAllFacilityTypes() {
		
		boolean status = false;
		waitForLoading(By.xpath("//div[starts-with(@class,'loading-position-text')]"));// using the same method
		delay(2);
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
			if (ele.getText().contains("Facility Types")) {
				delay(1);
				ele.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("FacilityType is available");
		} else {
			System.out.println("Failed -- FacilityType is not available in the facility list");
		}
		waitForElementVisibility(facility.dataTableDropDownicon);
		jsClick(facility.dataTableDropDownicon, "Drop Down Icon");
		click(facility.maxRecordsInDropdown, "Max Records");
		GlobalVariables.WEBELEMENTS = findObjects("//span[contains(text(),'${value}')]/following::mat-icon[2]",
				"${value}", "Test");
		for(WebElement ele:GlobalVariables.WEBELEMENTS) {
			
			GlobalVariables.WEBELEMENT=driver.findElement(By.xpath("(//span[contains(text(),'Test')]/following::mat-icon[2])[1]"));
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
