package uiTests;

import browserFactory.BrowserManager;
import browserFactory.BrowserManagerFactory;
import browserFactory.BrowserName;
import decorator.WebDriverDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import static utils.PropertiesReader.getPropertyValue;

public abstract class BaseTest {

    private static final String TEST_USER_LOGIN;
    private static final String TEST_USER_PASSWORD;

    static {
        TEST_USER_LOGIN = getPropertyValue("LOGIN");
        TEST_USER_PASSWORD = getPropertyValue("PASSWORD");
    }

    protected WebDriverDecorator webDriverDecorator;
    protected LoginPage loginPage;
    private BrowserManager manager;

    protected static String getTestUserLogin() {
        return TEST_USER_LOGIN;
    }

    protected static String getTestUserPassword() {
        return TEST_USER_PASSWORD;
    }

    @BeforeClass
    public void loadState() {
        manager = BrowserManagerFactory.getManager(BrowserName.CHROME);
        webDriverDecorator = new WebDriverDecorator(manager.getDriver());
        loginPage = new LoginPage(webDriverDecorator);
        loginPage.open();
        System.out.println("");

    }

    @AfterClass
    public void afterClass() {
        manager.quitDriver();
    }

}
