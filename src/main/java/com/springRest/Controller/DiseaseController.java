package com.springRest.Controller;

import com.springRest.enitity.Disease;
import com.springRest.enitity.Doctor;
import com.springRest.service.DiseaseService;
import com.springRest.service.DoctorService;
import com.springRest.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@Controller
@RequestMapping("/diseases")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/checkList")
    public String listOfDiseases(Model model) {
        model.addAttribute("diseaseList", diseaseService.getAllDiseases());
        return "disease/diseases";
    }

    @GetMapping("/list")
    public String getForm(Model model) {
        Disease disease = new Disease();
        model.addAttribute("disease", disease);
        return "disease/add-disease";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("disease") Disease disease) {
        diseaseService.save(disease);
        return "redirect:/diseases/checkList";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("disease", diseaseService.findById(id));
        return "disease/add-disease";
    }

    @GetMapping("/delete")
    @Transactional
    public String delete(@RequestParam("id") int id) {
        diseaseService.deleteById(id);
        return "redirect:/diseases/list";
    }
}











