package com.example.gateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test/a")
public class TestController {

    @GetMapping("")
    public Map<String,Object> test(){
        Map<String,Object> map=new HashMap<>();
        map.put("vvv",9010);
        return map;
    }
}
