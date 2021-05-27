package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class DashboardPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeTab;

	@FindBy(xpath = "//*[@title='Call']")
	WebElement callTab;

	@FindBy(xpath = "//*[@title='Reports']")
	WebElement reportsTab;

	@FindBy(xpath = "//td[@align='left'and @class='headertext']")
	WebElement username;

	@FindBy(xpath = "//td[@class='logo_text']")
	WebElement logoText;

	@FindBy(css = "div>.footnote")
	WebElement country;

	// Initializing the Page Objects:
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean validateHomeTab() {
		boolean flag = homeTab.isDisplayed();
		return flag;
	}

	public boolean validateCallTab() {
		boolean flag = callTab.isDisplayed();
		return flag;
	}

	public boolean validateReportsTab() {
		boolean flag = reportsTab.isDisplayed();
		return flag;
	}

	public String validateUsername() {
		return username.getText().trim();
	}

	public String validateLogoText() {
		return logoText.getText().trim();
	}

	public String validateCountry() {
		String str[] = country.getText().split(" ");
		String str1[] = str[7].split("\n");
		return str1[0].trim();
	}
}