package com.flipkart.Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;

import com.flipkart.Repository.HomePage;

public class ElectronicsCategory {
	public static List<String> electronies(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath(HomePage.Electronics)).click();
		Thread.sleep(1000);
		List<WebElement> mobiles=driver.findElements(By.xpath(HomePage.Mobiles));
		return null;
		
	}
}
