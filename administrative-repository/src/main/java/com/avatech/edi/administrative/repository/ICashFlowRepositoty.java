package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.CashFlow;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus on 2018/9/14.
 */
public interface ICashFlowRepositoty extends CrudRepository<CashFlow,String>{

    CashFlow findByKey(String key);
}
