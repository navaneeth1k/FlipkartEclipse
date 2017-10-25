package com.flipkart.Repository;

public interface ProductsList {
	String S8="(//*[contains(text(),'Samsung Galaxy S8')])[1]";
	String max="Samsung Galaxy On Max (Black, 32 GB)";
	
	String price="(//*[contains(text(),'S8')]/following-sibling::*/descendant::*[text()='₹'])[1]";
	String iphone7="(//*[contains(text(),'iPhone 7')]/../following-sibling::*/descendant::*[text()='₹'])[1]";
}
