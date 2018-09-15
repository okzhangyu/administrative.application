package com.avatech.administrative.repository;

import com.avatech.administrative.model.bo.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus on 2018/9/14.
 */
public interface IAccountRepository extends CrudRepository<Account,String>{

}
