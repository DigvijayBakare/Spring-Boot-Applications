package com.versionupdation.controller;

import com.versionupdation.entities.Machine;
import com.versionupdation.helper.LoggerWrapper;
import com.versionupdation.service.impl.MachineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(MachineController.class);

    @Autowired
    private MachineServiceImpl machineService;

    @PostMapping("/create/machine")
    public ResponseEntity<?> createMachine(@RequestBody Machine machine) {
        logger.info("this is logger implementation!!");
        machineService.saveMachine(machine);
        return ResponseEntity.ok("Machine saved successfully!!");
    }

    @PutMapping("/update/machine/{mId}")
    public ResponseEntity<?> updateMachine(@PathVariable("mId") int mId, @RequestBody Machine machine) {
        machineService.updateMachine(mId, machine);
        return ResponseEntity.ok("Machine updated successfully!!");
    }

    @DeleteMapping("/delete/machine/{mId}")
    public ResponseEntity<?> deleteMachine(@PathVariable int mId) {
        machineService.deleteMachine(mId);
        return ResponseEntity.ok("Machine deleted successfully!!");
    }

    @GetMapping("/getall/machines")
    public List<Machine> getAllMachines() {
        List<Machine> allMachines = machineService.getAllMachines();
        logger.info("Returned all person data successfully!!");
        return allMachines;
    }
}
