package com.springRest.Controller;

import com.springRest.enitity.Doctor;
import com.springRest.service.DiseaseService;
import com.springRest.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/list")
    public String doctors(Model model) {
        model.addAttribute("doctorList", doctorService.getAllDoctors());
        return "doctors/list-doctors";
    }

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctors/add-doctor";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        doctorService.deleteById(id);
        return "redirect:/doctors/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctors/add-doctor";
    }
}









