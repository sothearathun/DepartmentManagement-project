package kh.edu.paragoniu.demo.controller;

import kh.edu.paragoniu.demo.entity.Student;
import kh.edu.paragoniu.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    following the step of CRUD

    @GetMapping("/add_student")
//    create
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }
    @PostMapping("/add_student")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

//    read (we only need the get mapping) (read all)
   @GetMapping("/all_students")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "all_students";
    }


//    read single
    @GetMapping("/student/{id}")
//    need to get id as a parameter to our method
    public String showStudent(@PathVariable("id") Integer id, Model model) {
//        set the ID as a variable
        model.addAttribute("student", studentService.getStudentById(id));
        return "show_student";
    }

//    Update
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
//    every PostMapping we need to return redirect
    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/";
    }

//    Delete
//    for delete, we only need a postmapping, we dont need to show a page to the user
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
