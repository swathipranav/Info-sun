package com.SecureWatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
static WebDriver driver;
	
	static WebDriverWait wait;

	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "./Chrome/chromdriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://infos2307.riskwatch.com/platform");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loading-icon']")));
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("swathik@info-sun.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Info-123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
