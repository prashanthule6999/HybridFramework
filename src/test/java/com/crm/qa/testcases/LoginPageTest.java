package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestAllureListener;

@Listeners(TestAllureListener.class)
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	String sheetName = "Credentials";

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	// Using config file

	@Test(priority = 3)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * // Using DataProvider Annotation
	 * 
	 * @DataProvider public Object[][] getData() { return
	 * TestUtil.getTestData(sheetName); }
	 * 
	 * @Test(priority = 3, dataProvider = "getData") public void loginTest(String
	 * username, String password) { dashboardPage = loginPage.login(username,
	 * password); }
	 */

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}