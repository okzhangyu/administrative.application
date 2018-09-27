package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.Company;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyRepository extends CrudRepository<Company,String> {
}
