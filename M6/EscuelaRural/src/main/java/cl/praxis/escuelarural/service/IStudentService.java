package cl.praxis.escuelarural.service;

import cl.praxis.escuelarural.entity.Student;

import java.util.List;

public interface IStudentService {
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Long id);
}
