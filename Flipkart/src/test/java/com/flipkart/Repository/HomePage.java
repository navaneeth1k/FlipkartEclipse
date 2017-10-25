package com.flipkart.Repository;

public interface HomePage {
	String Electronics="//*[@title='Electronics']";
	String Mobiles="//*[@title='Electronics']/following-sibling::*/descendant::*[@class='QPOmNK'][1]/li";
	
	String login_icon="//*[text()='Log In']";
	String Acc_Name="//*[text()='Track Order']/../following-sibling::li[2]";
	
	String Acc_info_Dropdown="(//*[@href='/account/?rd=0&link=home_account'])[1]";
	String logout="//*[text()='Log Out']";
	
	String searchBox="//*[@title='Search for Products, Brands and More']";
	String search="//*[@title='Search for Products, Brands and More']/../../following-sibling::*/*[@type='submit']";
	
}
