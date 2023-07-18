package com.example.iniflex.project.test.services;

import com.example.iniflex.project.test.dto.EmployeeDTO;
import com.example.iniflex.project.test.entities.Employee;
import com.example.iniflex.project.test.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAll() {
        List<Employee> list = repository.findAll();
        return list.stream()
                .map(x -> new EmployeeDTO(x.getIdPerson(), x.getNamePerson(), (x.getDtBirth()), x))
                .collect(Collectors.toList());
    }

    public double sumSalary() {
        return repository.sumSalary();
    }

    public List<String> minSalary() {
        return repository.minSalary();
    }

    public int updateSalary() {
        return repository.updateSalary();
    }

    public List<Employee> dateOfBirth() {
        return repository.dateOfBirth();
    }

    public List<Employee> nameAllOrder() {
        return repository.nameAllOrder();
    }

    public String olderEmployee() {
        return repository.olderEmployee();
    }

    public List<Employee> groupAll() {
        return repository.groupAll();
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Restrição");
        }
    }

}