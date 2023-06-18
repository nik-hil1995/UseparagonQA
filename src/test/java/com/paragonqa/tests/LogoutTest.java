package com.paragonqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paragonqa.baseClass.BaseClass;
import com.paragonqa.pages.DashboardPage;
import com.paragonqa.pages.LoginPage;

public class LogoutTest extends BaseClass {
	LoginPage loginpage;
	DashboardPage dashboardpage;

	@Test
	public void VerifyTheUserSignOut() {
		loginpage = new LoginPage();
		dashboardpage = loginpage.loginToParagon(prop.getProperty("Email"), prop.getProperty("Password"));
		Assert.assertTrue(dashboardpage.SignOut()); // checking the login page url

	}

}
