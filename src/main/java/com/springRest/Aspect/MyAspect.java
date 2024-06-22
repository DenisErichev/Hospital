package com.springRest.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.springRest.Controller.PatientController.*(..))")
    public void beforeControllerMethodsPatient() {
        System.out.println("Работа со вкладкой пациента...");
    }
    @Before("execution(* com.springRest.Controller.MedicineController.*(..))")
    public void beforeControllerMethodsMedicine() {
        System.out.println("Работа со вкладкой лекарств...");
    }
    @Before("execution(* com.springRest.Controller.DiseaseController.*(..))")
    public void beforeControllerMethodsDisease() {
        System.out.println("Работа со вкладкой болезней...");
    }
    @Before("execution(* com.springRest.Controller.DoctorController.*(..))")
    public void beforeControllerMethodsDoctor() {
        System.out.println("Работа со вкладкой врачей...");
    }
}
