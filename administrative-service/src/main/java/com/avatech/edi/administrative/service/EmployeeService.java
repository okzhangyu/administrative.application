package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.Employee;
import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<Employee> fetchEmployees(List<TaskRecord> taskRecords){
        if(taskRecords == null || taskRecords.size() == 0)
            return null;
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        for (TaskRecord task:taskRecords) {
            employee = employeeRepository.findByCode(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
            if(employee != null)
                employees.add(employee);
        }
        return employees;

    }
    public Employee fetchEmployee(TaskRecord record){
        return employeeRepository.findByCode(MasterData.getUniqueKey(record.getCompanyName(),record.getUniqueKey()));
    }
}
