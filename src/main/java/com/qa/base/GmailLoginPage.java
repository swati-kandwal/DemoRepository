package com.qa.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends Base {

	GmailLoginPage gmailLogin;
	GmailHomePage gmailHome;

	@FindBy(name = "identifier")
	WebElement uname;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;

	@FindBy(name = "password")
	WebElement pwd;

	public GmailLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public GmailHomePage login() {

		Actions action = new Actions(driver);
		action.moveToElement(uname).click();
		uname.sendKeys(prop.getProperty("username"));
		next.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(prop.getProperty("password"));

		next.click();

		return gmailHome;
	}

}
