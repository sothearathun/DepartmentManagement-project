package kh.edu.paragoniu.demo.repository;

import kh.edu.paragoniu.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//    we need the generic,
}
