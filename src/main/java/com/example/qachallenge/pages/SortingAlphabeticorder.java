package com.example.qachallenge.pages;

import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortingAlphabeticorder {

	private WebDriver driver;


	//1. By locators
	private By T1_Lname = By.xpath("//table[@id='table1']//span[contains(text(),'Last Name')]");
	private By T2_Lname = By.xpath("//span[@class='last-name']");

	private By T1_LnameList = By.xpath("//table[@id='table1']/tbody/tr/td[1]");
	private By T2_LnameList = By.xpath("//table[@id='table2']/tbody/tr/td[1]");


	//2. Constructor of the page class
	public SortingAlphabeticorder(WebDriver driver)
	{
		this.driver=driver;
	}

	//3. Page actions
	public void click_LName(String TableName) throws InterruptedException
	{
		if(TableName.equalsIgnoreCase("Table1"))
		{
			Thread.sleep(3000);
			driver.findElement(T1_Lname).click();
		}
		else if(TableName.equalsIgnoreCase("Table2"))
		{
			Thread.sleep(3000);
			driver.findElement(T2_Lname).click();
		}

	}

	public Boolean Verify_Sort(String TableName,String SortOrder) throws ClientProtocolException, IOException
	{
		List<WebElement> tdList = null;
		if(TableName.equalsIgnoreCase("Table1"))
		{
			tdList = driver.findElements(T1_LnameList);

		}
		else if(TableName.equalsIgnoreCase("Table2"))
		{
			tdList = driver.findElements(T2_LnameList);

		}


		String strArry [] = new String[tdList.size()];
		for(int i=0;i < tdList.size();i++)
		{
			strArry[i]=tdList.get(i).getText();
		}
		System.out.println("Length 0000000 : "+strArry.length);
		/*
		 * Compare the String
		 */
		boolean sortFunctionality = true;

		for(int i=0;i < strArry.length;i++)
		{
			for(int j=i+1;j < strArry.length;j++)
			{
				int result = strArry[j].compareTo(strArry[i]);
				if(SortOrder.equalsIgnoreCase("A-Z"))
				{
					if(!(result > 0))
					{
						System.out.println("Data in the Table is not SORTED::" +strArry[j]+":::"+ strArry[i]);
						sortFunctionality=false;
						break;
					}
					else
					{
						System.out.println("Data in the Table is SORTED::" +strArry[j]+":::"+ strArry[i]);
					}
				}
				else if(SortOrder.equalsIgnoreCase("Z-A"))
				{
					if(!(result < 0))
					{
						System.out.println("Data in the Table is not SORTED::" +strArry[j]+":::"+ strArry[i]);
						sortFunctionality=false;
						break;
					}
					else
					{
						System.out.println("Data in the Table is SORTED::" +strArry[j]+":::"+ strArry[i]);
					}
				}
				
			}
		}


		if(sortFunctionality)
		{
			System.out.println("SORT Functionality is working for "+TableName);
		}
		else
		{
			System.out.println("SORT Functionality is not working for "+TableName);
		}
		return sortFunctionality;
	}

}
