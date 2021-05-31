package com.cpf.qq.redisdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cpf
 */
@Api(tags="测试！")
@RestController
@RequestMapping("/redisdemo/test")
public class TestController {
    @RequestMapping("/test1")
    @ApiOperation(value="测试1")
    public String test1(){
        return "1";
    }
}
