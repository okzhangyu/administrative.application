package com.avatech.administrative.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2018/9/7.
 */

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("test")
    public String testDemo(){
        return "hello";
    }

}
