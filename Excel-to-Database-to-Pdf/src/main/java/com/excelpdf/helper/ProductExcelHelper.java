package com.excelpdf.helper;

import com.excelpdf.entities.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductExcelHelper {
    static String excelType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    // checks that file is of Excel type or not
    public static Boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType.equals(excelType)) return true;
        return false;
    }

    // converting an Excel to the list of product
    public static List<Product> convertExcelToList(InputStream is) {
        List<Product> productList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("productData");
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
                Product product = new Product();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cId) {
                        case 0:
//                            product.setProductId((int) cell.getNumericCellValue());
                            product.setProductName(cell.getStringCellValue());
                            break;
                        case 1:
//                            product.setProductName(cell.getStringCellValue());
                            product.setProductDesc(cell.getStringCellValue());
                            break;
                        case 2:
//                            product.setProductDesc(cell.getStringCellValue());
                            product.setProductPrice((int) cell.getNumericCellValue());
                            break;
                        case 3:
//                            product.setProductPrice((int) cell.getNumericCellValue());
                            product.setQuantity((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cId++;
                }
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
