package com.selenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.session.ProfilePage;
import com.selenium.facebook.pom.pages.session.BasePaage.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class LandingPage extends BasePage{
	
	@FindBy(xpath=FBConstants.PROFILEPAGE_LINK)
	public WebElement profileLink;
	public LandingPage(WebDriver driver,ExtentTest extentTest){
		super(driver, extentTest);
		System.out.println("in constr of LoginPage Page");
	}
	public ProfilePage goToProfilePage(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.INFO, "Going to profile page");
		profileLink.click();
		ProfilePage profilePage= new ProfilePage(driver, extentTest);
		 PageFactory.initElements(driver,profilePage);
		 return profilePage;
	}
}
