package com.flipkart.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	
	public static String[][] readData(String path, String SheetName) throws Exception 
	{
		
		File file=new File(path);
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(SheetName);
		
		int noOfRow=sheet.getLastRowNum()+1;
		Row row=sheet.getRow(sheet.getLastRowNum());
		int noOfCol=row.getLastCellNum();
		String[][] array=new String[noOfRow-1][noOfCol];
		System.out.println(noOfRow+" "+noOfCol);
		for(int i=1;i<noOfRow;i++)
		{
			for(int j=0;j<noOfCol;j++)
			{
				
				String str=sheet.getRow(i).getCell(j).getStringCellValue();
				array[i-1][j]=str;
			}
		}
		return array;
		
	}
	
	
}
