package cl.praxis.hospitalpostpandemia.controller;

import cl.praxis.hospitalpostpandemia.entity.Patient;
import cl.praxis.hospitalpostpandemia.service.IPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    @Autowired
    private IPatientService patientService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    // ---------- ROUTES ----------
    @GetMapping("/patients")
    public String showPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        LOGGER.info("----- Mostrando toda la lista de pacientes -----");
        return "patients";
    }
    @GetMapping("/form")
    public String newPatient() {
        LOGGER.info("----- Formulario para agregar pacientes -----");
        return "form";
    }
    @GetMapping("/update")
    public String savePatient(@RequestParam Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            model.addAttribute("patient", patient);
            LOGGER.info("----- Formulario para editar pacientes -----");
        }
        return "form";
    }

    // ---------- CRUD ----------
    @PostMapping("/patients")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        LOGGER.info("----- Paciente agregado correctamente -----");
        return "redirect:/patients";
    }
    @PutMapping()
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient);
        LOGGER.info("----- Paciente actualizado correctamente -----");
        return "redirect:/patients";
    }
    @GetMapping("/delete")
    public String deletePatient(@RequestParam Long id) {
        patientService.deletePatientById(id);
        LOGGER.info("----- Paciente eliminado correctamente -----");
        return "redirect:/patients";
    }
}
