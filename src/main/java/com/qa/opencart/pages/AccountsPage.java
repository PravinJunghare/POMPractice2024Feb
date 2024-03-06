package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	// 1 Private Webdriver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. Page constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3 Private BY loctaors

	private By logoutLink = By.linkText("Logout");
	private By accHeader = By.xpath("//div[@id='content']//h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");

	// 4 Page Actions/Methods

	public String getAccPageTitle() {

		// String title = driver.getTitle();
		//String title = eleUtil.waitForTitleIsAndFetch(10, "My Account");
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Account Page Title is: " + title);
		return title;
	}

	public String getAccPageUrl() {
		// String url = driver.getCurrentUrl();
		//String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/account");
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Account Page Url is: " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		// return driver.findElement(logoutLink).isDisplayed();
		// return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
		return eleUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}

	public boolean isSearchExist() {
		// return driver.findElement(search).isDisplayed();
		return eleUtil.getElement(search).isDisplayed();
	}

	public List<String> getAccountPageHeadersList() {
		// List<WebElement> accHeaderslist = driver.findElements(accHeader);

		// List<WebElement> accHeaderslist = eleUtil.waitForElementsVisible(accHeader,
		// 10);
		List<WebElement> accHeaderslist = eleUtil.waitForElementsVisible(accHeader,
				AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		List<String> accHeaderValList = new ArrayList<String>();

		for (WebElement e : accHeaderslist) {
			String text = e.getText();
			accHeaderValList.add(text);
		}
		return accHeaderValList;
	}
}
