package kh.edu.paragoniu.demo.repository;

import kh.edu.paragoniu.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
