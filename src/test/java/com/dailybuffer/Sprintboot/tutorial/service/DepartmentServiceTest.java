package com.dailybuffer.Sprintboot.tutorial.service;

import com.dailybuffer.Sprintboot.tutorial.entity.Department;
import com.dailybuffer.Sprintboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().
                departmentName("qsf").
                departmentAddress("rrwr").
                departmentCode("frt").
                departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("qsf")).thenReturn(department);
    }

    @Test
    @DisplayName("get data by department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "qsf";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
    @Test
    void saveDepartment() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void fetchDepartmentByName() {
    }
}