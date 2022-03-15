package org.example.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.domain.Department;
import org.example.domain.Employee;

public class DepartmentRepository extends Repository {

  public List<Department> findAll() {
    try {
      DepartmentMapper departmentMapper = new DepartmentMapper();

      createConnection();
      List<Department> departments = new ArrayList<>();

      PreparedStatement findDepartmentStatement = connection.prepareStatement("SELECT * FROM skyrius");

      ResultSet result = findDepartmentStatement.executeQuery();

      while (result.next()) {
        Department department = departmentMapper.fromResultSet(result);
        departments.add(department);
      }

      return departments;
    } catch (SQLException e) {
      throw new RuntimeException("Unable to connect to db!");
    }
  }
}