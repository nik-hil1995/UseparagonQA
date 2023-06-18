package com.paragonqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paragonqa.baseClass.BaseClass;

public class DashboardPage extends BaseClass {

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".UserMenu__DisplayName-bgv9r1-1.ftqaSK")
	WebElement ProfileBtn;

	@FindBy(xpath = "(//div[@class='popup-content ']//li)[13]")
	WebElement SignOutBtn;

	@FindBy(xpath = "//button[@title='+ New Integration']")
	WebElement addIntegrationBtn;

	@FindBy(xpath = "//div[@data-testid='project-selector']")
	static WebElement projectSelector;

	@FindBy(xpath = "//button[@title='Create']")
	static WebElement createProjBtn;

	@FindBy(css = ".TextInput__TextInputElement-kos1xm-4.kkGUJO")
	static WebElement projectName;

	@FindBy(xpath = "(//div[@class='common__ButtonsWrapper-sc-104we43-7 jlaWXo']//button)[1]")
	static WebElement createProjectBtn;

	public boolean SignOut() {
		ProfileBtn.click();
		SignOutBtn.click();
		if (driver.getCurrentUrl().contains("login")) {
			return true;
		} else {
			return false;
		}
	}

	public static CatalogPage addNewProject() {
		projectSelector.click();
		createProjBtn.click();
		projectName.sendKeys("automationtest11");
		createProjectBtn.click();
		return new CatalogPage();
	}

}
