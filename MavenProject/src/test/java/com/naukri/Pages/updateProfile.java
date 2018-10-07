package com.naukri.Pages;

import org.openqa.selenium.WebElement;

import com.naukri.MavenProject.GenericActions;

public class updateProfile {

	public static void updateinfo() {
		try {
		//	GenericActions.getWebElement("myNaukri").click();
		//  GenericActions.getWebElement("EditProfile").click();
			
			GenericActions.HoverSelect("myNaukri", "EditList");
			GenericActions.iwait(10000);
			boolean verifyupdatePage = GenericActions.VerifyPage1("ResumeHeadlinetxt");
			 if(verifyupdatePage= true) {
				 GenericActions.getWebElement("ResumeHeadlineEdit").click();
				 WebElement formContent = GenericActions.getWebElement("EditContentbox");
				 String content = formContent.getText();
				 String updatedContent = content.replace(".", ".");
				
				 GenericActions.getWebElement("Savebtn").click();
				 
			 }
			 else {
				 System.out.println("Unable to laod Edit profile page");
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
}
