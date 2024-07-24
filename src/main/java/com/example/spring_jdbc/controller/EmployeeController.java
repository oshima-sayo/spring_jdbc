package com.example.spring_jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_jdbc.domain.Employee;
import com.example.spring_jdbc.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private HttpSession session;
    @Autowired
    private EmployeeService service;

    @RequestMapping("/execute")
    public String execute(Model model){
        Employee employee = new Employee();
        employee.setName("山田太郎");
        employee.setAge(20);
        employee.setGender("男");
        employee.setDepartmentId(1);
        service.save(employee);

        Employee employee2 = service.load(4);
        System.out.println(employee2);
        service.deleteById(3);
        service.findAll().forEach(System.out::println);

        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "finished";
    }


    }


