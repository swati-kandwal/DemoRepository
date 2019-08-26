package com.qa.test;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.base.GmailHomePage;
import com.qa.base.GmailLoginPage;
import com.qa.utility.Utility;

public class GmailHomeTest extends Base {
	GmailHomePage homePage;
	GmailLoginPage gmailLogin;
	Logger log = Logger.getLogger(GmailHomeTest.class);

	@BeforeTest
	public void setUp() {
		intialize();
		gmailLogin = new GmailLoginPage();
		homePage = new GmailHomePage();
		gmailLogin.login();
	}

	@Test(dataProvider="getAllData" ,dataProviderClass=Utility.class)
	public void loginNsendMail(String mailId,String subjectContent, String bodyContent) throws AWTException, InterruptedException {
		log.info("-----------------Inside");
		homePage.composeMail(mailId,subjectContent,bodyContent);
	}

	@Test(dependsOnMethods = { "loginNsendMail" })
	public void verifyTitleOfGmailLoginPage() {
		System.out.println(homePage.getGmailLoginPageTitle());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

	

}
