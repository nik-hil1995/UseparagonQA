package com.paragonqa.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFileProperties {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(
				"C:\\Users\\NIkhil Kumar\\eclipse-workspace\\ParagonQA\\Configs\\Config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		System.out.println(prop.getProperty("browserName"));
	}

}
