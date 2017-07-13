package com.selenium.facebook.pom.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LandingPage;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.pages.session.LaunchPage;
import com.selenium.facebook.pom.pages.session.ProfilePage;
import com.selenium.facebook.pom.testCases.base.BaseTest;

import junit.framework.Assert;

public class ProfileTest extends BaseTest{
	@Test
	public void testProfile(){
		
		extentTest=extentReports.startTest("Profile Test");
		extentTest.log(LogStatus.INFO, "Starting profile Test");
		init("Chrome");
		//it will pass driver instance to the launch page claass internally
		//creates the obj of LaunchPage and pass the driver instance
		//whatever objs written in lp are extracted
		LaunchPage launchPage= new LaunchPage(driver, extentTest);
		PageFactory.initElements(driver,launchPage);
		LoginPage loginPage=launchPage.goToLoginPage();
		loginPage.verifyTitle("Facebook Login");
		Object page=loginPage.doLogin("shilpabhapkar.10@gmail.com", "September!99!");
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else if(page instanceof LandingPage)
			System.out.println("sucessful login");
		LandingPage landingPage=(LandingPage)page;//conver the page obj in landing page
		//landingPage.getMenu().search();
		ProfilePage profilePage=landingPage.goToProfilePage();
		profilePage.verifyProfile();
		extentTest.log(LogStatus.PASS, "Test Pass");
		//profilePage.getMenu().logout();
		profilePage.takeScreenShot();

	}
	@AfterMethod
	public void quit(){
		if(extentReports!=null){
			extentReports.endTest(extentTest);
			extentReports.flush();
		}
	}
}
