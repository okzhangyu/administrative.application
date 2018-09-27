package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends CrudRepository<Employee,String> {

    Employee findByCode(String code);
}
