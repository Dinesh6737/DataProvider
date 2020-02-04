package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataExcel {
	public static Object[][] getData() throws Exception {
		String name = "";
		File f = new File("C:\\Users\\SONY\\eclipse-workspace\\Dinesh\\DataproviderwithExcelsheet\\Excel\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row headerRow = s.getRow(0);
		int rowcount = s.getPhysicalNumberOfRows();
		int cellcount = headerRow.getPhysicalNumberOfCells();
		Object[][] obj = new Object[rowcount-1][cellcount];
		for (int i = 1; i < rowcount-1; i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if (type == 1) {
					name = c.getStringCellValue();
				} else {
					if (DateUtil.isCellDateFormatted(c)) {
						Date date = c.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yy");
						name = sim.format(date);
					} else {
						double d = c.getNumericCellValue();
						long l = (long) d;
						name = String.valueOf(l);
					}
				}
				obj[i][j] = name;
			}

		}
		return obj;
	}
	@DataProvider(name="res")
		public static Object[][] data() throws Exception{
			return getData();
		}
}
