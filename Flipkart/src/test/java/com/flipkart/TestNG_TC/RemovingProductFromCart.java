package com.flipkart.TestNG_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.flipkart.Repository.CartPage;

public class RemovingProductFromCart extends Browser {
  @Test
  public void removeFromCart() throws Throwable {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(CartPage.removingItem)).click();
  }
}
