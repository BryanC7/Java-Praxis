package cl.praxis.hospitalpostpandemia.service.impl;

import cl.praxis.hospitalpostpandemia.entity.Patient;
import cl.praxis.hospitalpostpandemia.repository.IPatientRepository;
import cl.praxis.hospitalpostpandemia.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientServiceImpl")
public class PatientServiceImpl implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Patient getPatientById(Long id) { return patientRepository.findById(id).orElse(null);}
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
