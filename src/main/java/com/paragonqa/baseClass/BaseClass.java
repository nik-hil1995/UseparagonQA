package com.paragonqa.baseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties Loc = new Properties();
	public static FileReader fr;
	public static FileReader lr;

	@BeforeMethod
	public WebDriver setUp() throws IOException {

		if (driver == null) {
			fr = new FileReader(System.getProperty("user.dir") + "\\Configs\\Config.properties");
			lr = new FileReader(System.getProperty("user.dir") + "\\Configs\\Locators.properties");
			prop.load(fr);
			Loc.load(lr);
		}
		if (prop.getProperty("browserName").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		((HasAuthentication) driver).register(UsernameAndPassword.of("bobo", "{Kufjb#wokpAQz"));
		driver.get(prop.getProperty("URL"));
		return driver;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
