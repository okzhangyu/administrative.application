package com.avatech.edi.administrative.api;

import com.avatech.edi.administrative.model.bo.Voucher;
import com.avatech.edi.administrative.model.dto.Result;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("administrative")
public class VouchersController {

    @PostMapping("voucher")
    public Result generateVoucher(@RequestBody Voucher voucher){
        Result result = new Result();

        return result;
    }

}
