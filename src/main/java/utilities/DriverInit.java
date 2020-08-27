package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FacilityPage;
import pageObjects.LoginPage;

public class DriverInit extends Reports{

	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor executor;

	public static GenericUIFuntions genericUIFuntions; 
	// initiate Page Objects

	public static FacilityPage facility = null;
	public static LoginPage login = null;
	

	
	

}
