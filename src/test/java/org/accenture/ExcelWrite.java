package org.accenture;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void excelWrite(String name, String price) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\home\\eclipse-workspace\\Pennycom\\ReadExcel\\recordDetails.xlsx");
		
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Sheet1");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue(name);
		Cell c1 = r.createCell(1);
		c1.setCellValue(price);
		 w.write(fos);
		
		
		
		
	}
}
