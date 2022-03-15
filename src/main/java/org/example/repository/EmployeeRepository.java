package org.example.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.domain.Employee;

public class EmployeeRepository extends Repository {

  public List<Employee> findAll() {
    try {
      EmployeeMapper employeeMapper = new EmployeeMapper();

      createConnection();
      List<Employee> employees = new ArrayList<>();

      PreparedStatement findEmployeesStatement = connection.prepareStatement("SELECT * FROM darbuotojas");

      ResultSet result = findEmployeesStatement.executeQuery();

      while (result.next()) {
        Employee employee = employeeMapper.fromResultSet(result);
        employees.add(employee);
      }

      return employees;
    } catch (SQLException e) {
      throw new RuntimeException("Unable to connect to db!");
    }
  }
}
