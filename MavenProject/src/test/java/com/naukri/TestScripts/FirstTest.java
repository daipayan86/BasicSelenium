package com.naukri.TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.naukri.MavenProject.GenericActions;
import com.naukri.Pages.jobLists;
import com.naukri.Pages.nLogin;

public class FirstTest {

	
	@BeforeTest
	public void precond() {
		nLogin.preCondition();
	}
	
	@Test
	public void firstTest() {
		try {
		nLogin.loginApplication();
		jobLists.searchCriteria();
		jobLists.sortsearchresults();
		jobLists.ClickonEachJobLink();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		    
		}
	}
	
	@AfterTest
	public void postcond() {
		GenericActions.driver.close();
	}
}
		
		
