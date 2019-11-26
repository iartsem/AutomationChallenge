package pages;

import decorator.WebDriverDecorator;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static utils.PropertiesReader.getPropertyValue;

public class LoginPage extends AbstractPage {

    private static final String URL = getPropertyValue("BASE_URL");

    public LoginPage(WebDriverDecorator webDriverDecorator) {
        super(webDriverDecorator);
    }

    @FindBy(id = "user[login]")
    private TextInput loginForSignInInput;

    @FindBy(id = "user[password]")
    private TextInput passwordForSignInInput;

    @FindBy(xpath = "//input[@class='lrow-btn']")
    private Button submitButton;

    public LoginPage open() {
        webDriverDecorator.get(URL);
        LOGGER.debug("Page " + URL + " was opened");
        return this;
    }

    public void fillCredentials(String login, String password) {
        fillLoginInput(login);
        fillPasswordInput(password);
    }

    private void fillLoginInput(String login) {
        webDriverDecorator.waitHighlightInput(loginForSignInInput, login);
    }

    private void fillPasswordInput(String password) {
        webDriverDecorator.waitHighlightClick(passwordForSignInInput);
        webDriverDecorator.waitHighlightInput(passwordForSignInInput, password);
    }

    public void clickSubmit() {
        webDriverDecorator.waitHighlightClick(submitButton);
    }

    public void clickAllActionsOnSignInForm(String login, String password) {
        open();
        fillCredentials(login, password);
        clickSubmit();
    }
}
