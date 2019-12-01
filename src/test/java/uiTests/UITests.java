package uiTests;

import pages.ProductPage;
import xlsx.XLSXManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import static utils.PropertiesReader.getPropertyValue;

public class UITests extends BaseTest{

    private static final String FILE_PATH = getPropertyValue("XLSX_FILE_PATH");
    private static final int PRODUCTS_AMOUNT = 10;

    @Test (dataProvider = "dataForLogin")
    public void loginTest(String login, String password) {

        LoginPage loginPage = basePage.navigateToLoginPage();
        AccountPage accountPage = loginPage.login(login, password);
        Assert.assertTrue(accountPage.hasLogoutLink());
        accountPage.logout();
        accountPage.navigateToLoginPage();
    }

    @Test
    public void sortProductTest() {
        Assert.assertEquals(basePage.getProducts().size(), PRODUCTS_AMOUNT);
        ProductPage productPage = basePage.navigateToRandomProducatPage();
        System.out.println("Hello");
    }

    @DataProvider(name = "dataForLogin")
    public Object[][] dataProvider() {
        return XLSXManager.getXLSXData(FILE_PATH);
    }

}
