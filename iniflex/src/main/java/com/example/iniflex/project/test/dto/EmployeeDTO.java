package com.example.iniflex.project.test.dto;

import com.example.iniflex.project.test.entities.Employee;
import com.example.iniflex.project.test.entities.Person;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EmployeeDTO extends Person {
    private static final long serialVersionUID = 1L;

    @NumberFormat(pattern = ",##0,00", style = Style.PERCENT)
    private BigDecimal salary;
    private String function;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(Long idPerson, String namePerson, LocalDate dtBirth, Employee entity) {
        super(idPerson, namePerson, dtBirth);
        this.salary = entity.getSalary();
        this.function = entity.getFunction();
    }

    public EmployeeDTO(Employee entity) {

    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}

