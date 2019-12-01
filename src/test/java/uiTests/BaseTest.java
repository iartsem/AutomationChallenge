package uiTests;

import browserFactory.BrowserManager;
import browserFactory.BrowserManagerFactory;
import browserFactory.BrowserName;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected BasePage basePage;
    private BrowserManager manager;

    @BeforeClass
    public void loadState() {
        manager = BrowserManagerFactory.getManager(BrowserName.CHROME);
        webDriver = manager.getDriver();
        basePage = new BasePage(webDriver).open();
    }

    @AfterClass
    public void afterClass() {
        manager.quitDriver();
    }

}
