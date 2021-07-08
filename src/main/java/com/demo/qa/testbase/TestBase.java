package com.demo.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.qa.utils.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public void readPropertiesFile() throws IOException {
		File file = new File("D:\\Automation-Testing\\MavenDemo\\src\\main\\java\\com\\demo\\qa\\config\\config.properties");
		FileInputStream fis= new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);				
	}

	public void browserInitialization() {
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://Automation-Testing//Drivers//chromedriver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D://Automation-Testing//Drivers//geckodriver//geckodriver.exe");
			driver =  new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver. manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAITTIME, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}
	
	}
