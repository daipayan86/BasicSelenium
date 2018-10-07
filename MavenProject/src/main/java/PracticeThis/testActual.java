package PracticeThis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testActual extends BaseInvoke {
	public static WebDriver driver;
	public testActual() {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseInvoke obj = new BaseInvoke();
		obj.invoke();
		driver.manage().window().maximize();
		driver.get("www.facebook.com");
		driver.findElement(By.id("email"));
	}

}
