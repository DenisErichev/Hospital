package com.springRest.enitity;


//Committed in git.

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disease")
public class Disease
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="disease_name")
    private String diseaseName;
    @Column(name="description")
    private String description;

//    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "disease",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE,
//                    CascadeType.PERSIST, CascadeType.REFRESH})
//    public List<Doctor> doctors;
//
//
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE,
//                    CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(name = "patient_disease",
//            joinColumns = @JoinColumn(name = "disease_id"),
//            inverseJoinColumns = @JoinColumn(name = "patient_id"))
//    private List<Patient> patientList;

    public Disease() {}
    public Disease(String name, String discription) {
        this.diseaseName = name;
        this.description = discription;
    }

//    public List<Doctor> getDoctors()
//    {
//        return doctors;
//    }
//
//    public void setDoctors(List<Doctor> doctors)
//    {
//        this.doctors = doctors;
//    }
//
//    public void addDoctor(Doctor doctor)
//    {
//        if(doctors == null)
//        {
//            doctors = new ArrayList<>();
//        }
//        doctors.add(doctor);
//    }

    // conveniece method for medicines


//    public void addPatient(Patient patient)
//    {
//        if(patientList == null)
//        {
//            patientList = new ArrayList<>();
//        }
//        patientList.add(patient);
//    }


    public String getDiseaseName()
    {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName)
    {
        this.diseaseName = diseaseName;
    }


    public void setId(int id) {
        this.id = id;
    }



//    public List<Patient> getPatientList()
//    {
//        return patientList;
//    }
//
//    public void setPatientList(List<Patient> patientList)
//    {
//        this.patientList = patientList;
//    }


}
