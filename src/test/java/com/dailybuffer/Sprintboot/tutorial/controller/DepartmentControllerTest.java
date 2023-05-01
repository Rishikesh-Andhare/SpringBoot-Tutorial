package com.dailybuffer.Sprintboot.tutorial.controller;

import com.dailybuffer.Sprintboot.tutorial.entity.Department;
import com.dailybuffer.Sprintboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().
                departmentAddress("Mumbai").
                departmentName("IT").
                departmentCode("090").
                departmentId(52L).build();

    }


    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().
                departmentAddress("Mumbai").
                departmentName("IT").
                departmentCode("090").
                departmentId(1L).build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t\"departmentId\": 52,\n" +
                "\t\"departmentName\": \"IT\",\n" +
                "\t\"departmentAddress\": \"Mumbai\",\n" +
                "\t\"departmentCode\": \"090\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(52L)).thenReturn(department);
        mockMvc.perform(get("/departments/52").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
}