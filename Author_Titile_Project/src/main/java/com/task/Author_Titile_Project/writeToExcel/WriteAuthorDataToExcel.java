package com.task.Author_Titile_Project.writeToExcel;

import com.task.Author_Titile_Project.entities.Author;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class WriteAuthorDataToExcel {
    public static void main(String[] args) throws NoSuchFieldException, IOException {
        exportAuthorData();
    }

    public static void exportAuthorData() throws NoSuchFieldException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(" Author Data ");

        XSSFRow row;

        Field[] declaredFields = Author.class.getDeclaredFields();

        Map<String, Object[]> map = new LinkedHashMap<>();
        map.put("Fields", new Object[]{"Fields", "Data Type"});

        for (int i = 0; i < declaredFields.length; i++) {
            String variableName = declaredFields[i].getName();
            String dataType = declaredFields[i].getType().getSimpleName();

            map.put(String.valueOf(i), new Object[]{variableName, dataType});
        }

        System.out.println(map);

        Set<String> strings = map.keySet();

        int rowId = 0;
        for (String key : strings) {
            row = sheet.createRow(rowId++);
            Object[] objects = map.get(key);
            int cellid = 0;
            for (Object obj : objects) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        FileOutputStream out = new FileOutputStream(new File("src/main/resources/static/saved1Sheet.xlsx"));
        workbook.write(out);
        out.close();
    }
}
