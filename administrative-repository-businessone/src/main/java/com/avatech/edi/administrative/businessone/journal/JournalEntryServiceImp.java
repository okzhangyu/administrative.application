package com.avatech.edi.administrative.businessone.journal;

import com.avatech.common.edi.administrative.common.Utils.StringUtils;
import com.avatech.edi.administrative.businessone.B1Exception;
import com.avatech.edi.administrative.businessone.BORepositoryBusinessOne;
import com.avatech.edi.administrative.model.bo.B1Connection;
import com.avatech.edi.administrative.model.bo.IVoucher;
import com.avatech.edi.administrative.model.bo.IVoucherItem;
import com.sap.smb.sbo.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JournalEntryServiceImp implements B1JournalEntryService{

    private Logger logger = LoggerFactory.getLogger(JournalEntryServiceImp.class);
    @Override
    public String createJournalEntry(IVoucher voucher, B1Connection connection){
        BORepositoryBusinessOne boRepositoryBusinessOne = null;
        ICompany company = null;
        try {
            //get company info
            boRepositoryBusinessOne = BORepositoryBusinessOne.getInstance(connection);
            company = boRepositoryBusinessOne.getCompany();

            IJournalEntries journalEntries = SBOCOMUtil.newJournalEntries(company);

            if(voucher.getDocDate() == null)
                throw new B1Exception("过账日期[DocDate]为空");
            journalEntries.setReferenceDate(voucher.getDocDate());
            journalEntries.setDueDate(new Date());
            journalEntries.setTaxDate(new Date());
            journalEntries.setMemo(voucher.getComments());

            for (IVoucherItem item:voucher.getVoucherItems()) {
                if(StringUtils.isEmpty(item.getAccountCode()))
                    throw new B1Exception("AccountCode为空");
                journalEntries.getLines().setAccountCode(item.getAccountCode());
                journalEntries.getLines().setControlAccount(item.getAccountCode());
                if(!StringUtils.isEmpty(item.getOcrCode())){
                    //journalEntries.getLines().setShortName(item.getOcrCode());
                    journalEntries.getLines().setCostingCode(item.getOcrCode());
                }
                if(!StringUtils.isEmpty(item.getOcrCode2())){
                    journalEntries.getLines().setCostingCode2(item.getOcrCode2());
                }
                if(!StringUtils.isEmpty(item.getProject())){
                    journalEntries.getLines().setProjectCode(item.getProject());
                }
                if(!StringUtils.isEmpty(item.getCashFlowCode())){
                    //journalEntries.getLines().c
                }
                if(item.getCredit() > 0)
                    journalEntries.getLines().setCredit(item.getCredit());
                if(item.getDebit() > 0)
                    journalEntries.getLines().setDebit(item.getDebit());
                journalEntries.getLines().add();
            }

            int rstCode = journalEntries.add();
            if(rstCode == 0){
                return company.getNewObjectKey();
            }else {
                throw new B1Exception(company.getLastErrorCode() + ":" + company.getLastErrorDescription());
            }
        }catch (SBOCOMException e){
            logger.error("",e);
            throw new B1Exception(e);
        }
    }
}
