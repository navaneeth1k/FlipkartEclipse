package com.flipkart.Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface LoginPage {
	
	String LoginLogo="//*[@class='Og_iib col col-2-5 _3SWFXF']/descendant::*[text()='Login']";
	String UserError="//*[contains(text(),'Please enter valid')]";
	String login_logo="Login";
	
	String LoginText="//*[@class='Og_iib col col-2-5 _3SWFXF']/descendant::*[contains(text(),'Get access to your')]";
	String login_text="Get access to your Orders, Wishlist and Recommendations";
	
	String userName="//*[text()='Enter Email/Mobile number']/../preceding-sibling::input";
	String password="//*[text()='Enter Password']/../preceding-sibling::input";
	String loginBtn="(//*[text()='Login']/..)[2]";
	
	String USERNAME="knavaneeth003@gmail.com";
	String PASSWORD="flip@12345";
	
	

	
}
/*class As
{
	@FindBy(xpath = "//*[text()='Enter Email/Mobile number']/../preceding-sibling::input") 
	WebElement gafa;
}*/
