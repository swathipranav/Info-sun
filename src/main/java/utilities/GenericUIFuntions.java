package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class GenericUIFuntions extends WebActions {

	public void waitForInvisibilityOfSaveButton() {
		for (int i = 1; i <= 100; i++) {
			if (!isElementDisplayed(facility.savebtn1)) {
				break;
			}
		}
	}

	public void clickPreferredOption(List<WebElement> webelementlist, String expected) {
		boolean status = false;
		try {
			for (WebElement element : webelementlist) {
				if (getText(element).equals(expected)) {
					click(element, expected);
					status = true;
					break;
				}
			}
			if (status) {
				logger.log(Status.INFO, "Clicked On " + expected);
			} else {
				Assert.fail(expected + " is not available");
			}
		} catch (Exception e) {
		}
	}

	public void clickPreferredOption(List<WebElement> webelementlist, String xpath,String source,String expected) {
		boolean status = false;
		try {
			for (int i = 1; i <= webelementlist.size(); i++) {
				GlobalVariables.WEBELEMENT = findObject(xpath, source, String.valueOf(i));
				System.out.println(getText(GlobalVariables.WEBELEMENT));
				if (getText(GlobalVariables.WEBELEMENT).equals(expected)) {
					click(GlobalVariables.WEBELEMENT, expected);
					status = true;
					break;
				}
			}
			if (status) {
				logger.log(Status.INFO, "Clicked On "+expected);
			} else {
				Assert.fail(expected+" is not available");
				;
			}
		} catch (Exception e) {
		}
	}

}
