package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.DriverInit;

public class FacilityPage extends DriverInit{
	
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='username']")
	public WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter Password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	public WebElement submitBtn;
	
	@FindBy(how=How.XPATH,using="//img[@class='loading-icon']")
	public WebElement loadicon;
	
	
	public String menuname = "(//a[contains(text(),'${value}')])[1]";
	public String  menulist = "//a[contains(text(),'${value}')]/following::ul/li/a";
	
	
	@FindBy(how=How.XPATH,using="")
	public WebElement facilityTab;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement regionTab;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Add Region')]")
	public WebElement addRegionTab;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Region *']")
    public WebElement regionName;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='mat-input-3']")
	public WebElement description;
	
	@FindBy(how=How.XPATH,using="//span[@class='mat-button-wrapper']")
	public WebElement saveBtn;
	
	@FindBy(how=How.XPATH,using=" //button[@type='button']")
	public WebElement CancelBtn;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement filterBtn;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement downloadIcon;
	
	
	public WebElement findObject(String xpath,String source,String replace) {
		return driver.findElement(By.xpath(xpath.replace(source,replace)));
	}
	
	public void test() {
		findObject(menuname, "${value}", "Facility").click();
	}


}
