package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Log Out')]")
    private WebElement logoutLink;

    public boolean hasLogoutLink() {
        LOGGER.debug("Start checking is logout link appeared or no");
        return logoutLink.isEnabled();
    }

    public void logout(){
        LOGGER.debug("Click to logout link");
        logoutLink.click();
    }
}
