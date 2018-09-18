package com.avatech.edi.administrative.api;

import com.avatech.common.edi.administrative.common.exception.BaseException;
import com.avatech.edi.administrative.model.bo.IVoucher;
import com.avatech.edi.administrative.model.bo.IVoucherItem;
import com.avatech.edi.administrative.model.bo.Voucher;
import com.avatech.edi.administrative.model.bo.VoucherItem;
import com.avatech.edi.administrative.model.dto.Result;
import com.avatech.edi.administrative.service.VoucherService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("administrative")
public class VouchersController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping("voucher")
    public Result generateVoucher(@RequestBody Voucher voucher){
        Result result = new Result();
        try{
            voucherService.saveVoucher(voucher);
        }catch (BaseException e){
            return Result.error("10000",e.getMessage());
        }catch (Exception e){
            return Result.error("10001",e.getMessage());
        }
        return result;
    }

    @GetMapping("vouchers")
    public Result getVoucher(){
        IVoucher voucher = new Voucher();
        voucher.setOaNumber("1");
        voucher.setDocDate(new Date());
        voucher.setComments("this is test");
        List<IVoucherItem> voucherItems = new ArrayList<>();

        IVoucherItem voucherItem = new VoucherItem();
        voucherItem.setAccountCode("100101");
        voucherItem.setAccountName("人民币");
        voucherItem.setCashFlowCode("90");
        voucherItem.setProject("100");
        voucherItem.setDebit(10000.0);
        voucherItems.add(voucherItem);
        voucherItem = new VoucherItem();
        voucherItem.setAccountCode("122102");
        voucherItem.setAccountName("人民币");
        voucherItem.setControlCode("122102");
        voucherItem.setCredit(90000.0);
        voucherItem.setProject("100");
        voucherItem.setOcrCode("P0001");
        voucherItem.setOcrCode2("E001");
        voucherItems.add(voucherItem);

        voucherItem = new VoucherItem();
        voucherItem.setAccountCode("600322");
        voucherItem.setAccountName("税");
        voucherItem.setCredit(10000.0);
        voucherItem.setProject("100");
        voucherItem.setOcrCode("P0001");
        voucherItem.setOcrCode2("E001");
        voucherItems.add(voucherItem);

        voucher.setVoucherItems(voucherItems);
        return  Result.ok(voucher);
    }

}
