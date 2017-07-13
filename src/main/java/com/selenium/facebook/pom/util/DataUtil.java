package com.selenium.facebook.pom.util;

import java.util.Hashtable;


public class DataUtil {
	String testCaseName="LoginTest";
	public static Object[][] getData1( Xls_Reader xls_Reader, String testCaseName) {
		  String sheetName=FBConstants.TESTDATA_SHEET;
		 
		  //indentify the testcase name in excel sheet
		  int testStartRowNum=1;
		  while(!(xls_Reader.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))){
		   testStartRowNum++; 
		  }
		  System.out.println(testStartRowNum);
		  //logic to get no of rows in which data is present
		  int colStartNum=testStartRowNum+1;
		  int  dataStartNum=testStartRowNum+2;
		  int rows=0;
		  while(!(xls_Reader.getCellData(sheetName, rows, dataStartNum+rows).equals(""))){
		   rows++;
		  }
		  System.out.println("total rows in which data is present: "+rows);
		  //no of columns
		  int cols=0;
		  while(!xls_Reader.getCellData(sheetName, cols, colStartNum).equals("")){
		   cols++;
		  }
		  System.out.println("columns: "+cols);
		  //read data
		  int dataRow=0;
		  Object[][] data =new Object[rows][1];
		  Hashtable<String, String> table=null;
		  for(int rnum=dataStartNum;rnum<dataStartNum+rows;rnum++){
			  table=new Hashtable<String, String>();
		   for (int cnum = 0; cnum < cols; cnum++) {
			   String key=xls_Reader.getCellData(sheetName, cnum, colStartNum);//taking col name
			   String value= xls_Reader.getCellData(sheetName, cnum, rnum);
			   table.put(key, value);
		   }
		   data[dataRow][0]=table;
		   dataRow++;
		  }
		 return data; 
	}
	
}
