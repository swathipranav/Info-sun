package com.SecureWatch;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.GlobalVariables;
import utilities.WebActions;

public class RiskWatch extends WebActions {
	
	@Test
	public void verifyRiskWatchRedirection(){
		
		delay(5);
		
		GlobalVariables.parentwindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='RiskWatch International']")).click();
		
		GlobalVariables.allwindows = driver.getWindowHandles();
		
		Iterator<String> ite = GlobalVariables.allwindows.iterator();
		
		while(ite.hasNext()) {
			
			GlobalVariables.childwindow = ite.next();
			
			if(!GlobalVariables.parentwindow.equals(GlobalVariables.childwindow)) {
				
				driver.switchTo().window(GlobalVariables.childwindow);
				
				System.out.println(driver.getTitle());
				
				driver.close();
			}
		}
		
		driver.switchTo().window(GlobalVariables.parentwindow);
		
	}

}
