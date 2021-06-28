package com.example.qachallenge.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser
	 * @param browser
	 * @return with tlDriver
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is: "+browser);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * This is used to get driver with local thread
	 * @return
	 */
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	
	
	
	
	
}
