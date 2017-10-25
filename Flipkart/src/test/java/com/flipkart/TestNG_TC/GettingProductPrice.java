package com.flipkart.TestNG_TC;

import org.testng.annotations.Test;

import com.flipkart.Data.ReadExcel;
import com.flipkart.Data.WriteExcel;
import com.flipkart.Repository.HomePage;
import com.flipkart.Repository.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class GettingProductPrice {
	
	WebDriver driver;
	int i=1;
	@BeforeClass
	public void init()
	{
		driver=new FirefoxDriver();
		driver.get(Library.URL);
	}
	
	@Test(dataProvider = "productName")
  public void price(String name) throws Throwable 
	{
		//System.out.println(name);
		Thread.sleep(300);
		driver.findElement(By.xpath(HomePage.searchBox)).sendKeys(name);
		Thread.sleep(200);
		driver.findElement(By.xpath(HomePage.search)).click();
		
		Thread.sleep(2000);
		try
		{
			System.out.println("in try");
		String price=driver.findElement(By.xpath("(//*[contains(text(),'"+name+"')]/following-sibling::*/descendant::*[text()='₹'])[1]")).getText();
		System.out.println(price);
		WriteExcel.writtingToEcecl(Library.path, "Sheet3", i++, price);
		
		
		}
		catch (Exception e) 
		{
			System.out.println("in catch");
			String price=driver.findElement(By.xpath("(//*[contains(text(),'"+name+"')]/../following-sibling::*/descendant::*[text()='₹'])[1]")).getText();
			System.out.println(price);
			WriteExcel.writtingToEcecl(Library.path, "Sheet3", i++, price);
			
			
			
		}
  }
 
  
  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.xpath("//*[@title='Flipkart']")).click();
  }


  @DataProvider
  public Object[][] productName() throws Exception 
  {
	  Object[][] data=ReadExcel.readData(Library.path, "Sheet3");
	  return data;
  }
}
