package com.example.iniflex.project.test.resources;

import com.example.iniflex.project.test.dto.EmployeeDTO;
import com.example.iniflex.project.test.entities.Employee;
import com.example.iniflex.project.test.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/sumSalary")
    public double sumSalary() {
        return service.sumSalary();
    }

    @GetMapping(value = "/minSalary")
    public List<String> minSalary() {
        return service.minSalary();
    }

    @PutMapping(value = "/updateSalary")
    public int updateSalary() {
        return service.updateSalary();
    }

    @GetMapping(value = "/dateOfBirth")
    public List<Employee> dateOfBirth() {
        return service.dateOfBirth();
    }

    @GetMapping(value = "/orderName")
    public List<Employee> nameAllOrder() {
        return service.nameAllOrder();
    }

    @GetMapping(value = "/olderEmployee")
    public String olderEmployee() {
        return service.olderEmployee();
    }

    @GetMapping(value = "/groupAll")
    public List<Employee> groupAll() {
        return service.groupAll();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
