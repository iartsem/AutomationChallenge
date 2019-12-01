package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElement loginForSignInInput;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passwordForSignInInput;

    @FindBy(xpath ="//button[@name='send']")
    private WebElement loginButton;

    private void fillLoginInput(String login) {
        loginForSignInInput.sendKeys(login);
    }

    private void fillPasswordInput(String password) {
        passwordForSignInInput.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void fillCredentials(String login, String password) {
        fillLoginInput(login);
        fillPasswordInput(password);
    }

    public AccountPage login(String login, String password) {
        fillCredentials(login, password);
        clickLoginButton();
        return new AccountPage(webDriver);
    }
}
