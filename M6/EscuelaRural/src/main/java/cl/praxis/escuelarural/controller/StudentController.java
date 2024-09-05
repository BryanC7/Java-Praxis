package cl.praxis.escuelarural.controller;

import cl.praxis.escuelarural.entity.Student;
import cl.praxis.escuelarural.service.ICourseService;
import cl.praxis.escuelarural.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    // ---------- ROUTES ----------

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student-form")
    public String newStudent(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }

    @GetMapping("/update-student")
    public String saveStudent(@RequestParam Long id, ModelMap map) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            map.addAttribute("student", student);
            map.addAttribute("courses", courseService.getAllCourses());
        }
        return "student-form";
    }

    // ---------- CRUD ----------
    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @PutMapping("/student")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/delete-student")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
