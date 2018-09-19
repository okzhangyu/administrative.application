package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.IVoucher;
import com.avatech.edi.administrative.model.bo.Voucher;
import com.avatech.edi.administrative.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {

    @Autowired
    private IVoucherRepository voucherRepository;

    public void saveVoucher(Voucher voucher){

        voucher.setDocEntry(1);

        voucherRepository.save(voucher);
    }
}
