package org.github.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.github.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tokenGenerationStepDef {

    private WebDriver driver;

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


    @Given("I am logged into my GitHub account")
    public void i_am_logged_into_my_git_hub_account() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://github.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("shouvo@msn.com");
        loginPage.enterPassword("@123Test123@");
        loginPage.clickSigninButton();
        driver.navigate().to("https://github.com/GnosticIT");
        WebElement profileLink = driver.findElement(By.xpath("//summary[@aria-label='View profile and more']//span[@class='dropdown-caret']"));
        profileLink.click();
//        WebElement settingsDropdown = driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Settings']"));
//        settingsDropdown.click();
    }
    @When("I navigate to my GitHub user settings page")
    public void i_navigate_to_my_git_hub_user_settings_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://github.com/settings/profile");
        WebElement developerSettingsLink = driver.findElement(By.xpath("//span[contains(text(),'Developer settings')]"));
        developerSettingsLink.click();

    }
    @When("I open developer settings from the left navigation menu")
    public void i_open_developer_settings_from_the_left_navigation_menu() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I open Personal access tokens from the left menu")
    public void i_open_personal_access_tokens_from_the_left_menu() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://github.com/settings/apps");
        WebElement personalAccessTokensLink = driver.findElement(By.xpath("(//span[normalize-space()='Personal access tokens'])[1]"));
        personalAccessTokensLink.click();
    }
    @When("I click on token classic")
    public void I_click_on_token_classic() {
        WebElement tokensClassicLink = driver.findElement(By.xpath("(//span[normalize-space()='Personal access tokens'])[1]"));
        tokensClassicLink.click();
    }
    @When("I click Generate new token")
    public void i_click_generate_new_token() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://github.com/settings/tokens");
        WebElement generateNewTokenButton = driver.findElement(By.xpath("//span[normalize-space()='Generate new token']"));
        generateNewTokenButton.click();
        WebElement generateNewTokenButtonClassic = driver.findElement(By.xpath("//a[2]//div[1]//div[1]"));
        generateNewTokenButtonClassic.click();


    }
    @When("I fill in the token details for the qa Automation Token")
    public void i_fill_in_the_token_details_for_the_qa_automation_token() {
        driver.navigate().to("https://github.com/settings/tokens/new");
        WebElement tokenNoteField = driver.findElement(By.xpath("//input[@id='oauth_access_description']"));
        tokenNoteField.sendKeys("QA automations");
        Select selectExpiration = new Select(driver.findElement(By.xpath("//select[@id='oauth_access_default_expires_at']")));
        selectExpiration.selectByVisibleText("7 days");
        WebElement workFlowScopeCheckbox = driver.findElement(By.xpath("//input[@value='workflow']"));
        workFlowScopeCheckbox.click();
        WebElement userScopeCheckbox = driver.findElement(By.xpath("//input[@value='user']"));
        userScopeCheckbox.click();
        WebElement generateTokenButton = driver.findElement(By.xpath("//button[normalize-space()='Generate token']"));
        generateTokenButton.click();

    }

    @When("I fill in the token details for the custom automation token")
    public void i_fill_in_the_token_details_for_the_custom_automation_token() {
        driver.navigate().to("https://github.com/settings/tokens/new");
        WebElement tokenNoteField = driver.findElement(By.xpath("//input[@id='oauth_access_description']"));
        tokenNoteField.sendKeys("Custom automations");
        Select selectExpiration = new Select(driver.findElement(By.xpath("//select[@id='oauth_access_default_expires_at']")));
        selectExpiration.selectByValue("custom");
        WebElement customExpirationDate = driver.findElement(By.xpath("//input[@id='oauth_access_custom_expires_at']"));
        customExpirationDate.sendKeys("01222024");
        WebElement publicRepoScopeCheckbox = driver.findElement(By.xpath("//input[@value='public_repo']"));
        publicRepoScopeCheckbox.click();
        WebElement readUserScopeCheckbox = driver.findElement(By.xpath("//input[@value='read:user']"));
        readUserScopeCheckbox.click();
        WebElement expirationField = driver.findElement(By.xpath("//input[@id='oauth_access_custom_expires_at']"));
        expirationField.sendKeys("01/22/2024");
        WebElement generateTokenButton = driver.findElement(By.xpath("//button[normalize-space()='Generate token']"));
        generateTokenButton.click();
    }
    @When("I click Generate token")
    public void i_click_generate_token() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @Then("I should see a new token generated for the qa automation token")
    public void i_should_see_a_new_token_generated_for_the_qa_automation_token() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='QA automations']")));
        String actualSuccessMessage = successMessage.getText();
        String expectedSuccessMessage = "QA automations";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
        driver.quit();
    }

    @Then("I should see a new token generated for the custom automation token")
    public void i_should_see_a_new_token_generated_for_the_custom_automation_token() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Custom automations']")));
        String actualSuccessMessage = successMessage.getText();
        String expectedSuccessMessage = "Custom automations";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
        driver.quit();
    }

}
