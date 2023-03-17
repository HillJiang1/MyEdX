package com.hilljiang.eduservice.controller;

import com.hilljiang.commonutils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eduservice/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("login")
    public Result login(){
        return Result.ok().data("token","admin_hilljiang");
    }

    @GetMapping("info")
    public Result info(){
        return  Result.ok().data("roles", "[Admin]").data("name","admin_hilljiang").data("avatar","https://wpimg.wallstcn.com/69a1c46c-eb1c-4b46-8bd4-e9e686ef5251.png");
    }
}
