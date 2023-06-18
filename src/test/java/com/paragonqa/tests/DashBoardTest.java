package com.paragonqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paragonqa.baseClass.BaseClass;
import com.paragonqa.pages.CatalogPage;
import com.paragonqa.pages.DashboardPage;
import com.paragonqa.pages.LoginPage;

public class DashBoardTest extends BaseClass {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	CatalogPage catalogpage;

	@Test
	public void AddProjectVerifcation() throws InterruptedException {
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		loginpage.loginToParagon(prop.getProperty("Email"), prop.getProperty("Password"));
		Thread.sleep(8000);
		DashboardPage.addNewProject();
	}

	@Test

	public void VerifyTheCatalogSearch() throws InterruptedException {
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		catalogpage = new CatalogPage();
		loginpage.loginToParagon(prop.getProperty("Email"), prop.getProperty("Password"));
		Assert.assertTrue(catalogpage.SearchIntegration(prop.getProperty("integration")));
	}

	@Test
	public void OAuthValidation() throws InterruptedException {
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		catalogpage = new CatalogPage();
		loginpage.loginToParagon(prop.getProperty("Email"), prop.getProperty("Password"));
		Boolean result = catalogpage.connectIntegration(prop.getProperty("integration"));
		Assert.assertTrue(result);
	}

}
