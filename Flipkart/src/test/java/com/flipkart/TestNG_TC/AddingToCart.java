package com.flipkart.TestNG_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.flipkart.Repository.ProductInfo;

public class AddingToCart extends Browser{
  @Test
  public void addCart() throws Exception 
  {
	 Thread.sleep(1000);
	  driver.findElement(By.xpath(ProductInfo.addToCart)).click();
  }
}
