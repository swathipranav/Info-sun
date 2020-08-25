package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;
import utilities.WebActions;

public class FacilityPage extends WebActions {
	
	public FacilityPage(WebDriver driver) {
		DriverInit.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

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

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Description about the Region']")
	public WebElement description;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	public WebElement saveBtn;
	
	public By savebtn1 = By.xpath("//span[contains(text(),'Save')]");

	@FindBy(how = How.XPATH, using = " //button[@type='button']")
	public WebElement CancelBtn;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Filter')]")
	public WebElement filterBtn;

	@FindBy(how = How.XPATH, using = "//button[@mattooltip='Download data']/span/i")
	public WebElement downloadIcon;
	
	public String regionEditIcon = "(//mat-icon[contains(text(),'create')])[$value]";// (//mat-table[@class='mat-table'])[1]/mat-row/mat-cell[4]//mat-icon

	@FindBy(how = How.XPATH, using = "//mat-icon[contains(text(),'delete')]")
	public WebElement deleteIcon;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Events ')]/a/i")
	public WebElement EventsIcon;

	@FindBy(how = How.XPATH, using = "//mat-icon[text()='zoom_in']")
	public WebElement viewDetailsIcon;

	@FindBy(how = How.XPATH, using = "//button[text()='Add Facility Type']")
	public WebElement addFacilityTypeBtn;



	public WebElement findObject(String xpath, String source, String replace) {
		return driver.findElement(By.xpath(xpath.replace(source, replace)));
	}

	public void test() {
		findObject(menuname, "${value}", "Facility").click();
	}

}
