package com.yanshang.watchpro.controller;

import com.yanshang.watchpro.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin
public class Home {
    @GetMapping
    public Result Home() {
        return new Result(200, "看到此页面说明搭建成功");
    }
}
