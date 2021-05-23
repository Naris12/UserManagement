package com.backend.usermagnament.Service;

import com.backend.usermagnament.Model.Employee;
import com.backend.usermagnament.Repository.EmployeeRepository;
import com.backend.usermagnament.exception.UserNotFoundExcption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        if(employee.getImageUrl().length()<3){
            employee.setImageUrl("https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png");
        }
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllemployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
       return employeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundExcption
               ("User by Id"+id+"was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);

    }
}
