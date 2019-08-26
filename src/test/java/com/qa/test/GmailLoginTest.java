package com.qa.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.base.GmailLoginPage;

public class GmailLoginTest extends Base{
	
	GmailLoginPage gmailLogin;
	
	
	@BeforeTest
	public void setUp() {
		intialize();
		gmailLogin= new GmailLoginPage();
		
	}
	
	
	@Test
	public void loginToGmailTest() {
		gmailLogin.login();
		
	}
	
	@Test(dependsOnMethods = {"loginToGmailTest"})
	public void verifyTitleOfLoginPage() {
		System.out.println("Login age title="+driver.getTitle());
	}
	
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
	

}
