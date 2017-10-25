package com.flipkart.TestNG_TC;

import org.testng.annotations.Test;

import com.flipkart.Repository.Library;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Browser {
	public static WebDriver driver;
	/*@Parameters({"browser"})
  @BeforeMethod
  public void initializingBrowser(String str) 
	{
		if(str.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(str.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(str.equalsIgnoreCase("ie"))
		{
			//System.setProperty("webdriver.ie.driver", "C:/Selenium/driver/IEDriverServer.exe");
			System.setProperty("webdriver.edge.driver", "MicrosoftwebDriver.exe");
			driver=new EdgeDriver();
		}
		driver.get(Library.URL);
  }*/
	@BeforeSuite
	public WebDriver init()
	{
		driver=new FirefoxDriver();
		driver.get(Library.URL);
		return driver;
	}
  @Test
  public void f()
  {
	 // System.out.println(driver.getTitle());
	  //System.out.println("in browser");
  }

  /*@AfterSuite
  public void closingBrowser() {
	  driver.close();
  }*/

}
