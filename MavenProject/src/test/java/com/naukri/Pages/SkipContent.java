package com.naukri.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.MavenProject.GenericActions;

public class SkipContent {

	public static void skipUnwanted() {
		WebElement Skipbtn = GenericActions.driver.findElement(By.xpath("//*[@value =\"Skip and Continue\"]"));
		
		if (Skipbtn.isDisplayed()) {
			Skipbtn.click();
			
		}
		
	}
}
