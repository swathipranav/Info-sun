package utilities;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.ContentManagerPage;
import pageObjects.FacilityPage;
import pageObjects.LoginPage;
import testData.ReadDataFromExcel;

public class DriverInit extends Reports{

	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor executor;

	public static GenericUIFuntions genericUIFuntions; 
	// initiate Page Objects

	public static FacilityPage facility = null;
	public static LoginPage login = null;
	public static ContentManagerPage contentManagerPage = null;
	

	public static Map<String, String> addFacilityType = null;
	

	public static void loadTestData() {
		
		addFacilityType = ReadDataFromExcel.getDataFromExcel("TestData", "AddFacilityType");
		
	}
}
