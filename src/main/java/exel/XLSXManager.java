package exel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLSXManager {

    public static Object[][] getXLSXData(String file) {

        Object[][] arrayExcelData = null;

        try {
            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
            XSSFRow row = myExcelSheet.getRow(0);
            int rowNum = myExcelSheet.getPhysicalNumberOfRows() - 1;
            int colNum= row.getLastCellNum();

            arrayExcelData = new Object[rowNum][colNum];
            for (int rowCount = 0; rowCount < rowNum; rowCount++) {
                for (int colCount = 0; colCount < colNum; colCount++) {
                    arrayExcelData[rowCount][colCount] = myExcelSheet.getRow(rowCount+1).getCell(colCount).toString();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayExcelData;

    }
}
