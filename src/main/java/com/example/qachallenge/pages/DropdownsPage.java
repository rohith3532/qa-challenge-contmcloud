package com.example.qachallenge.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownsPage {

	private WebDriver driver;


	//1. By locators
	private By Dropdown = By.id("dropdown");
	private By Dropdown1 = By.xpath("//select[@id='dropdown']");

	//2. Constructor of the page class
	public DropdownsPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//3. Page actions
	public void SelectDropdown(String DropdownValue) throws InterruptedException
	{
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(Dropdown));
		drpCountry.selectByVisibleText(DropdownValue);
		Thread.sleep(1000);
	}

	public String VerifyDropdownValue()
	{
		String ActualText = null;
		Select select = new Select(driver.findElement(Dropdown));
		WebElement option1 = select.getFirstSelectedOption();
		String SelectedItem = option1.getText();	
		System.out.println(SelectedItem );
		ActualText = SelectedItem;
		return ActualText;
	}
}
