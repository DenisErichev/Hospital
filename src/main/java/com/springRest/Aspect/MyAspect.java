package com.springRest.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Aspect
@Component
public class MyAspect {
    @After("execution(* com.springRest.Controller.PatientController.*(..))")
    public void beforeControllerMethodsPatient() {
        System.out.println("Клик по ссылки болезней...");
    }
    @After("execution(* com.springRest.Controller.MedicineController.*(..))")
    public void beforeControllerMethodsMedicine() {
        System.out.println("Клик по ссылке препаратов...");
    }
    @Before("execution(* com.springRest.Controller.DiseaseController.*(..))")
    public void beforeControllerMethodsDisease() {
        System.out.println("Клик по ссылке болезней...");
    }
    @Before("execution(* com.springRest.Controller.DoctorController.*(..))")
    public void beforeControllerMethodsDoctor() {
        System.out.println("Клик по ссылке врачей...");
    }
}
