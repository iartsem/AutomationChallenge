package pages;

import org.openqa.selenium.WebDriver;

import static utils.PropertiesReader.getPropertyValue;

public class BasePage extends AbstractPage {

    private static final String URL = getPropertyValue("BASE_URL");
    private static final String LOGIN = getPropertyValue("LOGIN");
    private static final String PASSWORD = getPropertyValue("PASSWORD");
    private static final String LOGIN_PAGE = "https://stage.stadiumgoods.cloud/customer/account/login/";

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public BasePage open() {
        webDriver.get("https://" + LOGIN + ":" + PASSWORD + URL);
        LOGGER.debug("Page " + URL + " was opened");
        return this;
    }

    public LoginPage navigateToLoginPage() {
        webDriver.get(LOGIN_PAGE);
        LOGGER.debug("Page " + LOGIN_PAGE + " was opened");
        return new LoginPage(webDriver);
    }
}
