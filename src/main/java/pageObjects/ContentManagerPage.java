package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;
import utilities.WebActions;

public class ContentManagerPage extends WebActions {

	public ContentManagerPage(WebDriver driver) {
		DriverInit.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Content Manager')]/following-sibling::ul/li/a")
	public List<WebElement> contentmanageroptions;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Vulnerability')]")
	public WebElement addvulnerabilitybtn;

	@FindBy(how = How.XPATH, using = "//input[starts-with(@placeholder,'Vulnerability')]")
	public WebElement inputvulnerability;

	@FindBy(how = How.XPATH, using = "//textarea")
	public WebElement vulnerabilitydescription;

	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	public WebElement savevulnerability;

}
