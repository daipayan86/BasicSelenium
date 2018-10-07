package com.naukri.Pages;

import org.openqa.selenium.WebElement;

import com.naukri.MavenProject.ConfigReader;
import com.naukri.MavenProject.GenericActions;



public class nLogin {
	
	
	
	public static void preCondition() {
		GenericActions.runBrowsers("");
		GenericActions.iwait(5000);
	}
	
	
	
	public static void loginApplication() {
		try {

				ConfigReader obj = new ConfigReader();
				
				GenericActions.manageWindowHandles();
				GenericActions.driver.manage().window().maximize();
				GenericActions.iwait(10000);
				
				WebElement Login = GenericActions.getWebElement("loginlink");
				Login.click();
				
			//	WebDriverWait wait = new WebDriverWait(GenericActions.driver, 1000);
			//	wait.until(ExpectedConditions.visibilityOf(Login));
						
			//	GenericActions.iwait(50000);
				Thread.sleep(3000);
				
			//	WebElement loginform = GenericActions.getWebElement("loginframe1");
				
				
			//	Actions act = new Actions(GenericActions.driver);
			//	act.moveToElement(loginform).perform();
				
				
				WebElement username = GenericActions.getWebElement("username");
				//username.sendKeys("daipayan.sarkar.25@gmail.com");
				username.sendKeys(obj.loadproperty("uname"));
				
				WebElement password = GenericActions.getWebElement("password");
				password.sendKeys(obj.loadproperty("pass"));
				
				WebElement btnLogin = GenericActions.getWebElement("loginbtn");
				btnLogin.click();
				GenericActions.iwait(10000);
				}
						
		 catch (Exception e) {
			
			e.getMessage();
		}
		
		
		
	}
}
