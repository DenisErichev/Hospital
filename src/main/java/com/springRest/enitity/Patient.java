package com.springRest.enitity;

//Committed in git.

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="patient_name")
    private String patientName;
    @Column(name="father_name")
    private String fatherName;
    @Column(name="gender")
    private String gender;
    @Column(name="cnic")
    private String cnic;
    @Column(name="date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name="disease_history")
    private String DiseaseHistory;
    @Column(name="priscription")
    private String Prescription;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="doctor_name")
    private Doctor doctor;

    public Patient() {}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return patientName;
    }

    public void setName(String name)
    {
        patientName = name;
    }

    public String getFatherName()
    {
        return fatherName;
    }

    public void setFatherName(String fatherName)
    {
        this.fatherName = fatherName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCNIC()
    {
        return cnic;
    }

    public void setCNIC(String CNIC)
    {
        this.cnic = CNIC;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public String getDiseaseHistory()
    {
        return DiseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory)
    {
        DiseaseHistory = diseaseHistory;
    }

    public String getPrescription()
    {
        return Prescription;
    }

    public void setPrescription(String prescription)
    {
        Prescription = prescription;
    }

}
