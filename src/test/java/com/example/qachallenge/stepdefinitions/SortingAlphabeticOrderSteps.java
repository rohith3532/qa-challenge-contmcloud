package com.example.qachallenge.stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;

import com.example.qachallenge.pages.SortingAlphabeticorder;
import com.example.qachallenge.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingAlphabeticOrderSteps {

	private SortingAlphabeticorder SortOrder = new SortingAlphabeticorder(DriverFactory.getDriver());
	
	@Given("user is on Data tables page")
	public void user_is_on_data_tables_page() {
		
		DriverFactory.getDriver().get("https://the-internet.herokuapp.com/tables");
	}

	@When("user click on sort lastname for Data table {string}")
	public void user_click_on_sort_lastname_for_data_table(String TableName) throws InterruptedException {
	    
		SortOrder.click_LName(TableName);
	}

	@Then("verify the names are sorted in A-Z order for {string}")
	public void verify_the_names_are_sorted_in_a_z_order_for(String TableName) throws ClientProtocolException, IOException {
	    
		//assertTrue(SortOrder.Verify_Sort(TableName,"A-Z"),"Sort order is working");
		Assert.assertTrue(SortOrder.Verify_Sort(TableName,"A-Z"));
		//assertTrue(condition, message);
		//SortOrder.Verify_Sort(TableName,"A-Z");
	}

	@Then("verify the names are sorted in Z-A order for {string}")
	public void verify_the_names_are_sorted_in_z_a_order_for(String TableName) throws ClientProtocolException, IOException {
	   
		Assert.assertTrue(SortOrder.Verify_Sort(TableName,"Z-A"));
	}
}
