package cl.praxis.reportes_inmobiliaria.controllers;

import cl.praxis.reportes_inmobiliaria.entities.Report;
import cl.praxis.reportes_inmobiliaria.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reports")
public class ReportRestController {
    @Autowired
    private IBaseCrud<Report> reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAll();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.create(report);
    }

    @PutMapping
    public Report updateReport(@RequestBody Report report) {
        return reportService.update(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.delete(id);
    }
}
