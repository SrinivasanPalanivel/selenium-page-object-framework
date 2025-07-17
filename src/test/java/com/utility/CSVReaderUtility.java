package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile(String fileName) {
		
		File file = new File(System.getProperty("user.dir")+"\\testdata\\"+ fileName +".csv");
		FileReader reader;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;
		
		try {
			reader = new FileReader(file);
			csvReader = new CSVReader(reader);
			csvReader.readNext(); //To skip the column names
			userList = new ArrayList<>();
			
			while((line =  csvReader.readNext())!= null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
		 
	}

}
