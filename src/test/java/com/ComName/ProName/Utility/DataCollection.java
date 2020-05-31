package com.ComName.ProName.Utility;

import java.util.Hashtable;

import com.ComName.ProName.ExcelReader;


public class DataCollection
{
  String testDataSheetName;
  String testCaseName;
  ExcelReader excel;

  public DataCollection(ExcelReader excel, String testDataSheetName, String testCaseName)
  {
    this.excel = excel;
    this.testCaseName = testCaseName;
    this.testDataSheetName = testDataSheetName;
  }

  public Object[][] dataArray()
  {
    int TestcaseRowNum = 1;

    while (!this.excel.getCellData(this.testDataSheetName, 0, TestcaseRowNum).equalsIgnoreCase(this.testCaseName))
    {
      TestcaseRowNum++;
    }

    System.out.println(this.testCaseName + " test case starts from row number :- " + TestcaseRowNum);

    int colsStartRowNum = TestcaseRowNum + 1;
    int dataStartRowNum = colsStartRowNum + 1;

    int cols = 0;

    while (!this.excel.getCellData(this.testDataSheetName, cols, colsStartRowNum).trim().equals(""))
    {
      cols++;
    }

    System.out.println("Total number of columns are:- " + cols);

    int rows = 0;

    while (!this.excel.getCellData(this.testDataSheetName, 0, dataStartRowNum + rows).trim().equals(""))
    {
      rows++;
    }

    System.out.println("Total number of iterations/rows are :- " + rows);
    System.out.println("***************************************************");

    Object[][] htdata = new Object[rows][1];

    int i = 0;

    for (int row = dataStartRowNum; row < dataStartRowNum + rows; row++)
    {
      Hashtable htable = new Hashtable();

      for (int col = 0; col < cols; col++)
      {
        String colName = this.excel.getCellData(this.testDataSheetName, col, colsStartRowNum);
        String tdata = this.excel.getCellData(this.testDataSheetName, col, row);

        htable.put(colName, tdata);
      }

      System.out.println();
      htdata[i][0] = htable;
      Object data = htdata[i][0];
      System.out.println("----" + data);
      i++;
    }

    return htdata;
  }
}