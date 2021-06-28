package com.example.qachallenge.pages;

import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImagesPage {

	private WebDriver driver;
	int iBrokenImageCount = 0;
	public static String status = "passed";

	//1. By locators
	private By images = By.tagName("img");


	//2. Constructor of the page class
	public BrokenImagesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//3. Page actions
	public void VerifyBrokenImagesCount() throws ClientProtocolException, IOException
	{
		List<WebElement> image_list = driver.findElements(images);
		int ImagesCount = image_list.size();

		for (WebElement img : image_list)
		{
			if (img != null)
			{
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(img.getAttribute("src"));
				HttpResponse response = client.execute(request);
				/* For valid images, the HttpStatus will be 200 */
				if (response.getStatusLine().getStatusCode() != 200)
				{
					System.out.println(img.getAttribute("outerHTML") + " is broken.");
					iBrokenImageCount++;
				}
			}

		}
		status = "passed";
        System.out.println("The page " + "https://the-internet.herokuapp.com/broken_images" + " has " + iBrokenImageCount + " broken images");
 
	}

}
