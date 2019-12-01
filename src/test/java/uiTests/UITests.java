package uiTests;

import exel.XLSXManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import static utils.PropertiesReader.getPropertyValue;

public class UITests extends BaseTest{

    private static final String FILE_PATH = getPropertyValue("XLSX_FILE_PATH");

    @Test (dataProvider = "dataForLogin")
    public void loginTest(String login, String password) {

        LoginPage loginPage = basePage.navigateToLoginPage();
        AccountPage accountPage = loginPage.login(login, password);
        Assert.assertTrue(accountPage.hasRegistrationLink());
        accountPage.logout();
        accountPage.navigateToLoginPage();
    }

    @DataProvider(name = "dataForLogin")
    public Object[][] dataProvider() {
        return XLSXManager.getXLSXData(FILE_PATH);
    }

}
