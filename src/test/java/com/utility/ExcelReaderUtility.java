package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		File file = new File(System.getProperty("user.dir")+"//testdata//"+fileName+".xlsx");
		
		//Create XSSFWorkbook
		XSSFWorkbook workbook;
		//Get Sheet
		XSSFSheet sheet;
		Iterator<Row> iterator;
		Row dataRow;
		Cell emailAddressCell;
		Cell passwordCell;
		Cell accountNameCell;
		List<User> userList = null;
		User user;
		
		try {
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet("LoginTestData");
			iterator = sheet.iterator();
			iterator.next(); // To Skip the first row/Column name
			userList = new ArrayList<User>();
			while(iterator.hasNext()) {
				dataRow = iterator.next();
				emailAddressCell = dataRow.getCell(0);
				passwordCell = dataRow.getCell(1);
				accountNameCell = dataRow.getCell(2);
				user = new User(emailAddressCell.toString(), passwordCell.toString(), accountNameCell.toString());
				userList.add(user);
				workbook.close();
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
