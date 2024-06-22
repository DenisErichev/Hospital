package com.springRest.enitity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="doctor_name")
    private String Name;
    @Column(name="father_name")
    private String fatherName;
    @Column(name="email")
    private String email;

    @ManyToOne(cascade =
            {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public Doctor()
    {

    }

    public Doctor(String name, String fatherName, String gender, String CNIC,String email, Date dateOfBirth)
    {
        Name = name;
        this.fatherName = fatherName;
        this.email = email;
    }

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
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getFatherName()
    {
        return fatherName;
    }

    public void setFatherName(String fatherName)
    {
        this.fatherName = fatherName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public Disease getDisease()
    {
        return disease;
    }

    public void setDisease(Disease disease)
    {
        this.disease = disease;
    }

    @Override
    public String toString()
    {
        return "Doctor{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", FatherName='" + fatherName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
