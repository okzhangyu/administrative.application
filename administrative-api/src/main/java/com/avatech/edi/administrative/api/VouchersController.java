package com.avatech.edi.administrative.api;

import com.avatech.common.edi.administrative.common.exception.BaseException;
import com.avatech.edi.administrative.model.bo.*;
import com.avatech.edi.administrative.model.dto.Result;
import com.avatech.edi.administrative.service.VoucherService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ResultCheckStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("administrative/v1/*")
public class VouchersController {

    private Logger logger = LoggerFactory.getLogger(VouchersController.class);
    @Autowired
    private VoucherService voucherService;

    @RequestMapping(value = "voucher",method ={RequestMethod.POST})
    public @ResponseBody Result generateVoucher(@RequestBody Voucher voucher){
        logger.info("接收凭单信息>>>>>>>>>{0}",voucher.toString());
        Result result = new Result();
        try{
            result = Result.ok(voucherService.saveVoucher(voucher));
        }catch (BaseException e){
            return Result.error("10000",e.getMessage());
        }catch (Exception e){
            return Result.error("10001",e.getMessage());
        }
        logger.info("凭单处理结果>>>>>>>>{0}",result.toString());
        return result;
    }

    @GetMapping("vouchers")
    public Result getVoucher(){
        IVoucher voucher = new Voucher();
        voucher.setOaNumber("1");
        voucher.setDocDate(new Date());
        voucher.setComments("this is test");
        List<VoucherItem> voucherItems = new ArrayList<>();

        VoucherItem voucherItem = new VoucherItem();
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
