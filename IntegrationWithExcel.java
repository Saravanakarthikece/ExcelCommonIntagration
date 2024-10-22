package ExcelIntagration;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IntegrationWithExcel {
	
	public static String[][] readData(String excelName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+excelName+".xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short cellCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellCount;j++) {
				String stringCellValue = row.getCell(j).getStringCellValue();
				data[i-1][j]=stringCellValue;
				}
		}
		
		return data;

	}

} 
