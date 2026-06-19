package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class excelUtil {

    public static String getData(String filePath, String sheetName, String testCaseID, String columnName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);

            int columnIndex = -1;

            for(int i=0;i<headerRow.getLastCellNum();i++){

                if(headerRow.getCell(i).getStringCellValue()
                        .equalsIgnoreCase(columnName)){

                    columnIndex=i;
                    break;
                }
            }

            for(int i=1;i<=sheet.getLastRowNum();i++){

                Row row = sheet.getRow(i);

                if(row.getCell(0).getStringCellValue()
                        .equalsIgnoreCase(testCaseID)){

                    String value =
                            row.getCell(columnIndex).toString();

                    workbook.close();
                    fis.close();

                    return value;
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}