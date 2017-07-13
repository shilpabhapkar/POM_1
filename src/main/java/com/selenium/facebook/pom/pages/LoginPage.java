package com.selenium.facebook.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.session.BasePaage.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class LoginPage extends BasePage {

	@FindBy(xpath=FBConstants.LOGIN_USERNAME)
	public WebElement email;

	@FindBy(xpath=FBConstants.LOGIN_PASSWORD)
	public WebElement password;
	public LoginPage(WebDriver driver, ExtentTest extentTest){
		super(driver, extentTest);
		System.out.println("in constr of LoginPage Page");
	}
	public Object doLogin(String userName, String Password){
		extentTest.log(LogStatus.INFO, "Logged in using: "+userName+" "+Password);
		email.sendKeys(userName);;
		password.sendKeys(Password);;
		password.sendKeys(Keys.ENTER);
		boolean loginSuccess=true;
		if(loginSuccess){
			extentTest.log(LogStatus.INFO, "successful");
			LandingPage landingPage=new LandingPage(driver, extentTest);
			PageFactory.initElements(driver, landingPage);
			return  landingPage;
		}else{
			extentTest.log(LogStatus.INFO, "not successful");
			LoginPage loginPage = new LoginPage(driver, extentTest);
			PageFactory.initElements(driver,loginPage);
			return loginPage;
		}
	}



}
