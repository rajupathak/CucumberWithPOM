package com.testing.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testing.Utility.Utility;

public class TestBase {

	public static WebDriver driver;
	public static Properties p_object;

	public TestBase() {

		try {
			p_object = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\main\\java\\com\\testing\\config\\logindetails.properties");

			p_object.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initialization() {
		
		String browserName = p_object.getProperty("browserName");
		System.out.println("browserName   "+browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.get(p_object.getProperty("url"));
		System.out.println(p_object.getProperty("browserName"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMIOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
  
	}

	
}
