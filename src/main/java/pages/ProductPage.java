package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='sort_by_chosen']/a")
    private WebElement sortMenu;

    @FindBy(xpath = "//li[contains(text(),'Price Low to High')]")
    private WebElement selectPriceLowToHight;

    @FindBy(xpath = "//div[@class='price-box ']//span[@class='price' and not(contains(@data-flow-item-price-attribute,'strikethrough_price'))]")
    private List<WebElement> prices;

    @FindBy(xpath = "//span[@id='loading_mask_loader']/img")
    private WebElement loadingIcon;

    public ProductPage clickSortMenu() {
        waitForElementEnabled(sortMenu);
        waitForElementClickable(sortMenu);
        sortMenu.click();
        LOGGER.debug("Sort menu was selected");
        return this;
    }

    public void sortProductsByPrise() {
        waitForElementEnabled(selectPriceLowToHight);
        waitForElementClickable(selectPriceLowToHight);
        selectPriceLowToHight.click();
        waitUntilElementNotVisible(loadingIcon);
        LOGGER.debug("Products were sorted by price");
    }

    public List<WebElement> getPrices(){
        return prices;
    }
}
