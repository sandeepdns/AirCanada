package com.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

public class configFileReader {
private Properties properties;
private String propertyFilePath = "Config/config.properties";

public configFileReader() throws IOException {
	BufferedReader reader;
	reader = new BufferedReader(new FileReader(propertyFilePath));
	properties = new Properties();
	
	properties.load(reader);
	reader.close();
}

public String getConfigData(String propertyName) {
	String JenkinsParam = System.getProperty(propertyName);
	if(JenkinsParam!= null) return JenkinsParam;
	
	String localParam = properties.getProperty(propertyName);
	if(localParam!=null) return localParam;
	else throw new RuntimeException(propertyName + " not found in config file");
}
public String getEncryptedConfigData(String propertyName) {
	String JenkinsParam = System.getProperty(propertyName);
	if(JenkinsParam!= null) return JenkinsParam;
	
	String localParam = properties.getProperty(propertyName);
	localParam = new String(Base64.decodeBase64(localParam));
	if(localParam.length()>0) return localParam;
	else throw new RuntimeException(propertyName + " not found in config file");
}

}
