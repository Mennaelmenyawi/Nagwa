package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null ;

	public FileInputStream getfileInputStream()
	{      
		String filepath = System.getProperty("user.dir")+"/src/test/java/Data/task.xlsx";
		File SrcFile = new File(filepath);

		try {
			fis = new FileInputStream(SrcFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			System.exit(0);
		}
		return fis;

	}

	public Object [][]getExcelData () throws IOException

	{
		fis = getfileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheetAt(0);

		int TotalNumberofRows = (Sheet.getLastRowNum()+1);
		int total_numberof_Cols = 5;

		String [][]arrayExcelData = new String[TotalNumberofRows][total_numberof_Cols];
		for (int i = 0; i < TotalNumberofRows; i++) 
		{
			for (int j = 0; j < total_numberof_Cols; j++) {
				XSSFRow row = Sheet.getRow(i);
				arrayExcelData[i][j]= row.getCell(j).toString();
				

			}	   
		}
		wb.close();
		return arrayExcelData;



	}
}
