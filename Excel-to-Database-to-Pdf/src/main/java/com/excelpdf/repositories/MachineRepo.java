package com.excelpdf.repositories;

import com.excelpdf.entities.Machines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepo extends JpaRepository<Machines, Integer> {
}
