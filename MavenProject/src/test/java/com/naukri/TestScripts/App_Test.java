package com.naukri.TestScripts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.naukri.MavenProject.GenericActions;
import com.naukri.Pages.nLogin;
import com.naukri.Pages.updateProfile;

public class App_Test {
	
	@Test
	public void test() {
		try {
			nLogin.preCondition();
			nLogin.loginApplication();
			Thread.sleep(5000);
			Actions act= new Actions(GenericActions.driver);
			WebElement hoverItem = GenericActions.getWebElement("myNaukri");
			Thread.sleep(3000);
			
			act.moveToElement(hoverItem).build().perform();
			WebElement hoverbox = GenericActions.getWebElement("myNaukriBox");
			List<WebElement> dropdownlists =hoverbox.findElements(By.tagName("a"));
		    for(int i=0;i<dropdownlists.size();i++) {
		    	String actualvalue = dropdownlists.get(i).getText();
		    	System.out.println(actualvalue);
		    	if(actualvalue.equalsIgnoreCase("Edit Profile")) {
		    		dropdownlists.get(i).click();
		    		break;
		    	}
		    }
		    updateProfile.updateinfo();
			
			
			
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
	public static void main(String args[]) {
		App_Test test = new App_Test();
		test.test();
		
		
}
}

