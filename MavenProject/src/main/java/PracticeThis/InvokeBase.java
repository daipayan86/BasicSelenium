package PracticeThis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.naukri.MavenProject.GenericActions;

public class InvokeBase extends GenericActions {
 
	@Test
	public static void Test1() {
		GenericActions.runBrowsers("Chrome");
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("Search Element");;
	}
}
