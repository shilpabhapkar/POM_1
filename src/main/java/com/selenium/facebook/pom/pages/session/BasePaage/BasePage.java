package com.selenium.facebook.pom.pages.session.BasePaage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.pages.commons.TopMenu;
import com.selenium.facebook.pom.util.FBConstants;

public class BasePage {
	public WebDriver driver;
	public ExtentTest extentTest;
	public TopMenu topMenu;
	
	public BasePage() {
	}
	public BasePage(WebDriver driver, ExtentTest extentTest) {
		this.extentTest=extentTest;
		this.driver = driver;
		topMenu=new TopMenu(driver,extentTest);
		PageFactory.initElements(driver, topMenu);
	}
	public TopMenu getMenu(){
		driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
		return topMenu;
	}
	public void takeScreenShot(){
		Date d=new Date();
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			File destFile=new File((FBConstants.REPORTS_PATH)+"screenshots//"+fileName);
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){
			
		}
		extentTest.log(LogStatus.INFO, extentTest.addScreenCapture("This PC\\IMG_4748[1].jpg"));
	}
	public String verifyTitle(String expectedTitle){
		extentTest.log(LogStatus.INFO, "verifying titlr: "+expectedTitle);
		return "";
	}
	public String verifyText(String expectedTitle){
		return "";
	}
	public boolean isElementPresent(String expectedTitle){
		return true;
	}
}
