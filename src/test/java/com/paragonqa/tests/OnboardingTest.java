package com.paragonqa.tests;

import org.testng.annotations.Test;

import com.paragonqa.baseClass.BaseClass;
import com.paragonqa.pages.LoginPage;
import com.paragonqa.pages.SignUpPage;

public class OnboardingTest extends BaseClass {
	LoginPage loginpage;
	SignUpPage signup;

	@Test
	public void VerifytheSuccessfulOnboarding() {
		loginpage = new LoginPage();
		signup = loginpage.OnboardaNewUser();
		signup.signUpToParagonStep1(prop.getProperty("f_name"), prop.getProperty("l_name"),
				prop.getProperty("User_email"), prop.getProperty("pass"));
		signup.signUpToParagonStep2(prop.getProperty("company"), prop.getProperty("integration"));
	}

}
