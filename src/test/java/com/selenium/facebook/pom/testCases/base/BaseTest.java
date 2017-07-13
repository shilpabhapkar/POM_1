package com.selenium.facebook.pom.testCases.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.util.ExtentManager;
import com.selenium.facebook.pom.util.FBConstants;
import com.selenium.facebook.pom.util.Xls_Reader;

import junit.framework.Assert;

public class BaseTest {
	public  WebDriver driver;
	public ExtentReports extentReports=ExtentManager.getInstance();
	public ExtentTest extentTest;
	public Xls_Reader xls_Reader=new Xls_Reader(FBConstants.EXCEL_PATH);
	
	
	public void init(String bType){
		extentTest.log(LogStatus.INFO, "Opening browser");
		if(bType.endsWith("Mozila")){
			driver= new FirefoxDriver();
		}
		if(bType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "H:\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			extentTest.log(LogStatus.INFO, "Opening browser : "+bType);
		}
	}
	public void failTest(String faliuremsg){
		extentTest.log(LogStatus.INFO, faliuremsg);
		Assert.fail(faliuremsg);
	}
}
