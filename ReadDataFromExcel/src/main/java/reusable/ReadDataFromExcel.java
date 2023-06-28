package reusable;

import java.io.File;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static Object[][] getExcelData() {
		Sheet excelSheet = getExcelWorkBook();
		int tableRows = excelSheet.getLastRowNum();
		int rowCells = excelSheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] excelData = new Object[tableRows][rowCells];
		for (int row = 1; row <= tableRows; row++) {
			for (int column = 0; column < rowCells; column++) {
				Cell cellValue = excelSheet.getRow(row).getCell(column);
				Object cellData = null;

				switch (cellValue.getCellType()) {
				case NUMERIC:
					cellData = String.valueOf((int) cellValue.getNumericCellValue());
					break;
				case BOOLEAN:
					cellData = cellValue.getBooleanCellValue();
					break;
				case STRING:
					cellData = String.valueOf(cellValue.getStringCellValue());
					break;
				default:
					cellData = "";
					break;
				}
				excelData[row - 1][column] = cellData;
			}
		}
		return excelData; 
	}

	private static Sheet getExcelWorkBook() {
		Workbook workbook = null;
		Sheet excelSheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\HRMLoginData.xlsx";
		File file = new File(path);
		try {
			FileInputStream fis = new FileInputStream(file);
			if (path.toString().endsWith(".xls")) {
				workbook = new HSSFWorkbook(fis);
			} else {
				workbook = new XSSFWorkbook(fis);
			}
			excelSheet = workbook.getSheet("Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelSheet;
	}
}
