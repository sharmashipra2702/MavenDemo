package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.testbase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//a[@href= 'https://ui.cogmento.com']")
	WebElement loginButtonHome;

	@FindBy(xpath="//input[@name ='email']")
	WebElement emailId;

	@FindBy(xpath="//input[@name ='password']")
	WebElement password;

	@FindBy(xpath= "//div[contains(@class,'submit button')]")
	WebElement loginButton;

	@FindBy(xpath= "//button[text()='Got It']")
	WebElement gotItButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
		gotItButton.click();
		loginButtonHome.click();
	}

	public void login() {
		emailId.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
	}
}
