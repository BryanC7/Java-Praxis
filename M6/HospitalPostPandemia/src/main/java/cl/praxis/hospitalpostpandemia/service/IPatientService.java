package cl.praxis.hospitalpostpandemia.service;

import cl.praxis.hospitalpostpandemia.entity.Patient;

import java.util.List;

public interface IPatientService {
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatientById(Long id);
}
