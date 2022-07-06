package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void loginTest() {

		logger.info("URL is open");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}
}
