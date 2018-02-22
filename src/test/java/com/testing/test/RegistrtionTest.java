package com.testing.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.pages.ConfirmationPage;
import com.testing.pages.RegistrationPage;
import com.testing.testbase.TestBase;

public class RegistrtionTest extends TestBase {

	RegistrationPage object;
	ConfirmationPage confirmPageObject;

	@BeforeTest
	public void startBrowser() {
		TestBase.initialization();
		object = new RegistrationPage();
		confirmPageObject = new ConfirmationPage();

	}

	@Test(priority = 1)
	public void verifyLogo() {
		System.out.println("Inside");
		boolean value = object.verifyLogo();
		Assert.assertTrue(value, "Logo is not Present");

	}

	@Test(priority = 2)
	public void verifyRegistraiton() {

		object.fillRegistrationForm("Rajesh", "Pathak", "rajupathak8888",
				"Raju@420123", "Raju@420123", "April", "10", "1990", "Male",
				"9916866128", "rajupthk@gmail.com");

	}

	@Test(priority = 3)
	public void verifyConfirmationPage() {
		confirmPageObject = object.clickOnSubmitButton();
		String actualText = confirmPageObject.verifyPageText();

		Assert.assertEquals(actualText, "Privacy and Terms");
	}

	@Test(priority = 4)
	public void verifyCancelFunctionality() {
		object = confirmPageObject.clickCancelButton();
		String atualTitle = driver.getTitle();

		Assert.assertEquals(atualTitle, "Create your Google Account");
	}

	@AfterTest
	public void tearDown() {
		// driver.close();
	}
}
