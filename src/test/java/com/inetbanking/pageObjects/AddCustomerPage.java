package com.inetbanking.pageObjects;



import java.time.Duration;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class AddCustomerPage {

WebDriver driver;
	
public AddCustomerPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	
	@FindBy(how = How.XPATH, using ="//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0\"]")
	@CacheLookup
	WebElement frame1Path;
	
	@FindBy(how=How.ID,using="ad_iframe")
	@CacheLookup
	WebElement frame2Path;
	
	@FindBy(how=How.XPATH,using="//div[@id='dismiss-button']/div/span")
	@CacheLookup
	WebElement dismissAdd;
	

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;

	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;

	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;

	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpinno;

	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;

	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;

	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;

	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how =How.XPATH, using ="(//a[@href='Managerhomepage.php'])[2]")
	@CacheLookup
	WebElement btncontinue;

	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}
	public void dismissAdd() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				WebElement linkElement= driver.findElement(By.xpath("//*[@id=\"google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0\"]"));
				
			
				if(linkElement.isEnabled()) {
				
					System.out.println("Element addvertisement is  found");
					
				}
				
				
				return linkElement;
			}
			
		});
		
		String nameofadd=element.getText();
		System.out.println(nameofadd);
		driver.switchTo().frame(element);
		//driver.switchTo().frame(frame1Path);
		driver.switchTo().frame(frame2Path);
		dismissAdd.click();
		driver.switchTo().defaultContent();
			
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void continueSubmit() {
		btncontinue.click();
	}
	
	
	
	
}
