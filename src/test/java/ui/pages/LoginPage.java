package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class LoginPage extends CommenPage{

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Invalid')]")
    public WebElement invalidButton;

    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    public WebElement cookiesButton;

    // Hallo
}
