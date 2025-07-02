package kh.edu.paragoniu.demo.service;

import kh.edu.paragoniu.demo.entity.Student;
import kh.edu.paragoniu.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//student repository provide the actions

//add annotation @Service to declare it as service
@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
//        when each class is created, it's gonna have its own repository
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

//    read data: read all data, and read specific data
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public void updateStudent(Integer id,Student student) {
        Student updatingStudent = getStudentById(id);
        updatingStudent.setUsername(student.getUsername());
        updatingStudent.setFirstName(student.getFirstName());
        updatingStudent.setLastName(student.getLastName());
        updatingStudent.setGender(student.getGender());
        updatingStudent.setDepartment(student.getDepartment());
        studentRepository.save(updatingStudent);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
