package PracticeThis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javafx.beans.property.SetProperty;

public class BaseInvoke {

	public static WebDriver driver;
	
	public void invoke() {
		
		System.setProperty("webdriver.gecko.driver", "F:\\Java_Selenium_Installers\\Executables\\geckodriver.exe");
		driver= new FirefoxDriver();
		
	}
}
