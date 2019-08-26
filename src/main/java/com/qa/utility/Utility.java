package com.qa.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;

public class Utility extends Base {

	public void uploadFile(String filePath) throws AWTException {
		System.out.println("Entering uploadFile>>>>>>>>>>>");

		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@DataProvider(name="getAllData")
	public static Object[][] getDataFromExcel() {
		Object[][] object = null;

		try {
			FileInputStream fis = new FileInputStream("D:\\all_files\\gmail.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);

			int totalColumns = sheet.getRow(0).getLastCellNum();
			System.out.println("Total Number of columns ->" + totalColumns);

			int totalRows = sheet.getLastRowNum()+1;
			System.out.println("Total Number of rows ->" + totalRows);
			
			object = new Object[totalRows][totalColumns];
			
			for (int i = 0; i < totalRows; i++) {

				for (int j = 0; j < totalColumns; j++) {
					object[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return object;

	}

}
