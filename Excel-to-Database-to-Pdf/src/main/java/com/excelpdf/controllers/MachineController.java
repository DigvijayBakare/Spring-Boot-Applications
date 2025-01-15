package com.excelpdf.controllers;

import com.excelpdf.entities.Machines;
import com.excelpdf.helper.MachineExcelHelper;
import com.excelpdf.impls.ReportServiceImpl;
import com.excelpdf.service.MachineService;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class MachineController {
    Logger logger = LoggerFactory.getLogger(MachineController.class);

    @Autowired
    private MachineService machineService;

    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping("/add-machine")
    public ResponseEntity<?> insertMachine() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only!");
    }

    @PostMapping("/machines/upload")
    public ResponseEntity<?> uploadMachine(@RequestParam("mFile") MultipartFile file) throws InterruptedException {
        Thread.sleep(2000);
        if (MachineExcelHelper.checkExcelFormat(file)) {
            this.machineService.saveMachine(file);
            logger.info("File uploaded successfully and data is saved in DB!!");
            return ResponseEntity.ok(Map.of("message", "File uploaded successfully!! Data is saved in DB!"));
        }
        logger.error("Something went wrong!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only!");
    }

    @GetMapping("/machines")
    public List<Machines> getAllMachines() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return this.machineService.getAllMachines();
    }

    @PutMapping("/update-machine/{mId}")
    public ResponseEntity<?> updateMachine(@PathVariable("mId") int mId, @RequestBody Machines m) {
        this.machineService.updateMachine(mId, m);
        logger.info("Machine data updated successfully!");
        return ResponseEntity.status(HttpStatus.OK).body("Machine updated successfully!!");
    }

    @DeleteMapping("/delete-machine/{mId}")
    public ResponseEntity<?> deleteMachine(@PathVariable("mId") int mId) {
        this.machineService.deleteMachine(mId);
        logger.info("Machine data deleted successfully!");
        return ResponseEntity.status(HttpStatus.OK).body("Machine deleted successfully!!");
    }

    /*@GetMapping("/report/{format}")
    public String generateReport(@PathVariable("format") String reportFormat) throws JRException, FileNotFoundException {
        return reportService.exportReport(reportFormat);
    }*/

    @GetMapping("report/{format}")
    public ResponseEntity<Resource> getItemReport(@PathVariable String format)
            throws JRException, IOException {

//        byte[] reportContent = reportService.exportReport(format);
        byte[] reportContent = reportService.exportReport(format);

        ByteArrayResource resource = new ByteArrayResource(reportContent);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("machine-list." + format)
                                .build().toString())
                .body(resource);
    }
}
