package com.example.qachallenge.stepdefinitions;

import org.junit.Assert;

import com.example.qachallenge.pages.DropdownsPage;
import com.example.qachallenge.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropdownSteps {

	DropdownsPage ddpage = new DropdownsPage(DriverFactory.getDriver());
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
	    
		DriverFactory.getDriver().get("https://the-internet.herokuapp.com/dropdown");
	}

	@When("user select dropdown value as {string}")
	public void user_select_dropdown_value_as(String DropdownValue) throws InterruptedException {
	   
		ddpage.SelectDropdown(DropdownValue);
	}

	@Then("the selected value for dropdown is {string}")
	public void the_selected_value_for_dropdown_is(String ExpectedDDValue) {
		   
		String ActualText = ddpage.VerifyDropdownValue();
		Assert.assertEquals("Verify Dropdown Text", ExpectedDDValue, ActualText);
	}
}
