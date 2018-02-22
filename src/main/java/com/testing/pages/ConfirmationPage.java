package com.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.testbase.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Privacy and Terms')]")
	WebElement pageText;

	@FindBy(xpath = "//*[contains(@id,'cancelbutton') or contains(@value,'Cancel')]")
	WebElement cancelButton;

	
	public ConfirmationPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyPageText() {
		return pageText.getText();
	}

	public RegistrationPage clickCancelButton(){
		cancelButton.click();
		return new RegistrationPage();
	}
	
}
