package com.versionupdation.service;

import com.versionupdation.entities.Machine;

import java.util.List;

public interface MachineService {
    public void saveMachine(Machine machine);
    public void updateMachine(int mId, Machine machine);
    public List<Machine> getAllMachines();
    public void deleteMachine(int mId);
}
