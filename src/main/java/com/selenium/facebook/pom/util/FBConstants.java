package com.selenium.facebook.pom.util;

public class FBConstants {
//paths
	//	locators
	public static final String LOGIN_USERNAME="//*[@id='email']";
	public static final String  LOGIN_PASSWORD= "//*[@id='pass']";
	public static final String PROFILEPAGE_LINK="(//div[@class='linkWrap noCount'])[1]";
	public static final String HOMEPAGE_URL = "https://www.facebook.com/";
	public static final String REPORTS_PATH = "H:\\JavaProject\\DataDrivenFramework\\PageObjectModel_withPageFactory\\Reports\\";
	public static final String RUNMODE_COL ="Runmode";
	public static final String EXCEL_PATH =System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "DataSheet1";
	public static final String NAVIGATION_LABEL = "//*[@id='userNavigationLabel']";
	
	public static final String SETTINGS_LINK="//span[@text()='Settings']";


}
