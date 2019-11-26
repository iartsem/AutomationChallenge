package exel;

import com.google.common.collect.Iterables;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import xmlModel.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExelManager {

    public static List<User> getUsersFromExel(String file) {

        List<User> users = new ArrayList<User>();

        try {
            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
            for (Row row : Iterables.skip(myExcelSheet,1)) {
                users.add(assignUser(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static User assignUser(Row row){
        User user = new User();
        user.setUserName(row.getCell(0).toString());
        user.setPaswword(row.getCell(1).toString());
        return user;
    }
}
