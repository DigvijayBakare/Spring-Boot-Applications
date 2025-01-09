package com.excelpdf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Machines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machineId;
    private String machineName;
    private String machineDesc;
    private int machinePrice;

    public Machines() {
    }

    public Machines(int machineId, String machineName, String machineDesc, int machinePrice) {
        this.machineId = machineId;
        this.machineName = machineName;
        this.machineDesc = machineDesc;
        this.machinePrice = machinePrice;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineDesc() {
        return machineDesc;
    }

    public void setMachineDesc(String machineDesc) {
        this.machineDesc = machineDesc;
    }

    public int getMachinePrice() {
        return machinePrice;
    }

    public void setMachinePrice(int machinePrice) {
        this.machinePrice = machinePrice;
    }

    @Override
    public String toString() {
        return "Machines {" +
                "machineId=" + machineId +
                ", machineName='" + machineName + '\'' +
                ", machineDesc='" + machineDesc + '\'' +
                ", machinePrice=" + machinePrice +
                '}';
    }
}
