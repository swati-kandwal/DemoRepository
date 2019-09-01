package com.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.Base;

public class Logging extends Base implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
      System.out.println("---onTestStart---------"+result.getMethod().getMethodName());
      System.out.println("---onTestStart---------"+result.getTestClass().getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---onTestSuccess---------"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("---onTestFailure---------"+result.getMethod().getMethodName());
		
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File  srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"\\Selenium\\"+result.getMethod().getMethodName()+".png");
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("---onTestSkipped---------"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("---onTestFailedButWithinSuccessPercentage---------"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---onStart---------"+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---onFinish---------"+context.getName());
		
	}

}
