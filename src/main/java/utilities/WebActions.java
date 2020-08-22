package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WebActions extends DriverInit {

	public void input(WebElement ele, String data, String fieldName) {
		waitForElementVisibility(ele);
		try {
			if (ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(data);
				System.out.println("Entered " + data + " in " + fieldName);
			} else {
				System.out.println(fieldName + " is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement ele, String fieldName) {
		waitForElementVisibility(ele);
		try {
			if (ele.isDisplayed()) {
				ele.click();
				System.out.println("Clicked On " + fieldName);
			} else {
				System.out.println(fieldName + " is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectByVisibleText(WebElement ele, String data, String fieldName) {
		waitForElementVisibility(ele);
		try {
			if (ele.isDisplayed()) {
				new Select(ele).selectByVisibleText(data);
				System.out.println("Selected " + data + " from " + fieldName);
			} else {
				System.out.println(fieldName + " is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement findObject(String xpath, String source, String replace) {
		return driver.findElement(By.xpath(xpath.replace(source, replace)));
	}

	public List<WebElement> findObjects(String xpath, String source, String replace) {
		return driver.findElements(By.xpath(xpath.replace(source, replace)));
	}

	public void waitForLoading() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loading-icon']")));
	}

	public void waitForLoading(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForElementVisibility(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void delay(int i) {
		try {
			i = i * 1000;
			Thread.sleep(i);
		} catch (Exception e) {
		}
	}

	public void waitForElementToLoadInDOM(WebElement ele) {
		try {
			for (int i = 1; i <= 500; i++) {
				Thread.sleep(5);
				if (ele.isDisplayed() && ele.isEnabled()) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Waiting for the Element Load Completely");
		}
	}

}
