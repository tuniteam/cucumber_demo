package com.expertsdutest.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.expertsdutest.demo.model.Credentials;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	LoginService loginService;
	String actualAnswer;
	Credentials credentials = new Credentials();

	@Given("I've chosen to login")
	public void ive_chosen_to_login() {
		loginService = new LoginService();
	}

	@When("I use any password")
	public void i_use_any_password() {
		credentials.setPassword("Very Wrong password");
	}

	@When("I try to login using an email of an inexistent user")
	public void i_try_to_login_using_an_email_of_an_inexistent_user() {
		credentials.setEmail("inexsistent@host.com");
		actualAnswer = loginService.login(credentials.getEmail(), credentials.getPassword());
	}

	@Then("I should get a text saying \"Email doesn't exist\"")
	public void i_should_a_text_saying_email_doesnt_exist() {
		assertEquals("Email doesn't exist", actualAnswer);
	}

	@When("I enter a valid email and an incorrect password")
	public void i_enter_a_valid_email_and_an_incorrect_password() {
		credentials.setEmail("oussema.chaari@expertsdutest.com");
		credentials.setPassword("an incorrect password");
		actualAnswer = loginService.login(credentials.getEmail(), credentials.getPassword());
	}

	@Then("I should get a text saying \"Incorrect password used\"")
	public void i_should_get_a_text_saying_incorrect_password_used() {
		assertEquals("Incorrect password used", actualAnswer);
	}

	@When("I enter the correct email and password")
	public void i_enter_the_correct_email_and_password() {
		credentials.setEmail("fares.mallouli@expertsdutest.com");
		credentials.setPassword("qwerty");
		actualAnswer = loginService.login(credentials.getEmail(), credentials.getPassword());
	}

	@Then("I should get a text saying \"Welcome <user>!\" with <user> being the account owner's first name")
	public void i_should_get_a_text_saying_welcome_user() {
		assertEquals("Welcome Fares !", actualAnswer);
	}

}
