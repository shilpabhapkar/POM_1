package com.selenium.facebook.pom.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.util.FBConstants;

public class TopMenu {
	@FindBy(xpath=FBConstants.NAVIGATION_LABEL)
	public WebElement navigationLabel;
	@FindBy(xpath=FBConstants.SETTINGS_LINK)
	public WebElement settings;
	ExtentTest extentTest;
	WebDriver driver;
	
	public TopMenu(WebDriver driver, ExtentTest extentTest) {
		
		this.extentTest = extentTest;
		this.driver = driver;
	}
	public void logout(){
		
	}
	public void gotoSettings(){
		extentTest.log(LogStatus.INFO, "going to settings page");
	
		navigationLabel.click();
		extentTest.log(LogStatus.INFO, "going to clicking on settings ");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		settings.click();
	}
	public void search(){

	}
}
