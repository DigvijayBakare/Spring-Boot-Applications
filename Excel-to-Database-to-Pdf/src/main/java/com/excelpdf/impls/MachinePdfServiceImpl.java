package com.excelpdf.impls;

import com.excelpdf.entities.Machines;
import com.excelpdf.entities.Product;
import com.excelpdf.repositories.MachineRepo;
import com.excelpdf.repositories.ProductRepo;
import com.excelpdf.service.PdfService;
import com.lowagie.text.Font;
import com.lowagie.text.*;
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
public class MachinePdfServiceImpl implements PdfService {
    private Logger logger = LoggerFactory.getLogger(Product.class);

    @Autowired
    private MachineRepo machineRepo;

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

        Paragraph title = new Paragraph("List of all Machines", font);
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

        cell.setPhrase(new Phrase("Machine Id", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Machine Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Machine Desc", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Machine Price", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        List<Machines> list = machineRepo.findAll();
        for (Machines machines: list){
            table.addCell(String.valueOf(machines.getMachineId()));
            table.addCell(String.valueOf(machines.getMachineName()));
            table.addCell(String.valueOf(machines.getMachineDesc()));
            table.addCell(String.valueOf(machines.getMachinePrice()));
        }
    }
}
