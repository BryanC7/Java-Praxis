package cl.praxis.escuelarural.service.impl;

import cl.praxis.escuelarural.entity.Course;
import cl.praxis.escuelarural.repository.ICourseRepository;
import cl.praxis.escuelarural.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;
    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
