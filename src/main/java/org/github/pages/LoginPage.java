package org.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By userNameLocator = By.id("login_field");
    private By passwordInputLocator = By.id("password");
    private By signinButtonLocator = By.xpath("//input[@value='Sign in']");
    private By marketplaceLinkLocator = By.linkText("Marketplace");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(userNameLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickSigninButton() {
        WebElement signinButton = driver.findElement(signinButtonLocator);
        signinButton.click();
    }
    public boolean checkLogin(){
        return driver.findElement(marketplaceLinkLocator).isDisplayed();
    }
}
