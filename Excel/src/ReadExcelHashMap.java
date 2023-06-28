import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// printing excel data
public class ReadExcelHashMap {

	@Test(dataProvider="run")
	public void hash(HashMap<String, Object> a) throws  IOException {
		Object s=false;
		String un=a.get("User Name").toString();
		String pw=a.get("Password").toString();
		String pageHeading=a.get("page heading").toString();
		System.out.print(un+"||");
		System.out.print(pw+"||");
		System.out.print(pageHeading);
		System.out.println();
	}
	
	@DataProvider
	public Object[] run() throws  IOException {
		Object[] a=readExcel("WebtestData.xlsx","Login Validation");
		System.out.println(a.length);
		return a;
	}

	public Object[] readExcel(String excelName,String sheetName) throws IOException {
		String path = System.getProperty("user.dir");
		File f = new File(path + "\\resources\\"+excelName);
		System.out.println(f.exists());
		Workbook book = WorkbookFactory.create(f);
		Sheet sh = book.getSheet(sheetName);
		int row = sh.getLastRowNum();
		short col = sh.getRow(0).getLastCellNum();
		System.out.println("Rows in sheet: " + row);
		System.out.println("Table columns: " + col);
		Map<String, Object> map;
		Object[] s= new Object[row];
		Object value=null;
		for (int i = 1; i <= row; i++) {
			map = new HashMap<String, Object>();
			for (int j = 0; j < col; j++) {
				String key = sh.getRow(0).getCell(j).toString();
				Cell Cellvalue = sh.getRow(i).getCell(j);
				switch (Cellvalue.getCellType()) {
				case NUMERIC:
					value = (int)Cellvalue.getNumericCellValue();
					break;
				case STRING:
					value = Cellvalue.getStringCellValue();
					break;
				case BOOLEAN:
					value = Cellvalue.getBooleanCellValue();
					break;
				default:
					value = "";
				}
				map.put(key, value);
				s[i-1]=map;	
			}
			
		}
		return s;
	}
}
