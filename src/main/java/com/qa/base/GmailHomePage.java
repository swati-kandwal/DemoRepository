package com.qa.base;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.qa.utility.Utility;

public class GmailHomePage extends Base {
	Utility ulility = new Utility();

	@FindBy(xpath = "//*[@role='button' and text()='Compose']")
	WebElement composeMail;

	@FindBy(xpath = "//textarea[@aria-label='To']")
	WebElement mailTo;

	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElement subject;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	WebElement body;

	@FindBy(xpath = "//div[@command='Files' and @data-tooltip='Attach files']")
	WebElement attachFile;

	@FindBy(xpath = "//div[text()='Send']")
	WebElement send;

	public GmailHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void composeMail(String mailId, String subjectContent, String bodyContent)throws AWTException, InterruptedException {
		composeMail.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(mailTo)).sendKeys(mailId);
		subject.sendKeys(subjectContent);
		body.sendKeys(bodyContent);
		attachFile.click();
		Thread.sleep(20);
		ulility.uploadFile("D:\\all_files\\test.txt");
		wait.until(ExpectedConditions.visibilityOf(send)).click();
	}

	public String getGmailLoginPageTitle() {
		return driver.getTitle();
	}

}
