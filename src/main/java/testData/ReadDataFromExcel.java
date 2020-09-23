package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	static File path = null;
	static FileInputStream fin = null;
	static XSSFWorkbook wb = null;
	static XSSFSheet sh = null;
	static int rows = 0;
	static int cols = 0;
	static Map<String, String> data = null;
	static String key = null;
	static String value = null;
	static String currentTCName = null;

	public static void main(String[] args) {
		Map<String, String> testdata = getDataFromExcel("TestData", "AddFacilityType");

		System.out.println(testdata.get("Name"));
	}

	public static Map<String, String> getDataFromExcel(String sheetName, String tcName) {
		try {
			path = new File("E:\\ReadData.xlsx");
			fin = new FileInputStream(path);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(sheetName);
			rows = sh.getLastRowNum() - sh.getFirstRowNum();
			cols = sh.getRow(0).getLastCellNum();
			data = new HashedMap<String, String>();

			for (int i = 1; i <= rows; i++) {
				currentTCName = sh.getRow(i).getCell(0).getStringCellValue();

				if (currentTCName.equalsIgnoreCase(tcName)) {

					for (int j = 0; j < cols; j++) {

						key = sh.getRow(0).getCell(j).getStringCellValue();

						if (sh.getRow(i).getCell(j) != null) {
							if (sh.getRow(i).getCell(j).getCellType() == CellType.STRING)
								value = sh.getRow(i).getCell(j).getStringCellValue();
							else
								value = sh.getRow(i).getCell(j).getRawValue();
							data.put(key, value);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

}
