package com.testing.Utility;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.testing.testbase.TestBase;

public class Utility extends TestBase{
public static long PAGE_LOAD_TIMIOUT =20;
public static long IMPLICIT_WAIT =30;
public static JavascriptExecutor js = (JavascriptExecutor) driver;
public static void getElements(String textToBeSelected,
		List<WebElement> element) {
	String dropdwontext = null;
	List<WebElement> list = element;

	for (int i = 0; i < list.size(); i++) {
		dropdwontext = list.get(i).getText();
		
		if (dropdwontext.equalsIgnoreCase(textToBeSelected)) {
			
			dropdwontext = list.get(i).getText();
			list.get(i).click();
			System.out.println("Selected Value is :: " + dropdwontext);
			/*if(i==25){
				Utility.scroolTheWidnow();
			}*/
			break;
		}
	}

}
public static void scroolTheWidnow() {
	js.executeScript("scroll(0,1200)");
}

}
