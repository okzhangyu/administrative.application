package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.Department;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department,String> {

    Department findByCode(String code);
}
