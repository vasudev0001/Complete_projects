import java.io.FileInputStream;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcelHashMap1 {

	@Test(dataProvider = "main")
	public void run(Map<String, Object> a) {
		System.out.print(a.get("User Name") + "|" + a.get("Password") + "|" + a.get("page heading")+"|");
		System.out.println();
	}

	@DataProvider
	public static Object[] main() {
		String fileName = "WebtestData.xlsx";
		String sheetName = "Login Validation";
		return readExcelData(fileName, sheetName);
	}

	public static Object[] readExcelData(String fileName, String sheetName) {
		Workbook wb = null;
		Sheet sh = null;
		String projectPath = System.getProperty("user.dir") + "\\resources\\" + fileName;
		Map<String, Object> map;
		try {
			FileInputStream fis = new FileInputStream(projectPath);
			if (fileName.endsWith(".xls")) {
				wb = new HSSFWorkbook(fis);
			} else
				wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
		// it return last row number in sheet but it exclude last row number.
		int rowNum = sh.getLastRowNum();

		System.out.println("Last row number exclude table header row: " + rowNum);
		int rowNum1 = sh.getPhysicalNumberOfRows();
		System.out.println("physical number of rows: " + rowNum1);
		Object[] s = new Object[rowNum];

		for (int i = 1; i <= rowNum; i++) {
			int actCol = sh.getRow(0).getLastCellNum();
			map = new HashMap<String, Object>();
			for (int col = 0; col < actCol; col++) {
				String key = sh.getRow(0).getCell(col).toString();
				Cell data = sh.getRow(i).getCell(col);
				Object cellData = selectDataType(data);
				map.put(key, cellData);
				
			}
			s[i - 1] = map;
		}
		return s;
	}

	private static Object selectDataType(Cell cellvalue) {
		Object cellData = null;
		switch (cellvalue.getCellType()) {
		case NUMERIC:
			cellData = (int) cellvalue.getNumericCellValue();
			break;
		case STRING:
			cellData = cellvalue.getStringCellValue();
			break;
		case BOOLEAN:
			cellData = cellvalue.getBooleanCellValue();
			break;
		default:
			cellData = "";
			break;
		}
		return cellData;
	}
}
