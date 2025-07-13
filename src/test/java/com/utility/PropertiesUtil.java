package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperties(Env env, String propertieKey) {
		
		File file = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");	
		Properties propertie = new Properties();
		FileReader reader;
		try {
			reader = new FileReader(file);
			propertie.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = propertie.getProperty(propertieKey.toUpperCase());
		return value;
	}

}
