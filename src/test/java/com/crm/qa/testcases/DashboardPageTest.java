package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DashboardPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

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
		TestUtil.switchToFrame();
	}

	@Test(priority = 4)
	public void validateHomeTabTest() {
		boolean acutalResult = dashboardPage.validateHomeTab();
		Assert.assertTrue(acutalResult, "Home Tab is not Present on CRM Dashboard");
	}

	@Test(priority = 5)
	public void validateCallTabTest() {
		boolean acutalResult = dashboardPage.validateCallTab();
		Assert.assertTrue(acutalResult, "Call Tab is not Present on CRM Dashboard");
	}

	@Test(priority = 6)
	public void validateReportsTabTest() {
		boolean acutalResult = dashboardPage.validateReportsTab();
		Assert.assertTrue(acutalResult, "Reports Tab is not Present on CRM Dashboard");
	}

	@Test(priority = 7)
	public void validateUsernameTest() {
		String acutalResult = dashboardPage.validateUsername();
		Assert.assertEquals(acutalResult, "User: Mukesh Otwani", "User Name Mismatch");
	}

	@Test(priority = 8)
	public void validateLogoTextTest() {
		String acutalResult = dashboardPage.validateLogoText();
		Assert.assertEquals(acutalResult, "CRMPRO", "Logo Text Mismatch");
	}

	@Test(priority = 9)
	public void validateCountryTest() {
		String acutalResult = dashboardPage.validateCountry();
		Assert.assertEquals(acutalResult, "USA", "Country Mismatch");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}