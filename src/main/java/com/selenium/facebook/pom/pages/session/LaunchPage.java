package com.selenium.facebook.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.pages.session.BasePaage.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class LaunchPage extends BasePage{
	public LaunchPage(WebDriver driver,ExtentTest extentTest ){
		super(driver, extentTest);
		System.out.println("in constr of Launch Page");
	}
	public LoginPage goToLoginPage(){
		extentTest.log(LogStatus.INFO, "Opening URL");
		driver.get(FBConstants.HOMEPAGE_URL);
		extentTest.log(LogStatus.PASS, "opened URL  "+FBConstants.HOMEPAGE_URL);
		LoginPage loginPage=new LoginPage(driver,extentTest);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
}
