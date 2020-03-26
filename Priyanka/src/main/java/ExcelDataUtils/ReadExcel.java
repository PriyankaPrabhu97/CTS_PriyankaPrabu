package ExcelDataUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import BasicUtilities.logger;

public class ReadExcel {
		public static int r,c;
		static WebDriver dr;
		public String[][] testdata;
		static logger log= new logger(dr);
		
		
		//function to read a data from Excel
	public String[][] get_data(String SheetName, int s, int k) {
		
		testdata=new String[s][k];
	try {
	File f=new File("src\\test\\resources\\ExcelSheet\\TestData.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sh=wb.getSheet(SheetName);
	for(r=1;r<s+1;r++) {
	XSSFRow row=sh.getRow(r);

	for(c=0;c<k;c++) {
	XSSFCell cell =row.getCell(c);
	testdata[r-1][c]=cell.getStringCellValue();
	System.out.println(testdata[r-1][c]);
	}
	}
	
	} catch (FileNotFoundException e) {
		
		log.Update_log("Exception in Reading Excel Method");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testdata;
	}

}
			

