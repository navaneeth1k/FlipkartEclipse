package com.flipkart.TestNG_TC;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Data.ReadExcel;
import com.flipkart.Repository.HomePage;
import com.flipkart.Repository.Library;
import com.flipkart.Repository.LoginPage;

public class CheckingLoginWithNegatives {
 
	
 WebDriver driver;
 
 
 
	@BeforeClass
	private void driverConfiguration() {
		driver=new FirefoxDriver();
		
	}
	@BeforeMethod
	public void enteringToLoginPage() throws Throwable {
		driver.get(Library.URL);
		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePage.login_icon)).click();
	}
@Test(dataProvider="getData")
public void loginFunction (String userName, String password) throws Throwable {
	 
	
	  driver.findElement(By.xpath(LoginPage.userName)).sendKeys(userName);
	   driver.findElement(By.xpath(LoginPage.password)).sendKeys(password);
	  driver.findElement(By.xpath(LoginPage.loginBtn)).click();
	  try
	  {
		  boolean status=driver.findElement(By.xpath("//*[contains(text(),'Please enter valid')]")).isDisplayed();
		  Assert.assertEquals(true, status);
	  }
	  catch (Exception e)
	  {
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Please enter valid')]")).getText());
	  }
	
	  System.out.println(userName+","+password);
	  
	  
}
@DataProvider
public Object[][] getData() throws Throwable
{
	 String path="C:\\New folder (2)\\Flipkart\\src\\test\\java\\com\\flipkart\\Data\\Data.xlsx";
	 Object[][] data=ReadExcel.readData(path, "Sheet1");
	 return data;
	 
}
@AfterMethod
public void logout() throws Throwable
{
	  Thread.sleep(5000);
	  Actions act= new Actions(driver);
	 WebElement Acc_Name=driver.findElement(By.xpath(HomePage.Acc_Name));
	  act.moveToElement(Acc_Name).perform();
	 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(HomePage.logout)).click();
}

}
