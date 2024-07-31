package com.springRest.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {
    @After("execution(* com.springRest.Controller.PatientController.*(..))")
    public void AfterPatient() {
        System.out.println("Клик по ссылки болезней...");
    }
    @After("execution(* com.springRest.Controller.MedicineController.*(..))")
    public void AfterMedicine() {
        System.out.println("Клик по ссылке препаратов...");
    }
    @Before("execution(* com.springRest.Controller.DiseaseController.*(..))")
    public void BeforeDisease() {
        System.out.println("Клик по ссылке болезней...");
    }
    @Before("execution(* com.springRest.Controller.DoctorController.*(..))")
    public void beforeDoctor() {
        System.out.println("Клик по ссылке врачей...");
    }
}