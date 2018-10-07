package com.naukri.MavenProject;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.glassdoor.genericUtils.GenericActions;

public class GenericActions {

	public static WebDriver driver;
	
	//**************************************************************************
	//Method to extract the defined prop value in ConfigReader 
	
		
	public static WebElement getWebElement (String locatorname) throws Exception {
		 //ConfigReader obj = new ConfigReader();
		 
		 String readername = ConfigReader.loadproperty(locatorname);
		
		 String[] locators = readername.split(":");
		 
		 String locatortype = locators[0] ;
		 String locatorvalue = locators[1] ;
		 System.out.println(locatorvalue);
		 
		 if (locatortype.toLowerCase().equals("id")) {
		 return GenericActions.driver.findElement(By.id(locatorvalue));
		 }
		 
		 else if (locatortype.toLowerCase().equals("xpath")) {
		 return GenericActions.driver.findElement(By.xpath(locatorvalue));
		 
		 }
		 
		 else if (locatortype.toLowerCase().equals("class")) {
		 return GenericActions.driver.findElement(By.className(locatorvalue));	
		 }
		 
		 else 
		 {
			 throw new Exception("Unknown locator type" +locatortype);
		 }
		 
	}
	
	//*****************************************************************
	//Method to get properties of Lists
	
	public static List<WebElement> getWebLists (String locatorname) throws Exception {
		ConfigReader obj = new ConfigReader();
		 String readername = obj.loadproperty(locatorname);
		
		 String[] locators = readername.split(":");
		 
		 String locatortype = locators[0] ;
		 String locatorvalue = locators[1] ;
		 
		 if (locatortype.toLowerCase().equals("id")) {
		 return GenericActions.driver.findElements(By.id(locatorvalue));
		 }
		 
		 else if (locatortype.toLowerCase().equals("xpath")) {
		 return GenericActions.driver.findElements(By.xpath(locatorvalue));	 
		 }
		 
		 else if (locatortype.toLowerCase().equals("class")) {
		 return GenericActions.driver.findElements(By.className(locatorvalue));	
		 }
		 
		 else 
		 {
			 throw new Exception("Unknown locator type" +locatortype);
		 }
		 
	}
	
	//*****************************************************************************************************************
	//Method to move to an windowHandle to perform any operation
	 public  void movetoWindow(WebElement window) {
		 Actions act = new Actions(driver);
		 act.moveToElement(window).perform();
	 }
	
	
	//*****************************************************************************************************************
	//Method to run browsers
	
	public static void runBrowsers(String browser) {
			
		ConfigReader obj= new ConfigReader();
		String applicationUrl= obj.loadproperty("url");
		
		switch (browser) {	
		case "chrome":
			 
		System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium_Installers\\Executables\\chromedriver.exe");
	
		driver= new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		break;
		
		case "IE":
		System.setProperty("webdriver.ie.driver", "F:\\Java_Selenium_Installers\\Executables\\IEDriverServer.exe.exe");
		driver= new InternetExplorerDriver();
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		break;
		
		default:
		System.setProperty("webdriver.gecko.driver", "F:\\Java_Selenium_Installers\\Executables\\geckodriver.exe");
		driver= (WebDriver) new FirefoxDriver();
		driver.get(applicationUrl);
		//driver.manage().window().maximize();
		break;
		}
	}
	
	
//********************************************************************************************************************
	
