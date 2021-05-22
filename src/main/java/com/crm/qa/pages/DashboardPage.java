package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DashboardPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeTab;

	// Initializing the Page Objects:
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean validateHomeTab() {
		TestUtil.switchToFrame();
		boolean flag = homeTab.isDisplayed();
		return flag;
	}
}