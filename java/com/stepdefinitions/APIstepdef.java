package com.stepdefinitions;

import com.pages.APIactions;

import cucumber.api.java.en.Given;

public class APIstepdef {
	APIactions apIactions = new APIactions();
	@Given("^Launch API$")
	public void apisteps() {
		apIactions.postURL();
	}

}
