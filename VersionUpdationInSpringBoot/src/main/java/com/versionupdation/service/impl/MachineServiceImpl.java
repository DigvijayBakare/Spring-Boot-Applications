package com.versionupdation.service.impl;

import com.versionupdation.entities.Machine;
import com.versionupdation.helper.LoggerWrapper;
import com.versionupdation.repository.MachineRepository;
import com.versionupdation.service.MachineService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(MachineServiceImpl.class);

    @Autowired
    private MachineRepository machineRepository;

    @Override
    public void saveMachine(Machine machine) {
        machineRepository.save(machine);
        logger.info("Machine saved successfully!");
    }

    @Override
    public void updateMachine(int mId, Machine machine) {
        machineRepository.update(mId,machine);
    }

    @Override
    public List<Machine> getAllMachines() {
        return machineRepository.getAllMachines();
    }

    @Override
    public void deleteMachine(int mId) {
        machineRepository.delete(mId);
        logger.info("Machine deleted successfully!");
    }
}
