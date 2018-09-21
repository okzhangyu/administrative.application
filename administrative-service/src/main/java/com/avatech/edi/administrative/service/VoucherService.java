package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.businessone.journal.B1JournalEntryService;
import com.avatech.edi.administrative.config.B1Manager;
import com.avatech.edi.administrative.model.bo.B1Connection;
import com.avatech.edi.administrative.model.bo.IVoucher;
import com.avatech.edi.administrative.model.bo.Voucher;
import com.avatech.edi.administrative.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {

    @Autowired
    private IVoucherRepository voucherRepository;

    @Autowired
    private B1Manager b1Manager;

    @Autowired
    private B1JournalEntryService b1JournalEntryService;

    public void saveVoucher(IVoucher voucher){
        B1Connection connection = b1Manager.getB1ConnInstance(voucher.getCompanyName());
        b1JournalEntryService.createJournalEntry(voucher,connection);
    }
}
