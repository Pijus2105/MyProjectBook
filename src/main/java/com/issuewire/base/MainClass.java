package com.issuewire.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass {

	Properties prop;
	WebDriver driver;
	
	//Method For Pull The Configuration File
	@BeforeTest
	public void base() {
		
		//New Properties Object Create(Because In This Properties Will Be Load The Configuration File)
		
		try {
			 prop = new Properties();
			 
			 File file = new File("C:\\Users\\PERFECT.DESKTOP-HCSN4U9\\eclipse-workspace\\IssueWire_POM_PR\\Configuration");
			 
			 FileInputStream IP;
			IP = new FileInputStream(file);
			try {
				prop.load(IP);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	//Method For Launch Browser
	public void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
		//This line for get the browser from Configuration File
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")) {
			driver = new ChromeDriver();
			
			
		} else if (browserName.contains("Firefox")){
			driver = new FirefoxDriver();
			
		} else if (browserName.contains("Internet Explorer")){
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	
			
		
	}
	
	
	
	
	
	
	
}
