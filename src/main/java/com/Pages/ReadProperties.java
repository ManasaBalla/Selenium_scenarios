package com.Pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//import com.google.j2objc.annotations.Property;

public class ReadProperties {
	
	String propertyFilePath = "src/test/resources/Info.properties";
	Properties prop;
	
	public ReadProperties() {
	
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 prop = new Properties();
	 try {
	 prop.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getMobile(){
		 
	 String mobile = prop.getProperty("mobile");

	 if(mobile==null)
		 throw new RuntimeException("mobile number is not present in the properties file");
	 
	 return mobile;
}
	 
	 public String getPassword() {
		 
		 String password = prop.getProperty("password");
		 if(password==null)
			 throw new RuntimeException("password is not present in the properties file");
		return password;
	 }

}
