package cl.praxis.escuelarural.controller;

import cl.praxis.escuelarural.entity.Course;
import cl.praxis.escuelarural.entity.Student;
import cl.praxis.escuelarural.service.ICourseService;
import cl.praxis.escuelarural.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentService studentService;

    // ---------- ROUTES ----------

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/course-form")
    public String newCourse() {
        return "course-form";
    }

    @GetMapping("/update-course")
    public String saveCourse(@RequestParam Long id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
        }
        return "course-form";
    }

    // ---------- CRUD ----------
    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
    @PutMapping("/course")
    public String updateCourse(@ModelAttribute Course course) {
        courseService.updateCourse(course);
        return "redirect:/courses";
    }
    @GetMapping("/delete-course")
    public String deleteCourse(@RequestParam Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            List<Student> students = course.getStudentList();
            for (Student student : students) {
                student.setCourse(null);
                studentService.saveStudent(student);
            }
            courseService.deleteCourseById(id);
        }
        return "redirect:/courses";
    }
}