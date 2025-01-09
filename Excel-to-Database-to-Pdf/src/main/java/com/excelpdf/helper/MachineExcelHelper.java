package com.excelpdf.helper;

import com.excelpdf.entities.Machines;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MachineExcelHelper {
    static String excelType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    // checks that file is of Excel type or not
    public static Boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType.equals(excelType)) return true;
        return false;
    }


    // converting an excel to the list of product
    public static List<Machines> convertExcelToList(InputStream is) {
        List<Machines> machineList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("machineData");
            int rowNo = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNo == 0) {
                    rowNo++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cId = 0;
                Machines machine = new Machines();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cId) {
                        /*case 0:
                            machine.setMachineId((int) cell.getNumericCellValue());
                            break;*/
                        case 1:
                            machine.setMachineName(cell.getStringCellValue());
                            break;
                        case 2:
                            machine.setMachineDesc(cell.getStringCellValue());
                            break;
                        case 3:
                            machine.setMachinePrice((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cId++;
                }
                machineList.add(machine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return machineList;
    }
}
