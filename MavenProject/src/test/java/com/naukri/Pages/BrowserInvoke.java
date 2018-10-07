package com.naukri.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.naukri.MavenProject.GenericActions;
import com.naukri.MavenProject.TesterClass;

public class BrowserInvoke {
	
	public WebDriver driver;
	public int i;
	public String Filename;
	public void BrowserInvoke() {
		this.driver = GenericActions.driver;
		this.i= TesterClass.i;
		this.Filename = TesterClass.Filename;
	}

	public void startBrowser() {
		GenericActions.runBrowsers("chrome");
		driver.get("www.google.com");
	}
	
	@Test
	public void result() {
		System.out.println(i);
		System.out.println(Filename);
	}
}
