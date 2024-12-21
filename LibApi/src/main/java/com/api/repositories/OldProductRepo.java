package com.api.repositories;

import com.api.entities.OldProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldProductRepo extends JpaRepository<OldProduct, Integer> {
}
