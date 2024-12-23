package com.api.repositories;

import com.api.entities.OldProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldProductInfoRepo extends JpaRepository<OldProductInfo, Integer> {
}
