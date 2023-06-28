import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelExample2 {

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		File f = new File(path + "\\resources\\WebtestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Login Validation");
		int lastCell = sheet.getRow(0).getPhysicalNumberOfCells(); // It return last row inddex number.
		int num =sheet.getLastRowNum();
		System.out.println(num);
		System.out.println("last row number: "+lastCell);
		Object a=null;
		for(int i=1;i<=num;i++) {
				for(int j=0;j<lastCell;j++) {
					XSSFCell cell_value=sheet.getRow(i).getCell(j);
					switch(cell_value.getCellType()) {
					case NUMERIC:
						a=cell_value.getNumericCellValue();
						break;
					case STRING:
						a=cell_value.getStringCellValue();
						break;
					case BOOLEAN:
						a=cell_value.getBooleanCellValue();
						break;
						default:
							a="";
					}
					System.out.print(a+" ");
				}
				System.out.println();
			}
		book.close();
		fis.close();
		}
	}
