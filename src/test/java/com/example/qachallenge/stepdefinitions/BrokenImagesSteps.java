package com.example.qachallenge.stepdefinitions;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.example.qachallenge.pages.BrokenImagesPage;
import com.example.qachallenge.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BrokenImagesSteps {
	
	private BrokenImagesPage brokenImagesPage = new BrokenImagesPage(DriverFactory.getDriver());

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		
		DriverFactory.getDriver().get("https://the-internet.herokuapp.com/broken_images");
		
	}

	@Then("Verify the broken images count")
	public void verify_the_broken_images_count() throws ClientProtocolException, IOException {
	    
		brokenImagesPage.VerifyBrokenImagesCount();
	}
}
