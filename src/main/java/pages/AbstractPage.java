package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractPage.class.getName());

    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isExpectedPage(String url) {
        LOGGER.debug("Start comparing current page with " + url);
        return webDriver.getCurrentUrl().equals(url);
    }

    public void refresh() {
        LOGGER.debug("Page " + webDriver.getCurrentUrl() + " was refreshed");
        webDriver.navigate().refresh();
    }
}
