package utilities;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.FacilityPage;
import pageObjects.LoginPage;

public class WebActions extends DriverInit {

	@BeforeClass(alwaysRun = true)
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loadPages();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://infos2307.riskwatch.com/platform");
		waitForLoading();
		login();
	}

	public void login() {
		input(login.username, "swathik@info-sun.com", "User Name");
		input(login.password, "Info-123", "Password");
		click(login.submitBtn, "Login");
		waitForLoading(By.xpath("//*[@class='ng-star-inserted']"));// ....1
		waitForLoading();
		waitForElementVisibility(login.tutorialframe);
		delay(5);
		driver.switchTo().frame(login.tutorialframe);
		click(login.tutorialbtn, "Tutorial Button");
		driver.switchTo().defaultContent();
	}

	public void loadPages() {
		facility = new FacilityPage(driver);
		login = new LoginPage(driver);
	}

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
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath(xpath.replace(source, replace)));
		} catch (Exception e) {
		}
		return ele;
	}

	public List<WebElement> findObjects(String xpath, String source, String replace) {
		return driver.findElements(By.xpath(xpath.replace(source, replace)));
	}

	public void waitForLoading() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loading-icon']")));
		} catch (Exception e) {
			System.out.println("Loading Element not visible");
		}
	}

	public String getText(WebElement ele) {
		return ele.getText().trim();
	}

	public void waitForLoading(By by) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Loading Element not visible");
		}
	}

	public void waitForElementVisibility(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Loading Element not visible");
		}
	}

	public void delay(int i) {
		try {
			i = i * 1000;
			Thread.sleep(i);
		} catch (Exception e) {
		}
	}

	public String getTimeStamp() {
		return LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "").replace("T", "")
				.trim();
	}

	public boolean isElementDisplayed(WebElement ele) {
		boolean status = false;
		try {
			if (ele.isDisplayed()) {
				status = true;
			}
		} catch (Exception e) {
		}
		return status;
	}

	public boolean isElementDisplayed(By ele) {
		boolean status = false;
		List<WebElement> elements = driver.findElements(ele);
		try {
			if (elements.size() > 0) {
				status = true;
			}
		} catch (Exception e) {
		}
		return status;
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

	public void jsClick(WebElement ele, String fieldName) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("Clicked on " + fieldName);
	}

}
