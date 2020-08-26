package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import pageObjects.FacilityPage;
import pageObjects.LoginPage;

public class DriverInit {

	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor executor;

	// initiate Page Objects

	public static FacilityPage facility = null;
	public static LoginPage login = null;

	
	

}
