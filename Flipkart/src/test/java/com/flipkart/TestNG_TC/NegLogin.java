package com.flipkart.TestNG_TC;

import org.testng.annotations.Test;

import com.flipkart.Data.ReadExcel;
import com.flipkart.Data.WriteExcel;
import com.flipkart.Repository.HomePage;
import com.flipkart.Repository.Library;
import com.flipkart.Repository.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NegLogin {

	WebDriver driver;
	final static Logger log=Logger.getLogger("NegLogin");
	int i=1;
	String path="C:\\New folder (2)\\Flipkart\\src\\test\\java\\com\\flipkart\\Data\\Data.xlsx";
	
	
	@Test(dataProvider = "credentials")
  public void f(String username, String password) throws Throwable
	{
		PropertyConfigurator.configure("log4j.properties");
		Thread.sleep(200);
		try {
				String USERNAME=username.replace('"', ' ');
				USERNAME=USERNAME.replace(" ", "");
				String PASSWORD=username.replace('"', ' ');
				PASSWORD=PASSWORD.replace(" ", "");
				driver.findElement(By.xpath(LoginPage.userName)).sendKeys(USERNAME);
				driver.findElement(By.xpath(LoginPage.password)).sendKeys(PASSWORD);
				driver.findElement(By.xpath(LoginPage.loginBtn)).click();
				
				Thread.sleep(10000);
				Assert.assertEquals(true, driver.findElement(By.xpath("(//*[@href='/account/?rd=0&link=home_account'])[1]")).isDisplayed());
				System.out.println("Valid credentials");
				WriteExcel.writtingToEcecl(path, "Sheet1", i++, "valid");
				log.info(" Login sucessfull");
				
				 Actions act= new Actions(driver);
				 WebElement Acc_Name=driver.findElement(By.xpath(HomePage.Acc_info_Dropdown));
				 act.moveToElement(Acc_Name).perform();
				 Thread.sleep(1000);
				 driver.findElement(By.xpath(HomePage.logout)).click();
				 Thread.sleep(1000);
		} 
		catch (Exception e) {
			//System.out.println("inValid credentials");
			log.info("Invalid login");
			
			try 
			{
				
				String str=driver.findElement(By.xpath("//*[contains(text(),'Please enter valid Email')]")).getText();
				System.out.println(str);
				WriteExcel.writtingToEcecl(path, "Sheet1", i++, str);
				//System.out.println(i++);
			} 
			catch (Exception e2) 
			{
				try {
					String str=driver.findElement(By.xpath("//*[contains(text(),'Your username or password')]")).getText();
					System.out.println(str);
					WriteExcel.writtingToEcecl(path, "Sheet1", i++, str);
					//System.out.println(i++);
				} 
				catch (Exception e3) {
					String str=driver.findElement(By.xpath("//*[contains(text(),'Please enter Password')]")).getText();
					System.out.println(str);
					WriteExcel.writtingToEcecl(path, "Sheet1", i++, str);
					//System.out.println(i++);
				}
				
			}
			
		}
		  
  }
  @BeforeMethod
  public void clickingOnLogin()
  {
	  driver.get(Library.URL);
	  driver.findElement(By.xpath(HomePage.login_icon)).click();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("--------------------xxxxxxxxxxxxxx------------------------");
  }


  @DataProvider
  public Object[][] credentials() throws Throwable 
  {
    Object[][] data=ReadExcel.readData(path, "Sheet1");
    return data;
  }
  @BeforeClass
  public void initializingDriver()
  {
	  driver=new FirefoxDriver();
  }

  @AfterClass
  public void closingDriver()
  {
	  driver.quit();
  }

}
