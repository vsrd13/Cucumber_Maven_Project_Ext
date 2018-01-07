package com.cucumber.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datahelper {

	// public static HashMap<String,String> storeValues = new HashMap();

	// @SuppressWarnings("deprecation")
	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		List<HashMap<String, String>> mydata1 = new ArrayList<HashMap<String, String>>();

		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			Row HeaderRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 1; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellTypeEnum()) {
					case STRING:
						// DataFormatter formatter = new DataFormatter();
						// String value =
						// formatter.formatCellValue(currentCell);
						System.out.print(currentCell.getStringCellValue() + "\t");
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					case NUMERIC:
						// DataFormatter formatter = new DataFormatter();
						// String value =
						// formatter.formatCellValue(currentCell);
						if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							currentCell.setCellType(CellType.STRING);
							;
							;
							System.out.print(currentCell.getStringCellValue() + "\t");

							currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
									currentCell.getStringCellValue());
						} else {
							System.out.println("Can't read the value");
						}

						break;
					default:
						break;
					}
				}
				mydata1.add(currentHash);
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata1;

	}
}
