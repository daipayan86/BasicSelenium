package com.naukri.TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.naukri.MavenProject.GenericActions;
import com.naukri.Pages.nLogin;
import com.naukri.Pages.updateProfile;





public class UpdateInfoTest {
	
	@BeforeTest
	public static void precond() {
		nLogin.preCondition();
	}

	@Test
	public static void UpdateProfile()  {
		
		try {

		nLogin.loginApplication();
		updateProfile.updateinfo();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	
@AfterTest
public void postcond() {
	GenericActions.driver.close();
		}
}


