package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.Voucher;
import org.springframework.data.repository.CrudRepository;

public interface IVoucherRepository extends CrudRepository<Voucher,Integer> {

    Voucher findByOaNumber(String oaNumber);

}
