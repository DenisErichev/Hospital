package com.springRest.DAO;

import com.springRest.enitity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery,Integer> {
}
