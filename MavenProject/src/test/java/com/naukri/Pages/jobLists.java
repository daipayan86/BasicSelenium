package com.naukri.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.MavenProject.GenericActions;

public class jobLists {
	
	public static void searchCriteria()  {
		
		try {
			
			GenericActions.iwait(20000);
			GenericActions.getWebElement("searchbtn").click();
			//WebElement searchbox = GenericActions.getWebElement("searchxpath");
			
			
			//searchbox.click();
			
			WebElement searchbySkill= GenericActions.driver.findElement(By.xpath("//*[@placeholder =\"Search jobs by Skills, Designation, Companies\"]"));
			searchbySkill.sendKeys("Test Lead");
			GenericActions.iwait(20000);
			
			WebElement bylocation = GenericActions.driver.findElement(By.xpath("//*[@id=\"qsb-location-sugg\"]"));
			bylocation.sendKeys("Bengaluru");
			GenericActions.iwait(20000);
			
			GenericActions.Select_bootstrapEle("Expid", "Expdrpxpath", "9 Years");				
			GenericActions.iwait(20000);
			GenericActions.getWebElement("searchbtn").click();
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	public static void sortsearchresults() {
		GenericActions.dropdownMouseHover("sortresult", "sortresLists", "Date");
	}

	
	public static void ClickonEachJobLink() {
		try {
			String handle = GenericActions.driver.getWindowHandle();
			List<WebElement> jobLinks = GenericActions.getWebLists("joblinks");
			for (WebElement job: jobLinks) {
				job.click();
				GenericActions.movetoTabs();
				boolean check = GenericActions.VerifyPage1("Applybtn");
				if (check =true) {
					System.out.println("Control moved to new tab: "+check);
					GenericActions.getWebElement("Applybtn").click();
					GenericActions.driver.close();
					GenericActions.driver.switchTo().window(handle);
				}
				else {
					GenericActions.driver.close();
					GenericActions.driver.switchTo().window(handle);
				}
			}
		} catch (Exception e) {
				e.getMessage();
		}
	}
	
	
	
}
