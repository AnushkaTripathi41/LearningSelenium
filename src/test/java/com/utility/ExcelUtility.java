package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String getTestData(int rowNumber, int cellNumber) throws InvalidFormatException, IOException {
		
		//create file class object
		File file=new File("\"C:\\Users\\shash\\Downloads\\TestData.xlsx\"");
		
		//create workbook object
		XSSFWorkbook book= new XSSFWorkbook(file);
		
		//create sheet object
		XSSFSheet sheet= book.getSheetAt(0);
		
		//specify the row and cell number
		return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		
	}
 
}
