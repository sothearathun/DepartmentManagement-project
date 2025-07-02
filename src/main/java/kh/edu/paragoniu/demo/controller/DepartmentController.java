package kh.edu.paragoniu.demo.controller;

import kh.edu.paragoniu.demo.entity.Department;
import kh.edu.paragoniu.demo.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    create
    @GetMapping("/add_department")
    public String addDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "add_department";
    }
    @PostMapping("/add_department")
    public String addDepartment(Department department) {
        departmentService.addDepartment(department);
        return "redirect:/";
    }

//    read
    @GetMapping("/all_departments")
    public String allDepartment(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "all_departments";
    }
    @GetMapping("/department/{id}")
    public String department(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "show_department";
    }


//    update
    @GetMapping("/department/edit/{id}")
    public String editDepartment(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "edit_department";
    }
    @PostMapping("/department/edit/{id}")
    public String editDepartment(@PathVariable("id") Integer id, Department department) {
        departmentService.updateDepartment(id, department);
        return "redirect:/";
    }

//    delete
    @PostMapping("/department/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/";
    }
}
