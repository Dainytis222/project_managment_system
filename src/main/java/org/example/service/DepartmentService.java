package org.example.service;

import java.util.List;
import org.example.domain.Department;
import org.example.repository.DepartmentRepository;

public class DepartmentService {
  public List<Department> getAllDepartments() {
    DepartmentRepository departmentRepository = new DepartmentRepository();
    return departmentRepository.findAll();
  }
}
