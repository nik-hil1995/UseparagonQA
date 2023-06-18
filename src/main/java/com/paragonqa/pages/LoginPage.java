package com.paragonqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paragonqa.baseClass.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement EmailField;

	@FindBy(xpath = "//input[@type='password']")
	WebElement PasswordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;

	@FindBy(xpath = "//span[contains(text(),'Invalid login credentials.')]")
	WebElement ErrorMsg;

	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	WebElement createAccountBtn;

	public DashboardPage loginToParagon(String Email, String Password) {
		EmailField.sendKeys(Email);
		PasswordField.sendKeys(Password);
		LoginBtn.click();
		return new DashboardPage();
	}

	public boolean checkValidation() {
		if (ErrorMsg.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public SignUpPage OnboardaNewUser() {
		createAccountBtn.click();
		return new SignUpPage();

	}

}
