package com.excelpdf.impls;

import com.excelpdf.entities.Product;
import com.excelpdf.repositories.ProductRepo;
import com.excelpdf.service.PdfService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ProductPdfServiceImpl implements PdfService {
    private Logger logger = LoggerFactory.getLogger(Product.class);

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ByteArrayInputStream exportPdf() {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.setMargins(70f,70f,75f,75f);
        HeaderFooter footer = new HeaderFooter(true, new Phrase(" DDB"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(20);

        Paragraph title = new Paragraph("List of all Products", font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // creating pdf
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {1.3f,3.5f,4.5f,1.3f});

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Product Id", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Product Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Product Desc", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Product Price", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        List<Product> list = productRepo.findAll();
        for (Product product: list){
            table.addCell(String.valueOf(product.getProductId()));
            table.addCell(String.valueOf(product.getProductName()));
            table.addCell(String.valueOf(product.getProductDesc()));
            table.addCell(String.valueOf(product.getProductPrice()));
        }
    }
}
