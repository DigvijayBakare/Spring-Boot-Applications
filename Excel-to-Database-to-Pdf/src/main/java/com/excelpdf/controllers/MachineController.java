package com.excelpdf.controllers;

import com.excelpdf.entities.Machines;
import com.excelpdf.helper.MachineExcelHelper;
import com.excelpdf.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class MachineController {
    @Autowired
    private MachineService machineService;

    @PostMapping("/machines/upload")
    public ResponseEntity<?> uploadMachine(@RequestParam("mFile") MultipartFile file) throws InterruptedException {
        Thread.sleep(2000);
        if (MachineExcelHelper.checkExcelFormat(file)) {
            this.machineService.saveMachine(file);
            return ResponseEntity.ok(Map.of("message", "File uploaded successfully!! Data is saved in DB!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only!");
    }

    @GetMapping("/machines")
    public List<Machines> getAllMachines() {
        return this.machineService.getAllMachines();
    }

    @PutMapping("/update/{mId}")
    public ResponseEntity<?> updateMachine(@PathVariable("mId") int mId, @RequestBody Machines m) {
        this.machineService.updateMachine(mId, m);
        return ResponseEntity.status(HttpStatus.OK).body("Machine updated successfully!!");
    }

    @DeleteMapping("/delete/{mId}")
    public ResponseEntity<?> deleteMachine(@PathVariable("mId") int mId) {
        this.machineService.deleteMachine(mId);
        return ResponseEntity.status(HttpStatus.OK).body("Machine deleted successfully!!");
    }
}
