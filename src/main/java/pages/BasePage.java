package pages;

import helper.RandomHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.PropertiesReader.getPropertyValue;

public class BasePage extends AbstractPage {

    private static final String URL = getPropertyValue("BASE_URL");
    private static final String LOGIN = getPropertyValue("LOGIN");
    private static final String PASSWORD = getPropertyValue("PASSWORD");
    private static final String LOGIN_PAGE = "https://stage.stadiumgoods.cloud/customer/account/login/";

    @FindBy(xpath = "//div[@id='header-nav']//ol/li")
    private List<WebElement> products;

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

    public ProductPage navigateToRandomProductPage() {
        int productAmount = products.size() -1;
        WebElement element = products.get(RandomHelper.getRandomNumber(productAmount));
        LOGGER.debug("Page " + element.getText() + " was opened");
        element.click();
        return new ProductPage(webDriver);
    }

    public List<WebElement> getProducts() {
        return products;
    }
}
