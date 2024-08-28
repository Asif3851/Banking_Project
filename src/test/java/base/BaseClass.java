package base;

import java.io.File;
import java.io.IOException;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utiles.Read_baseUtiles;

public class BaseClass {

	public static WebDriver d;
//	 ChromeOptions co;
	public static String username = "mngr583983";
	public static String userpass = "EmEbenA";
	Read_baseUtiles read = new Read_baseUtiles();
	
	@BeforeClass
	public void setUP() throws IOException {
		if(read.getBrowser().equalsIgnoreCase("chrome")) {
			ChromeOptions co =new ChromeOptions();
			co.addExtensions(new File("D:\\Automation\\Banking\\Extensions\\FreeAdBlocker.crx"));
			d= new ChromeDriver(co);
			d.get(read.getBaseUrl());
		}
	}
	
//	@AfterClass
//	public void end() {
//		System.out.println("End Browser");
//		d.close();
//	}
}
