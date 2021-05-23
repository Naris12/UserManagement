package com.backend.usermagnament.RestController;

import com.backend.usermagnament.Model.Employee;
import com.backend.usermagnament.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmploy(){
        List<Employee>employees=employeeService.findAllemployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployById(@PathVariable("id")Long id){
        Employee employeeById = employeeService.findEmployeeById(id);
       return new ResponseEntity<>(employeeById,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable("id") long id ){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
