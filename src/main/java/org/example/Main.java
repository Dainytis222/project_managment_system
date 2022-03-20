package org.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.example.domain.Department;
import org.example.domain.DepartmentType;
import org.example.domain.Employee;
import org.example.domain.OccupationType;
import org.example.domain.Project;
import org.example.repository.DepartmentRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.ProjectRepository;
import org.example.service.DepartmentService;
import org.example.service.EmployeeService;
import org.example.service.ProjectService;

public class Main {

  public static EmployeeService employeeService;
  public static ProjectService projectService;
  public static EmployeeRepository employeeRepository;
  public static ProjectRepository projectRepository;
  public static DepartmentService departmentService;
  public static DepartmentRepository departmentRepository;

  public static void main(String[] args) {
    projectRepository = new ProjectRepository();
    employeeRepository = new EmployeeRepository();
    projectService = new ProjectService();
    employeeService = new EmployeeService(employeeRepository, projectRepository);
    departmentService = new DepartmentService();
    departmentRepository = new DepartmentRepository();

    printEmployeesForProject();
    printAllDepartments();
    addNewEmplyee();

  }

  private static void printEmployeeFullNames() {
    List<Employee> employees = employeeService.getAllEmployees();

    for (Employee e : employees) {
      System.out.println(e.getName() + " " + e.getLastName());
    }
  }

  private static void printAllProjects() {
    List<Project> projects = projectService.getAllProjects();

    System.out.println(projects);
  }

  private static void printAllDepartments() {
    List<Department> departments = departmentService.getAllDepartments();

    System.out.println(departments);
  }

  private static void printEmployeesForProject() {
    Map<Project, List<Employee>> employeesForProject = employeeService.getEmployeesForProject();

    Set<Project> mapKeys = employeesForProject.keySet();

    for (Project project : mapKeys) {
      System.out.println("= " + project.getName() + " =");

      List<Employee> employeeList = employeesForProject.get(project);

      int i = 1;
      for (Employee employee : employeeList) {
        System.out.println(i + ". " + employee.getName() + " " + employee.getLastName());
        i++;
      }
    }
  }

  private static void addNewEmplyee() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Įveskite darbuotojo asmens kodą: ");
    String employeePC = scanner.next();
    System.out.println("Įveskite darbuotojo vardą: ");
    String employeeName = scanner.next();
    System.out.println("Įveskite darbuotojo pavardę: ");
    String employeeSurname = scanner.next();
    System.out.println("Dirba nuo (yyyy-MM-dd): ");
    String employeeIsWorkingFrom = scanner.next();
    System.out.println("Gimimo data (yyyy-MM-dd): ");
    String employeeBirthday = scanner.next();
    System.out.println("Pareigos: ");
    String employeeOccupation = scanner.next();
    System.out.println("Skyriaus pavadinimas: ");
    String employeeDepartment = scanner.next();
    System.out.println("Projekto pavadinimas: ");
    String projectName = scanner.next();

    Integer projectId;

    if (projectName.equals("Izola")) {
      projectId = 1;
    } else if (projectName.equals("Registrų centras")) {
      projectId = 2;
    } else if (projectName.equals("Kaunas")) {
      projectId = 3;
    } else {
      projectId = null;
    }

    Employee employee = new Employee(employeePC, employeeName, employeeSurname,
        LocalDate.parse(employeeIsWorkingFrom), LocalDate.parse(employeeBirthday),
        OccupationType.valueOf(employeeOccupation), DepartmentType.valueOf(employeeDepartment), projectId);

    System.out.println(employee);
  }
}