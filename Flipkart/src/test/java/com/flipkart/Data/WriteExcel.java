package com.flipkart.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void writtingToEcecl(String path, String sheetName, int rowNo, String data) throws Throwable
	{
		File file=new File(path);
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		sheet.getRow(rowNo).createCell(2).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(file);
		wb.write(fout);
		
	}
}
