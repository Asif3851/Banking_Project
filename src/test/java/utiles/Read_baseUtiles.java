package utiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Read_baseUtiles {

	static Properties prop;
	static FileReader fr;
	
	public String getBrowser() throws IOException {
		fr = new FileReader("D:\\Automation\\Banking\\Config\\baseconfigs");
		prop = new Properties();
		prop.load(fr);
		String browser = prop.getProperty("Browser");
		return browser;
	}
	public String getBaseUrl() throws IOException {
		fr = new FileReader("D:\\Automation\\Banking\\Config\\baseconfigs");
		prop = new Properties();
		prop.load(fr);
		String BaseUrl = prop.getProperty("BaseURL");
		return BaseUrl;
	}
}
