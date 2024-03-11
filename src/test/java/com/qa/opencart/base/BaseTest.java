package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop=df.initProp();
		//driver = df.initDriver("chrome");
		driver = df.initDriver(prop);
		loginPage= new LoginPage(driver);
		accountsPage=new AccountsPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
