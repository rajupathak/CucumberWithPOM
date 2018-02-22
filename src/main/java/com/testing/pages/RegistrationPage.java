package com.testing.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.Utility.Utility;
import com.testing.testbase.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath = "//img[@class='logo logo-w']")
	WebElement googleLogo;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "GmailAddress")
	WebElement emailAddress;

	@FindBy(id = "Passwd")
	WebElement password;

	@FindBy(id = "PasswdAgain")
	WebElement confirmPassword;

	@FindBy(xpath = "//div[contains(@class,'form-element multi-field birthday')]//label[contains(@class,'month')]")
	WebElement months;

	@FindBy(xpath = "//div[contains(@class,'form-element multi-field birthday')]//label[contains(@class,'month')]//span[contains(@id,'BirthMonth')]//div[contains(@class,'goog-menuitem-content')]")
	static List<WebElement> monthDropDown;

	@FindBy(xpath = "//div[contains(@class,'form-element multi-field birthday')]//label[contains(@class,'month')]//following-sibling::label[1]")
	WebElement monthDay;

	@FindBy(xpath = "//div[contains(@class,'form-element multi-field birthday')]//label[contains(@class,'month')]//following-sibling::label[2]")
	WebElement monthYear;

	@FindBy(xpath = "//div[contains(@id,'gender-form-element')]//div[contains(@id,'Gender')]")
	WebElement gender;

	@FindBy(xpath = "//div[contains(@id,'gender-form-element')]//div[contains(@id,'Gender')]//div[contains(@class,'goog-menuitem-content')]")
	static List<WebElement> genderDropDown;

	@FindBy(xpath = "//td[contains(@class,'i18n_phone_number_input-input')]//input[contains(@id,'RecoveryPhoneNumber')]")
	WebElement recoveryPhoneNumber;

	@FindBy(xpath = "//label[contains(@id,'recovery-email-label')]//input[contains(@id,'RecoveryEmailAddress')]")
	WebElement recoveryEmailAddress;

	@FindBy(xpath = "//div[contains(@id,'CountryCode')]")
	WebElement country;

	@FindBy(xpath = "//div[contains(@id,'CountryCode')]//div[contains(@class,'goog-menuitem-content')]")
	static List<WebElement> countryDropDown;

	@FindBy(xpath = "//label[contains(@id,'termsofservice-label')]//input[contains(@type,'checkbox')]")
	WebElement selectCheckBox;

	@FindBy(xpath = ".//*[@id='submitbutton']")
	WebElement submitButton;

	public RegistrationPage() {

		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyLogo() {

		return googleLogo.isDisplayed();
	}

	public void fillRegistrationForm(String fName, String lName,
			String userName, String pword, String confirmPasword, String month,
			String day, String year, String gnder, String phoneNumber,
			String recoverEmail) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);

		emailAddress.sendKeys(userName);
		password.sendKeys(pword);

		confirmPassword.sendKeys(confirmPasword);

		months.click();

		Utility.getElements(month, monthDropDown);

		monthDay.sendKeys(day);
		monthYear.sendKeys(year);
		gender.click();
		Utility.getElements(gnder, genderDropDown);

		recoveryPhoneNumber.sendKeys(phoneNumber);

		recoveryEmailAddress.sendKeys(recoverEmail);
		Utility.scroolTheWidnow();
		//country.click();

		//Utility.getElements(location, countryDropDown);
		selectCheckBox.click();
	}

	public ConfirmationPage clickOnSubmitButton() {
		submitButton.click();
		return new ConfirmationPage();
	}

}
