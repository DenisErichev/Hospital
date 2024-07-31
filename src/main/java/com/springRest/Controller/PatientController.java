package com.springRest.Controller;

import java.util.List;

import com.springRest.enitity.Patient;
import com.springRest.service.DoctorService;
import com.springRest.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/patients")
public class PatientController
{
    private PatientService patientService;
    private DoctorService doctorService;
    private List<Patient> thePatients;
    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService)
    {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        thePatients = patientService.getAllPatients();
        theModel.addAttribute("patients", thePatients);
        return "patients/list-patients";
    }

    @GetMapping("/addPatient")
    public String getPatientForm(Model model)
    {
        Patient patient = new Patient();
        model.addAttribute("doctorList",doctorService.getAllDoctors());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient thePatient)
    {

        patientService.save(thePatient);
        return "redirect:/patients/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("patientId") int theID,Model model)
    {
        Patient patient = patientService.findById(theID);
        model.addAttribute("doctorList",doctorService.getAllDoctors());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam("patientId") int theID)
    {
        patientService.deleteById(theID);
        return "redirect:/patients/list";
    }

}









