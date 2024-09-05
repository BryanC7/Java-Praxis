package cl.praxis.escuelarural.service.impl;

import cl.praxis.escuelarural.entity.Student;
import cl.praxis.escuelarural.repository.ICourseRepository;
import cl.praxis.escuelarural.repository.IStudentRepository;
import cl.praxis.escuelarural.service.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
