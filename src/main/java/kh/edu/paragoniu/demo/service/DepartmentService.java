package kh.edu.paragoniu.demo.service;

import kh.edu.paragoniu.demo.entity.Department;
import kh.edu.paragoniu.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
//    defines necessary methods for CRUD operations
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    //        when each class is created, it's gonna have its own repository

//    create
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

//    read
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

//    update
    public Department getDepartmentById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        }
        return null;
    }
    public void updateDepartment(Integer id, Department department) {
        Department updatingDepartment = getDepartmentById(id);
        updatingDepartment.setName(department.getName());
        updatingDepartment.setHead(department.getHead());
        updatingDepartment.setLocation(department.getLocation());
        departmentRepository.save(updatingDepartment);
    }

//    delete
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
