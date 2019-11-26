package uiTests;

import exel.ExelManager;
import org.testng.annotations.Test;
import xmlModel.User;

import java.util.List;

import static utils.PropertiesReader.getPropertyValue;

public class UITests extends BaseTest{

    private static final String FILE_PATH = getPropertyValue("XLSX_FILE_PATH");

    @Test
    public void loginTest() {

        List<User> users = ExelManager.getUsersFromExel(FILE_PATH);

    }
}
