package com.inetbanking.testCases;









import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass {


	@Test(retryAnalyzer = RetryAnalyzer.class)	
	public void addNewCustomer() throws InterruptedException {

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.dismissAdd();
		logger.info("providing customer details....");
		
		addcust.custName("Shubham");
		addcust.custgender("male");
		addcust.custdob("01","01","2000");

		addcust.custaddress("INDIA");
		addcust.custcity("PUNE");
		addcust.custstate("MAHARASHTRA");
		String code=randomeNum(5);
		String pincode="4"+code;
		addcust.custpinno(pincode);

		String number=randomeNum(8);
		String mobileNumber="9"+number;
		addcust.custtelephoneno(mobileNumber);

		String email=randomestring()+"@gmail.com";
		String emailId=email.toLowerCase();
		addcust.custemailid(emailId);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		logger.info("validation started....");
		Thread.sleep(3000);

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}



	}

}
