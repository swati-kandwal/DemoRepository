package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.utility.WebEventListener;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebEventListener event_Listener;

	public Base() {
		try {	
			FileInputStream fis = new FileInputStream("C:\\Users\\skandwal\\eclipse-workspace\\GmailSelenium\\src\\main\\java\\com\\qa\\config\\env.properties");
			prop = new Properties();
			prop.load(fis);						

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void intialize() {

		try {
			
			String browser = prop.getProperty("browser");
			
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
			}
			else {
				System.out.println("Please enter correct browser details");
			}
			
			event_driver = new EventFiringWebDriver(driver);
			event_Listener = new WebEventListener();
			event_driver.register(event_Listener);
			driver=event_driver;
			
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));
			System.out.println("Current page URL="+driver.getCurrentUrl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
