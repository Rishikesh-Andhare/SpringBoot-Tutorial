package com.dailybuffer.Sprintboot.tutorial.repository;

import com.dailybuffer.Sprintboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {



    public Department findByDepartmentName(String departName);
    public Department findByDepartmentNameIgnoreCase(String departName);




}
