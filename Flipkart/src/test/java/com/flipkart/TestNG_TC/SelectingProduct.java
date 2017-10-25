package com.flipkart.TestNG_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.flipkart.Repository.Electronics;
import com.flipkart.Repository.HomePage;
import com.flipkart.Repository.ProductsList;

public class SelectingProduct extends Browser{
  @Test
  public void selectItem() throws Throwable {
	 // WebDriver driver=new FirefoxDriver();
	 /* Actions action=new Actions(driver);
	  WebElement ele=driver.findElement(By.xpath(HomePage.Electronics));
	 action.moveToElement(ele).perform();
	 Thread.sleep(100);
	 driver.findElement(By.xpath(Electronics.samsung)).click();
	 Thread.sleep(100);
	 driver.findElement(By.xpath(ProductsList.S8)).click();*/
	  
	  driver.findElement(By.xpath(HomePage.searchBox)).sendKeys("samsumg s8");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(HomePage.search)).click();
	  Thread.sleep(200);
	  driver.findElement(By.xpath(ProductsList.S8)).click();
  }
}
