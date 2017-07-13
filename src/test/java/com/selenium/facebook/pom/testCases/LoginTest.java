package com.selenium.facebook.pom.testCases;

import java.util.Hashtable;

import org.junit.internal.runners.statements.FailOnTimeout;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LandingPage;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.pages.session.LaunchPage;
import com.selenium.facebook.pom.pages.session.BasePaage.BasePage;
import com.selenium.facebook.pom.testCases.base.BaseTest;
import com.selenium.facebook.pom.util.DataUtil;
import com.selenium.facebook.pom.util.ExtentManager;
import com.selenium.facebook.pom.util.FBConstants;
import com.selenium.facebook.pom.util.Xls_Reader;;
public class LoginTest extends BaseTest{
	String testCaseName="LoginTest";
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String, String> data){

		//returs the obj of internal class ExtentTest
		extentTest=extentReports.startTest("Login Test");
		if(data.get(FBConstants.RUNMODE_COL).equalsIgnoreCase("N")){
			extentTest.log(LogStatus.SKIP, "Runmode is N");
			throw new SkipException("Skipping doLogin as runmode is no");
			
		}
		extentTest.log(LogStatus.INFO, "Starting login Test");
		extentTest.log(LogStatus.INFO, "Opening Browser");
		init("Chrome");
		LaunchPage launchPage= new LaunchPage(driver,extentTest);
		 PageFactory.initElements(driver, extentTest);
		LoginPage loginPage=launchPage.goToLoginPage();
		extentTest.log(LogStatus.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult="";
		if(page instanceof LandingPage)
			actualResult="Success";
		else
			actualResult="Unsuccessful";
		if(actualResult.equals(data.get("ExpectedResult"))){
			loginPage.takeScreenShot();
			failTest("faliure msg");
		}
		
		extentTest.log(LogStatus.PASS, "Test Pass");

	}
	@DataProvider
	  public Object[][] getData() {
		 return DataUtil.getData1(xls_Reader, testCaseName) ;
	  }
	@AfterMethod
	public void quit(){
		if(extentReports!=null){
			extentReports.endTest(extentTest);
			extentReports.flush();
		}
	}

}