	//Method to manage multiple window handles. Closes out the unintended pop up windows
	public static void manageWindowHandles() {
	String parent = driver.getWindowHandle();
	Set<String> child= driver.getWindowHandles();
		Iterator<String> itr= child.iterator();
		while(itr.hasNext()) {
			String childwin= itr.next();
			if(!parent.equals(childwin)) {
				driver.switchTo().window(childwin);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

//**************************************************************************************************************
//Method to hover over a dropdown-item and on expansion, click on desired item

	
	public static void dropdownMouseHover(String objprop, String listprop, String expected) {
			
		try {
			Actions act= new Actions(driver);
			WebElement hoverItem = GenericActions.getWebElement(objprop);
			act.moveToElement(hoverItem).perform();
			WebElement hoverbox = GenericActions.getWebElement(objprop);
			
			//List<WebElement> dropdownlists =hoverbox.findElements(By.tagName("a"));
			List<WebElement> dropdownlists = GenericActions.getWebLists(listprop);
					
				 for (WebElement ele:dropdownlists) {
					 	String actual_ele =  ele.getText();
					 	System.out.println("link name is "+actual_ele);
					 	if(actual_ele.equalsIgnoreCase(expected)) 
					 	{
					 		ele.click();
					 		System.out.println("Element is clicked ");
					 		break;
					 	}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		}
	

	//**************************************************************************************************************
		//Method to hover over item(not click) and on expansion, click on desired item

	
		public static void HoverSelect(String objprop, String selectObj) {
				
			try {
				Actions act= new Actions(driver);
				WebElement hoverItem = GenericActions.getWebElement(objprop);
				act.moveToElement(hoverItem).perform();
				WebElement selectItem = GenericActions.getWebElement(selectObj);
				selectItem.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			}

	
	//**************************************************************************************************************
	//method to select dropdown with Select tag
		
		public static void DropdwnSelect(String property, String ExpectedVal) {
			try {
			WebElement dropDown_Name = GenericActions.getWebElement(property);
			Select dropDown_ele = new Select(dropDown_Name);
			
			//Validate default value*********************
			
			WebElement drpdwn_val = dropDown_ele.getFirstSelectedOption();
			String def_val= drpdwn_val.getText();
			Assert.assertEquals(def_val, "");
			
			//**************************************
			dropDown_ele.selectByVisibleText(ExpectedVal);
			iwait(6000);
			System.out.println("Selected value is "+ExpectedVal);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		//********************************************************
		//Method to handle Bootstrap dropdown/checkbox/Radio button
		
		
		public static void Select_bootstrapEle(String propval,String ListpropVal,String Click_value) throws Exception {
		WebElement bootstrapEle_name = GenericActions.getWebElement(propval);
		bootstrapEle_name.getAttribute("id");
		
		bootstrapEle_name.click();
		
		List<WebElement> ele_contents= GenericActions.getWebLists(ListpropVal);
		System.out.println(ele_contents.size());
		
		for (int i=0;i<=ele_contents.size();i++) {
			WebElement ele = ele_contents.get(i);
				String ele_value = ele.getText();
				System.out.println("Link is for "+ele_value);
				if (ele_value.contentEquals(Click_value)) {
					ele.click();
					break;
				}
				
			}
		}
		
		
				
		
		//************************************************************
		//Method to scroll down inside a page and view objects(Inside sections)
		
		public static void scrolljs(WebElement eletobeFound) {
			
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("argument[0].scrollIntoView(true);", eletobeFound);
			
		}
		
		//************************************************************
		//Method to scroll down a page
				
				public static void scrollPage() {
					
					JavascriptExecutor je = (JavascriptExecutor)driver;
					je.executeScript("scroll(0,400)");
					
				}
				
		//****************************************************************
		//Method to handle hidden elements
				
				public static void findHiddenEle(List<WebElement> hiddenEle) {
					int list_count = hiddenEle.size();
					for (int i=0;i<=list_count;i++) {
						int x= hiddenEle.get(i).getLocation().getX();
						int y= hiddenEle.get(i).getLocation().getY();
						
						if (x!=0 && y!=0) {
							hiddenEle.get(i).click();
							break;
							
							}
						}
					}
				
			//****************************************************************
			//Method to highlight elements when element is focused
				
				public static void highlight_element(WebElement element) {
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
						try {
							Thread.sleep(500);
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
					
					js.executeScript("arguments[0].setAttribute('style', border: 2px white;');", element);
				}
				
				/************************************************************
				/Example to call in Program:
				highlight_element(WebElement_name);
				************************************************************/
				//****************************************************************
				//Method to handle tables/DatePicker Fields
				
				public static void tablePicker(WebElement tablename, List<WebElement> contents, String Expected) {
					tablename.click();
					for (int i=0;i<=contents.size();i++) {
						String actual = contents.get(i).getText();
							if (actual.equalsIgnoreCase(Expected)){
								contents.get(i).click();
								break;
							}
					}
				}
				
				//****************************************************************
				//Method to handle security Issues
				
				public static void handleCertificate(String Browser) {
					ConfigReader obj= new ConfigReader();
					String applicationUrl= obj.loadproperty("url");
					
					DesiredCapabilities acceptSSl = new DesiredCapabilities();
					acceptSSl.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				//	acceptSSl.acceptInsecureCerts();
					
					
					switch(Browser){
					case "chrome":
					System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium_Installers\\Executables\\chromedriver.exe");
					driver= new ChromeDriver(acceptSSl);
					driver.get(applicationUrl);
					driver.manage().window().maximize();
					break;
					
					case "IE":
					System.setProperty("webdriver.ie.driver", "F:\\Java_Selenium_Installers\\Executables\\IEDriverServer.exe.exe");
					driver= new InternetExplorerDriver(acceptSSl);
					driver.get(applicationUrl);
					driver.manage().window().maximize();
					break;
					
					default:
					System.setProperty("webdriver.gecko.driver", "F:\\Java_Selenium_Installers\\Executables\\geckodriver.exe");
					driver= new FirefoxDriver(acceptSSl);
					driver.get(applicationUrl);
					//driver.manage().window().maximize();
					break;
					}
				}
				
				//****************************************************************
				//Method to take screenshots
				
				public static void takeScreenshots(WebDriver driver,String Screenshotname) 
				{
					try {
						TakesScreenshot tk = (TakesScreenshot)driver;
						File source = tk.getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(source, new File ("./Screenshots/"+Screenshotname+".png"));
						} 
					catch (Exception e) {
					
						System.out.println(e.getMessage());
					}
					
				}
				
				//*****************************************************************
				//Method to check for all broken links in a page
				
				public static void  checkLink(List<WebElement> urls) {
					for (int i=0;i<=urls.size();i++) {
						WebElement link = urls.get(i);
						String urlname = link.getAttribute("href");
						}
				}
				
				//*****************************************************************
				//Method to implement implicit wait in a page
				
				public static void iwait(int waittime) {
					driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.MICROSECONDS);
				}

				//*****************************************************************
				//Method to implement emplicit wait in a page
				
				public static void ewait(int waittime, WebElement ele) {
					WebDriverWait wait = new WebDriverWait(driver, waittime);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Objxpath)));
					wait.until(ExpectedConditions.visibilityOf(ele));
					boolean status = ele.isDisplayed();
					
					if (status) {
						System.out.println("Element is available");
					}
					else {
						System.out.println("Element is not available");
					}
				}
				
				//*****************************************************************
				//Method to implement emplicit wait and return as WebDriver
				
				public static WebElement WebElementwait(int waittime, String propval) {
					WebElement ele = null;
					try {
					WebDriverWait wait = new WebDriverWait(driver, waittime);
					ele = GenericActions.getWebElement("propval");					
					wait.until(ExpectedConditions.visibilityOf(ele));
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					return ele;
					
				}
				
				//*****************************************************************
				//Method to move control to new tab
				
				public static void movetoWindow() {
					String parent = driver.getWindowHandle();
					Set<String> child = driver.getWindowHandles();
					 Iterator<String> itr = child.iterator();
					while (itr.hasNext()) {
						 String childwin = itr.next();
						 if (!parent.equals(childwin)) {
							 driver.switchTo().window(childwin);
									 
						 }
					}
				}
				
				//Method to move control to new tab
				
				public static void movetoTabs() {
					String parent = driver.getWindowHandle();
					Set<String> winhandles = driver.getWindowHandles();
					ArrayList<String> tab = new ArrayList<>(winhandles);
					for (int i=0;i<winhandles.size();i++)
					{
					driver.switchTo().window(tab.get(i));
					}
					 
				}
				
				
				
				//*****************************************************************
				//Method to verify page Load 
				/*	
				public static void verifyPage(String verifyobj) {
					try {
						WebElement obj= GenericActions.getWebElement(verifyobj);
						Boolean check = obj.isDisplayed();
						if (check.TRUE) {
							System.out.println("Page is loaded with object " +obj.getText() );
						}
						else{
							System.out.println("Page not loaded properly " +obj.getText() );
						}
					} catch (Exception e) {
					  e.printStackTrace();
					}
				}
				*/
				//*****************************************************************
				//Method to verify page Load(alternate)
				
				public static boolean VerifyPage1(String verifyobj) {
					WebElement obj = null;
					try {
						GenericActions.iwait(5000);
						obj= GenericActions.getWebElement(verifyobj);
						
					}
					catch (Exception e) {
						  e.printStackTrace();
						}
					if(obj.isDisplayed())
					{
						return true;
						}
					else {
						return false;
					}
					
				}
				
				//*****************************************************************
				//Method to Connect to MS SQl
				
				public static void DBConnection() throws SQLException, ClassNotFoundException {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				System.out.println("connection created");
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://INDMR40G2X42TJF\\SQLEXPRESS/TestDB","Dip", "Daipayan8");
				System.out.println("connection created");
				Statement st = conn.createStatement();
				String Sql = "select * from Patient where PatientID=2";
				ResultSet rs = st.executeQuery(Sql);
				while (rs.next()) {
					System.out.println(rs.getString(""));
				}
				}
					
}
