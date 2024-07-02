package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	public static String getData(String key) throws IOException {
		
		//create file class object
		File file = new File("C:\\Users\\shash\\OneDrive\\Documents\\TestData.properties");
		
		//create FileReader class object
		FileReader filereader= new FileReader(file);
		
		//Properties class object
		Properties prop= new Properties();
		
		//Load properties file
		prop.load(filereader);
		
		//call getValue()
		return (String) prop.get(key);
	}

}
