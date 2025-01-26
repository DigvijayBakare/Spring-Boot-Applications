package com.task.Author_Titile_Project.writeToExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
public class WriteDataToExcel {
    public static void main(String[] args) throws IOException {
        exportToExcel();
    }

    //    public ByteArrayOutputStream exportToExcel() throws IOException {
    public static void exportToExcel() throws IOException {
        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

        studentData.put("1", new Object[]{"Roll No", "NAME", "Year"});
        studentData.put("2", new Object[]{"128", "Aditya", "2nd year"});
        studentData.put("3", new Object[]{"129", "Narayana", "2nd year"});
        studentData.put("4", new Object[]{"130", "Mohan", "2nd year"});
        studentData.put("5", new Object[]{"131", "Radha", "2nd year"});
        studentData.put("6", new Object[]{"132", "Gopal", "2nd year"});

        Set<String> keyid = studentData.keySet();
        System.out.println(keyid);

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        // .xlsx is the format for Excel Sheets... writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(new File("src/main/resources/static/savedSheet.xlsx"));

        workbook.write(out);
        out.close();


//        return new ByteArrayOutputStream();
    }
}
