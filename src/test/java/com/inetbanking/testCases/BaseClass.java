package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	//public String browser=readconfig.getBrowser();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {


		System.out.println("Browser name is : : "+browser);
		System.out.println("Thread id : "+Thread.currentThread().getId());

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();				
			Map<String, Object> prefs=new HashedMap<String, Object>();
			prefs.put("profile.managed_default_content_setting.javascript", 2);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("window-size=1980,1080");
			driver=new ChromeDriver(options);
		}
	
	    else if (browser.equalsIgnoreCase("Ignitochrome")) {
	    	WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();		
			options.addArguments("--incognito");
			options.addArguments("window-size=1980,1080");
			driver=new ChromeDriver(options);

	}
		else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("javascript.enabled", false);
			driver=new FirefoxDriver(options);

		}
		else if (browser.equalsIgnoreCase("edge")) {			
				//System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());	
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("Privateedge")) {
				
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();			
			options.addArguments("InPrivate");
			options.addArguments("window-size=1980,1080");
			driver = new EdgeDriver(options);
			
		}else {
			System.out.println("Incorrect browser");
		}

		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterClass
	public void tearDown() {
		
		driver.quit();
		System.out.println("driver closed sucessfully");
	}

	public void captureScreen(WebDriver driver, String picname) {


		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+ picname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshots Taken");

	}

	public String randomestring() {

		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return(generatedString);


	}

	public static String randomeNum() {

		String generatedString2=RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public static String randomeNum(int number) {

		String generatedString2=RandomStringUtils.randomNumeric(number);
		return (generatedString2);
	}
	
	


	
}
