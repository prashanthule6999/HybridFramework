package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DashboardPage;
import com.crm.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = new DashboardPage();
	}

	@Test(priority = 4)
	public void validateUserTest() {
		boolean acutalResult = dashboardPage.validateHomeTab();
		Assert.assertTrue(acutalResult, "Home Tab is not Present on CRM Dashboard");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}