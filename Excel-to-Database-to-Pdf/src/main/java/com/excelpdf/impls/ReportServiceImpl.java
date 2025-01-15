package com.excelpdf.impls;

import com.excelpdf.entities.Machines;
import com.excelpdf.repositories.MachineRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl {
    @Autowired
    private MachineRepo machineRepo;

    public byte[] exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Machines> machinesList = machineRepo.findAll();

        // load the file and compile it
        File file = ResourceUtils.getFile("classpath:machines.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        //Set report data
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(machinesList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Digvijay");

        //Fill report
        JasperPrint jasperPrint;
        byte[] reportContent = null;

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            switch (reportFormat) {
                case "pdf" -> reportContent = JasperExportManager.exportReportToPdf(jasperPrint);
                case "xml" -> reportContent = JasperExportManager.exportReportToXml(jasperPrint).getBytes();
//                case "html" -> JasperExportManager.exportReportToHtmlFile(jasperPrint, "src/main/resources/static/machines.html");
                default -> throw new RuntimeException("Unknown report format");
            }
        } catch (JRException e) {
            //handle exception
            e.printStackTrace();
        }
        return reportContent;
    }
}
