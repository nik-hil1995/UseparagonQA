package com.paragonqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.paragonqa.baseClass.BaseClass;

public class SignUpPage extends BaseClass {

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signupbtn;

	@FindBy(xpath = "//input[@data-testid='add-team-details-company-name']")
	WebElement CompanyName;

	@FindBy(xpath = "(//select[@class='Select__SelectElement-sc-8katwa-2 kfvUkQ'])[1]")
	WebElement CompanySize;

	@FindBy(xpath = "(//select[@class='Select__SelectElement-sc-8katwa-2 kfvUkQ'])[2]")
	WebElement role;

	@FindBy(xpath = "//textarea[@data-testid='add-team-details-reasons']")
	WebElement integrationName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueBtn;

	public void signUpToParagonStep1(String f_name, String l_name, String user_email, String user_pass) {
		// driver.get(prop.getProperty("SignUpURL"));
		firstName.sendKeys(f_name);
		lastName.sendKeys(l_name);
		Email.sendKeys(user_email);
		password.sendKeys(user_pass);
		signupbtn.click();

	}

	public void signUpToParagonStep2(String Company, String integration) {
		CompanyName.sendKeys(Company);
		Select select = new Select(CompanySize);
		select.selectByIndex(1);
		Select select1 = new Select(role);
		select1.selectByIndex(1);
		integrationName.sendKeys(integration);
		continueBtn.click();
	}

}
