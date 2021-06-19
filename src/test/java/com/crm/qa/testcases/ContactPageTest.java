package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	ContactPage contactPage;
	LoginPage loginPage;
	String sheetName = "NewContact";

	public ContactPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = new ContactPage();
		TestUtil.switchToFrame();
	}

	@Test(priority = 10)
	public void navigateToNewContactSectionTest() {
		contactPage.navigateToNewContactSection();
	}

	@DataProvider
	public Object[][] getContactData() {
		return TestUtil.getTestData(sheetName);
	}

	@Test(priority = 11, dependsOnMethods = "navigateToNewContactSectionTest", dataProvider = "getContactData")
	public void setContactDataTest(String title, String firstName, String lastName, String company, String allowCall) throws Exception {
		contactPage.fillNewContact(title,firstName, lastName, company, allowCall);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
