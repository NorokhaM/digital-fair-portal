package com.hacknimeto.fair_service.repositories;

import com.hacknimeto.fair_service.entities.Fair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FairRepository extends JpaRepository<Fair, Long> {

}
