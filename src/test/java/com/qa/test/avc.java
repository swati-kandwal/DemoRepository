package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.base.RetryAnalayzer;

public class avc extends Base{
	
	public avc() {
		System.out.println("----------avc Constructor"+System.getProperty("user.dir"));
		
		intialize();
	}
	
	
	@Test(priority=1)
	public void verify() {
		System.out.println("##############################################verify");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods="verify")
	public void print() {
		System.out.println("##############################################print");
		Assert.assertEquals(true, false);
	}
	
	//retryAnalyzer = RetryAnalayzer.class 
	@Test(priority=3)
	public void getData() {
		System.out.println("##############################################getData");
		  Assert.assertTrue("swati".equals("Swati"), "Data does not match------------");
	}
	
	

}
