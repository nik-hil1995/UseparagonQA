package com.paragonqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paragonqa.baseClass.BaseClass;
import com.paragonqa.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginpage;

	@Test
	public void VerifyTheSuccessfullLogin() {
		loginpage = new LoginPage();
		loginpage.loginToParagon(prop.getProperty("Email"), prop.getProperty("Password"));

	}

	@Test
	public void VerifytheInvalidLogin() {
		loginpage.loginToParagon("test@test.com", "password");
		Assert.assertTrue(loginpage.checkValidation());
	}

}
