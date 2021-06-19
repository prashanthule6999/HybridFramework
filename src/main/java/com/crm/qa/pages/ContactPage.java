package com.crm.qa.pages;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//*[@title='Contacts']")
	WebElement contactTab;

	@FindBy(xpath = "//*[@title='New Contact']")
	WebElement newContactOptn;

	@FindBy(xpath = "//select[@name='title' and @class='select' ]")
	WebElement title;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(css = "[name = 'client_lookup']")
	WebElement company;

	@FindBy(xpath = "//*[@value='Load From Company']/following-sibling::input[1]")
	WebElement saveBtn;

	// Initializing the Page Objects:
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void navigateToNewContactSection() {
		TestUtil.mouseOver(contactTab);
		newContactOptn.click();
	}

	public void fillNewContact(String ttl, String fn, String ln, String comp, String call) throws Exception {
		TestUtil.selectByValue(title, ttl);
		TestUtil.sendkeys(firstName, fn);
		TestUtil.sendkeys(lastName, ln);
		TestUtil.sendkeys(company, comp);
		TestUtil.click(driver.findElement(By.xpath("//*[@value = '" + call + "'  and @name='allows_call']")));
		TestUtil.click(saveBtn);
	}
}