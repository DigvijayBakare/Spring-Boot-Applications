package com.excelpdf.service;

import com.excelpdf.entities.Machines;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MachineService {
    public void saveMachine(MultipartFile file);
    public List<Machines> getAllMachines();
    public void updateMachine(int mId, Machines machine);
    public void deleteMachine(int mId);
}
