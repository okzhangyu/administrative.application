package com.avatech.administrative.controller;


import com.avatech.administrative.model.bo.Voucher;
import com.avatech.common.data.Result;

/**
 * Created by asus on 2018/9/12.
 */
public interface IVoucherController {

     Result generateVoucher(Voucher voucher);
}
