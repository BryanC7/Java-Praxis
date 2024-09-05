package cl.praxis.escuelarural.service;

import cl.praxis.escuelarural.entity.Course;

import java.util.List;

public interface ICourseService {
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void saveCourse(Course course);

    void updateCourse(Course course);

    void deleteCourseById(Long id);
}
