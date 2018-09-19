package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.Account;
import com.avatech.edi.administrative.model.bo.UniqueKey;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus on 2018/9/14.
 */
public interface IAccountRepository extends CrudRepository<Account,String>{

    Account findByAcctCodeAndCompanyName(String acctCode,String companyName);
}
