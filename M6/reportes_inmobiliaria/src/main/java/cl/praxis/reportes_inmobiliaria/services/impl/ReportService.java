package cl.praxis.reportes_inmobiliaria.services.impl;

import cl.praxis.reportes_inmobiliaria.entities.Report;
import cl.praxis.reportes_inmobiliaria.repositories.IReportRepository;
import cl.praxis.reportes_inmobiliaria.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reportService")
public class ReportService implements IBaseCrud<Report> {
    @Autowired
    private IReportRepository reportRepository;
    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report getById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report create(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report update(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }
}
