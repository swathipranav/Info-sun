package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='username']")
	public WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//img[@class='loading-icon']")
	public WebElement loadicon;

}
