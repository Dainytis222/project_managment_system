package org.example.domain;

public class Department {

  private DepartmentType departmentType;
  private String leaderPC;

  public Department(DepartmentType departmentType, String leaderPC) {
    this.departmentType = departmentType;
    this.leaderPC = leaderPC;
  }

  @Override
  public String toString() {
    return "Department{" +
        "departmentType=" + departmentType +
        ", leaderPC=" + leaderPC +
        '}';
  }

  public DepartmentType getDepartmentType() {
    return departmentType;
  }

  public String getLeaderPC() {
    return leaderPC;
  }
}
