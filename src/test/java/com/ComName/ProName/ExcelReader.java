package com.ComName.ProName;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	 private XSSFWorkbook workbook = null;
	 private XSSFSheet sheet1 =null;
	 private XSSFRow row =null;
	 private XSSFCell cell=null;
	 public FileInputStream fis=null;
	 public String path;
		 
		 public ExcelReader(String path) {
				
				
			 this.path = path;
				try {
						
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				
				fis.close();
				
				} catch (Exception e) {
					
					
					System.out.println(e.getMessage());
				}
		 }
		 
 public int getRowCount(String sheetName)
		  {
		    int index = this.workbook.getSheetIndex(sheetName);
		    if (index == -1) {
		      return 0;
		    }
		    this.sheet1 = this.workbook.getSheetAt(index);
		    int number = this.sheet1.getLastRowNum() + 1;
		    return number;
		  }
		 
		 
	
public String getCellData(String sheetName, int colNum, int rowNum) 
{
	
	try {	
	if (rowNum <= 0)
			return"";
					
	int index = workbook.getSheetIndex(sheetName);
		
		if (index == -1)
			return"";
	
	sheet1 = workbook.getSheetAt(index);
	row =sheet1.getRow(rowNum -1);
	
	if (row == null)
		return"";
	
	cell = row.getCell(colNum);
	if (cell == null)
		return"";
	
	return cell.getStringCellValue();
	
	
} catch (Exception e) {
	 
	e.printStackTrace();
	return "row" + rowNum + " or column " + colNum + "does not exist in xls ";
}

			
}

public String getCellData(String sheetName, String colName, int rowNum) 
{
	
	try {	
	if (rowNum <= 0)
			return"";
					
	int index = workbook.getSheetIndex(sheetName);
	int col_Num = -1;
	if (index == -1)
		return"";

	sheet1 = workbook.getSheetAt(index);
	row =sheet1.getRow(0);
	
	for (int i = 0; i < row.getLastCellNum(); i++) {
		
		if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
			col_Num = i;
	}
	if (col_Num == -1)
		return "";
	
	sheet1 = workbook.getSheetAt(index);
	row =sheet1.getRow(rowNum -1);
	
	if (row == null)
		return"";
	
	cell = row.getCell(col_Num);
	if (cell == null)
		return"";
	
	return cell.getStringCellValue();
	
	} catch (Exception e) {
		 
		e.printStackTrace();
		return "row" + rowNum + " or column " + colName + "does not exist in xls ";
	}
	}
	
	
	}
	






