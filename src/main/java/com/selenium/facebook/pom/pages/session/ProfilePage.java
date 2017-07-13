package com.selenium.facebook.pom.pages.session;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.session.BasePaage.BasePage;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver,ExtentTest extentTest){
		super(driver, extentTest);
		System.out.println("in constr of ProfilePage Page");
	}
	public void verifyProfile(){
		extentTest.log(LogStatus.INFO, "verifying Profile");
	}
}
