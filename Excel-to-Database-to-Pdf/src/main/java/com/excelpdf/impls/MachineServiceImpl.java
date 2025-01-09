package com.excelpdf.impls;

import com.excelpdf.entities.Machines;
import com.excelpdf.helper.MachineExcelHelper;
import com.excelpdf.repositories.MachineRepo;
import com.excelpdf.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineRepo machineRepo;

    @Override
    public void saveMachine(MultipartFile file) {
        try {
            List<Machines> productList = MachineExcelHelper.convertExcelToList(file.getInputStream());
            this.machineRepo.saveAll(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Machines> getAllMachines() {
        return this.machineRepo.findAll();
    }

    @Override
    public void updateMachine(int mId, Machines machine) {
        Machines oldMachine = this.machineRepo.findById(mId).orElse(new Machines());
        Machines updatedMachine = new Machines(oldMachine.getMachineId(), machine.getMachineName(), machine.getMachineDesc(), machine.getMachinePrice());
        this.machineRepo.save(updatedMachine);
    }

    @Override
    public void deleteMachine(int mId) {
        Machines machines = this.machineRepo.findById(mId).get();
        this.machineRepo.delete(machines);
    }
}
