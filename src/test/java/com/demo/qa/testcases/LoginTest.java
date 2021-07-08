package com.demo.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.qa.pages.LoginPage;
import com.demo.qa.testbase.TestBase;

public class LoginTest extends TestBase{

	@BeforeTest
    public void browserLaunch() throws IOException {
		readPropertiesFile();
		browserInitialization();
	}
	
	@Test
	public void loginTest() {
		LoginPage lp=new LoginPage();
		lp.login();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
