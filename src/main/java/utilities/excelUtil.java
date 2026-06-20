package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;

public class excelUtil {

    public static Map<String,String> getTestData(
            String filePath,
            String sheetName,
            String tcid){

        Map<String,String> data = new HashMap<>();

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            Workbook workbook =
                    new XSSFWorkbook(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            Row headerRow =
                    sheet.getRow(0);

            for(int i=1;i<=sheet.getLastRowNum();i++){

                Row row = sheet.getRow(i);

                if(row.getCell(0)
                        .getStringCellValue()
                        .equalsIgnoreCase(tcid)){
                    System.out.println("MATCH FOUND");

                    for(int j=0;
                        j<headerRow.getLastCellNum();
                        j++){

                        data.put(
                                headerRow.getCell(j)
                                        .getStringCellValue(),

                                row.getCell(j)
                                        .toString()
                        );
                    }

                    break;
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}