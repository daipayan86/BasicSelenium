package stepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



//import com.naukri.MavenProject.GenericActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTestFB2 {
	public WebDriver driver;

	@Given("^open Firefox and go to fb application$")
	public void open_Firefox_and_go_to_fb_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "F:\\Java_Selenium_Installers\\Executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@When("^I enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("daipayan.sarkar");
		
		WebElement passcode = driver.findElement(By.id("pass"));
	    passcode.sendKeys("xyasa");
	    
	    WebElement loginbtn = driver.findElement(By.id("loginbutton"));
	    loginbtn.click();
	}

	@Then("^user should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	   driver.quit();
	}


}
