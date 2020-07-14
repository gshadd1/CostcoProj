/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author gregshadd
 */
public class StepDefinitions {
     ChromeDriver driver;
     @Given("^user is already on Costco Customer Service Page$")
public void user_is_already_on_Costco_Customer_Service_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^title of page Customer Service$")
public void title_of_page_Customer_Service() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^user clicks on one of the service buttons$")
public void user_clicks_on_one_of_the_service_buttons(DataTable arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    throw new PendingException();
}

@Then("^page for associated button will appear$")
public void page_for_associated_button_will_appear() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^verify the corect page$")
public void verify_the_corect_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

//@Then("^user close the browser$")
//public void user_close_the_browser() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}

@Then("^users close the browser$")
public void users_close_the_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


@Given("^Navigate to Costco Home Page$")
public void navigate_to_Costco_Home_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^title of Home Page is Costco$")
public void title_of_Home_Page_is_Costco() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^I enter the following Login$")
public void i_enter_the_following_Login(DataTable arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    throw new PendingException();
}

@Then("^I click on login button$")
public void i_click_on_login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^I should see the userform page$")
public void i_should_see_the_userform_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^I should see invalid username or password$")
public void i_should_see_invalid_username_or_password() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
}
