package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.BaseClass.BaseClass;

public class TestUtil extends BaseClass{
	
public TestUtil() throws Exception {
		super();
		
	}

public static long PAFGE_LOAD_TIMEOUT=50;
public static long IMPLIICIT_WAIT=50;
static Workbook book;
static org.apache.poi.ss.usermodel.Sheet sheet;
public static String TESTDATA_SHEET_PATH="C:\\Users\\USER\\eclipse-workspace\\EightandaboveTest\\src\\main\\java\\com"
		+ "\\Eightandabove\\qa\\Testdata\\8andabove Data.xlsx";


public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}

public void takeScreenshotAtEndOfTest() throws IOException {
	
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentdir=System.getProperty("user.dir");
	FileUtils.copyFile(src, new File(currentdir + "/screens"
			+ "hots/" +System.currentTimeMillis()+ ".png"));
	
}
}
