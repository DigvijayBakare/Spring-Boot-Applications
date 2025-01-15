package com.versionupdation.repository;


import com.versionupdation.entities.Machine;
import com.versionupdation.helper.LoggerWrapper;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MachineRepository {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(MachineRepository.class);
    static Map<Integer, Machine> machineMap = new HashMap<>();

    public Machine save(Machine machine) {
        int machineId = machine.getId();
        logger.info("machine saved into the DB successfully!");
        return machineMap.put(machineId, machine);
    }

    public Machine update(int mId, Machine machine) {
        Machine available = machineMap.get(mId);
        if (machineMap.containsValue(available)) {
            logger.info("Machine with id: " + mId + " saved successfully");
            return machineMap.put(mId, machine);
        }
        logger.error("Something went wrong!!");
        return new Machine();
    }

    public List<Machine> getAllMachines() {
        logger.info("List of all machines returned successfully!");
        return new ArrayList<>(machineMap.values());
    }

    public Machine delete(int mId) {
        Machine remove = machineMap.remove(mId);
        logger.info("Machine with id: " + mId + " deleted successfully!");
        return remove;
    }
}
