package com.flipkart.TestNG_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.flipkart.Repository.HomePage;

public class Logout extends Browser {
  @Test
  public void logoutFromFlipkart() throws Throwable {
	  Thread.sleep(5000);
	 
	  Actions act= new Actions(driver);
	 WebElement Acc_Name=driver.findElement(By.xpath(HomePage.Acc_info_Dropdown));
	  act.moveToElement(Acc_Name).perform();
	 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(HomePage.logout)).click();
  }
}
