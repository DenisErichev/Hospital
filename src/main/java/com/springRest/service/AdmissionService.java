package com.springRest.service;

import com.springRest.DAO.AdmissionRepository;
import com.springRest.enitity.Admission;
import com.springRest.enitity.Disease;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AdmissionService {
    @Autowired
    AdmissionRepository admissionRepository;
    public void save(Admission admission)
    {
        admissionRepository.save(admission);
    }

    public Admission findById(int id)
    {
        return admissionRepository.findById(id).get();
    }


    public void deleteById(int id)
    {
        admissionRepository.deleteById(id);
    }
}
