package org.github.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.github.pages.LoginPage;


public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the GitHub Login Page")
    public void i_am_on_the_git_hub_homepage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("mobashwer.a.chowdhury@gmail.com");
        loginPage.enterPassword("Chowdhury7!");
    }
    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }
    @When("I click on the sign-in button")
    public void i_click_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickSigninButton();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(loginPage.checkLogin(), true);
    }
    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals( driver.findElement(By.xpath("//div[@class='js-flash-alert' and contains(string(), \"Incorrect username or password.\")]")).isDisplayed(), true);
    }

}
