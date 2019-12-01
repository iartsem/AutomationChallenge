package validators;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageValidator {

    public static boolean sortingValidator(List<WebElement> elements) {
        double basePrice = 0;
        for (WebElement element : elements) {
            double productPrice = Double.parseDouble(element.getText().substring(1).replaceAll(",", ""));
            if (productPrice >= basePrice) {
                basePrice = productPrice;
            } else {
                throw new IllegalArgumentException("Price is lover than previous: " + productPrice + " previous price "+ basePrice);
            }
        }
        return true;
    }
}
