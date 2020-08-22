package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.WebActions;

public class FacilityPage extends WebActions {

	

	public String menuname = "(//a[contains(text(),'${value}')])[1]";
	public String menulist = "//a[contains(text(),'${value}')]/following::ul/li/a";

	@FindBy(how = How.XPATH, using = "")
	public WebElement facilityTab;

	@FindBy(how = How.XPATH, using = "")
	public WebElement regionTab;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Region')]")
	public WebElement addRegionTab;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Region *']")
	public WebElement regionName;

	@FindBy(how = How.XPATH, using = "//textarea[@id='mat-input-3']")
	public WebElement description;

	@FindBy(how = How.XPATH, using = "//span[@class='mat-button-wrapper']")
	public WebElement saveBtn;

	@FindBy(how = How.XPATH, using = " //button[@type='button']")
	public WebElement CancelBtn;

	@FindBy(how = How.XPATH, using = "")
	public WebElement filterBtn;

	@FindBy(how = How.XPATH, using = "")
	public WebElement downloadIcon;

	

}
