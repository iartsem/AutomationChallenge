package pages;

import decorator.WebDriverDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class AbstractPage {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractPage.class.getName());

    protected WebDriverDecorator webDriverDecorator;

    public AbstractPage(WebDriverDecorator webDriverDecorator) {
        this.webDriverDecorator = webDriverDecorator;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriverDecorator)), this);
    }

    public boolean isExpectedPage(String url) {
        LOGGER.debug("Start comparing current page with " + url);
        return webDriverDecorator.getCurrentUrl().equals(url);
    }

    public void refresh() {
        LOGGER.debug("Page " + webDriverDecorator.getCurrentUrl() + " was refreshed");
        webDriverDecorator.navigate().refresh();
    }
}
