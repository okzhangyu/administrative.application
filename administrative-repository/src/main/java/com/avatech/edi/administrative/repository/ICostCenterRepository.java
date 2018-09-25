package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.CostCenter;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus on 2018/9/14.
 */
public interface ICostCenterRepository extends CrudRepository<CostCenter,String>{

    CostCenter findByKey(String key);
}
