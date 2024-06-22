package com.springRest.DAO;

import com.springRest.enitity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission,Integer> {
}
