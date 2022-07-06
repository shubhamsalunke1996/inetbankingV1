package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	//WebDriver ldriver;

	//public LoginPage(WebDriver rdriver)
	//{
	//	ldriver=rdriver;
	//	PageFactory.initElements(rdriver, this);
	//}
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	//@FindBy(xpath="html[1]/body[1]/div[3]/div[1]/ul[1]/li[10]/a[1]")
	//@CacheLookup
	//WebElement lnkLogout;
	
	
	@FindBy(xpath = "//a[@href='Logout.php']" )
	@CacheLookup
	WebElement lnkLogout;

	public void setUserName(String uname) {

		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {

		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	

}
