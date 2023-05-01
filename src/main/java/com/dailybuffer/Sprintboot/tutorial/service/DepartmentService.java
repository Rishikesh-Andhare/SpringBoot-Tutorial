package com.dailybuffer.Sprintboot.tutorial.service;

import com.dailybuffer.Sprintboot.tutorial.entity.Department;
import com.dailybuffer.Sprintboot.tutorial.error.DepartmentNotFoundException;

import java.util.*;
public interface DepartmentService {
  public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();

  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long departmentId);

 public Department updateDepartment(Long departmentId, Department department);


    Department fetchDepartmentByName(String departmentName);
}
