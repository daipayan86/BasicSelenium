package com.naukri.MavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
	public static WebDriver driver;

	//****************************Invoke Browsers*****************************
	public void ChromeBrowser() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Eclipse_Job\\SeleniumProject\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		
	}
}
