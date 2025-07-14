package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.LoginData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;

public class LoginDataProviders {
	
	@DataProvider(name = "LoginTestDataProvider_JSON")
	public Iterator<Object[]> loginDataProvider_Json() {
		
		Gson gson = new Gson();
		
		File loginDataFile = new File(System.getProperty("user.dir")+"\\testdata\\login-data.json");
		FileReader reader = null;
		try {
			reader = new FileReader(loginDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LoginData loginData = gson.fromJson(reader, LoginData.class);
		
		List<Object[]> datas = new ArrayList<>();
		
		for(User user : loginData.getData()) {
			datas.add(new Object[] {user});
		}
		
		return datas.iterator();
	}
	
	@DataProvider(name = "LoginTestDataProvider_CSV")
	public Iterator<User> loginDataProvider_CSV() {
		return CSVReaderUtility.readCSVFile("login-data.csv");
	}

}
