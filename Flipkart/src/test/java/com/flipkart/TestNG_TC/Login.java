package com.flipkart.TestNG_TC;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Data.ReadExcel;
import com.flipkart.Repository.CartPage;
import com.flipkart.Repository.Electronics;
import com.flipkart.Repository.HomePage;
import com.flipkart.Repository.Library;
import com.flipkart.Repository.LoginPage;
import com.flipkart.Repository.ProductInfo;
import com.flipkart.Repository.ProductsList;

public class Login extends Browser{
	
	String path="C:\\New folder (2)\\Flipkart\\src\\test\\java\\com\\flipkart\\Data\\Data.xlsx";
	/*@BeforeClass
	private void driverConfiguration()//web driver initialization
	{
		driver=new FirefoxDriver();
		
		
	}
	@BeforeMethod
	public void enteringToLoginPage()	 //Entering URL and clicking on Login Icon
	{
		driver.get(Library.URL);
		driver.findElement(By.xpath(HomePage.login_icon)).click();
	}

	 @BeforeSuite
	  public void beforeSuite() {
		 driver=new FirefoxDriver();
	  }*/
	
 @Test(dataProvider="getExcelData")
  public void loginFunction (String username, String password) throws Throwable		//providing the username and password and clicking on login button  
  {
	 //Thread.sleep(200);
		driver.findElement(By.xpath(HomePage.login_icon)).click();
	  	/*String logo=driver.findElement(By.xpath(LoginPage.LoginLogo)).getText();
		String text=driver.findElement(By.xpath(LoginPage.LoginText)).getText();
		Assert.assertEquals(logo, LoginPage.login_logo);
		System.out.println("logo");
		String str="successful";
		Assert.assertEquals(text, LoginPage.login_text, str);*/
	
	  driver.findElement(By.xpath(LoginPage.userName)).sendKeys(username);
	  driver.findElement(By.xpath(LoginPage.password)).sendKeys(password);
	  driver.findElement(By.xpath(LoginPage.loginBtn)).click();
	  
  }
 @DataProvider
 public Object[][] getExcelData() throws Throwable
 {
	 Object[][] data=ReadExcel.readData(path, "Sheet2");
	return data;
	 
 }

/* @Test(dependsOnMethods="loginFunction")
 public void selectItem() throws Throwable {
	//  WebDriver driver=new FirefoxDriver();
	 Thread.sleep(2000); 
	 Actions action=new Actions(driver);
	  WebElement ele=driver.findElement(By.xpath(HomePage.Electronics));
	 action.moveToElement(ele).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(Electronics.samsung)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(ProductsList.max)).click();
 }
 
 @Test(dependsOnMethods="selectItem")
 public void addCart() throws Throwable 
 {
	  //WebDriver driver= new FirefoxDriver();
	  Thread.sleep(1000);
	 driver.findElement(By.xpath(ProductInfo.addToCart)).click();
 }
 
 @Test(dependsOnMethods="addCart")
 public void removeFromCart() {
	  //WebDriver driver= new FirefoxDriver();
	  driver.findElement(By.xpath(CartPage.removingItem)).click();
 }
 
 @Test(dependsOnMethods="removeFromCart")
 public void logoutFromFlipkart() throws Throwable {
	  Thread.sleep(5000);
	  //WebDriver driver=new FirefoxDriver();
	  Actions act= new Actions(driver);
	 WebElement Acc_Name=driver.findElement(By.xpath(HomePage.Acc_info_Dropdown));
	  act.moveToElement(Acc_Name).perform();
	 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(HomePage.logout)).click();
 }*/

 
 
 
 
 
 
}
