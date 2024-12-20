package com.filejson.impl;

import com.filejson.controller.FileController;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl {
    private Logger logger = LoggerFactory.getLogger(FileController.class);

    public ByteArrayInputStream createPdf() {
        logger.info("Create pdf started: ");
        String title = "This is pdf generator";
        String content = "Genertaed usig something";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        HeaderFooter footer = new HeaderFooter(true, new Phrase(" DDB"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);

        document.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Paragraph titlePara = new Paragraph(title, titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);

        document.add(titlePara);

        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 14);
        Paragraph contentPara = new Paragraph(content, paraFont);
        contentPara.setAlignment(Element.ALIGN_JUSTIFIED);

        document.add(contentPara);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
