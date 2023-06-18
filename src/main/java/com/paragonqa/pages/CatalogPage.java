package com.paragonqa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paragonqa.baseClass.BaseClass;
import com.paragonqa.utilities.ActionDriver;

public class CatalogPage extends BaseClass {

	ActionDriver act = new ActionDriver(); // creating object of Actiondriver class

	public CatalogPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Search integrations']")
	WebElement searchIntegrationBox;

	@FindBy(css = ".IntegrationBox__IntegrationName-cibqz5-3.kKrNdy")
	WebElement integrationCard;

	@FindBy(xpath = "//div[@class='IntegrationPopup__InfoBodyLeft-xdpivj-8 icGNSd']//button")
	WebElement connectBtn;

	@FindBy(xpath = "//button[@data-testid='preview-button']")
	WebElement previewBtn;

	@FindBy(xpath = "//button[@data-testid='enable-button']")
	WebElement autheticateBtn;

	@FindBy(xpath = "//div[@class='SideBar__RootNavigation-sc-1k285h4-1 eQomCq']//a[3]")
	WebElement catalogOption;

	// google login window
	@FindBy(xpath = "//input[@type='email']")
	WebElement gmail_id;

	@FindBy(xpath = "//input[@type='password']")
	WebElement gmail_pass;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextbtn;

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continueBtn;

	public boolean SearchIntegration(String integration_name) throws InterruptedException {
		act.clickToElement(driver, catalogOption);
		searchIntegrationBox.sendKeys(integration_name);
		Thread.sleep(4000);
		if ((integrationCard.getText()).equalsIgnoreCase(integration_name)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean connectIntegration(String integration_name) throws InterruptedException {
		DashboardPage.addNewProject();
		SearchIntegration(integration_name);
		integrationCard.click();
		act.waitUntilClickable(driver, connectBtn);
		act.waitUntilClickable(driver, previewBtn);
		Thread.sleep(5000);
		autheticateBtn.click();
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		gmail_id.sendKeys(prop.getProperty("gmailEmail"));
		Thread.sleep(2000);
		nextbtn.click();
		Thread.sleep(2000);
		gmail_pass.sendKeys(prop.getProperty("gmailPass"));
		Thread.sleep(2000);
		nextbtn.click();
		Thread.sleep(2000);
		continueBtn.click();
		Thread.sleep(4000);
		driver.switchTo().window(parent);
		if ((autheticateBtn.getText()).equalsIgnoreCase("connected")) {
			return true;
		} else {
			return false;
		}
	}

}
