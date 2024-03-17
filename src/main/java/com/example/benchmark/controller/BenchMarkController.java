package com.example.benchmark.controller;

import com.example.benchmark.entity.BenchMarkData;
import com.example.benchmark.service.BenchMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenchMarkController {

    @Autowired
    BenchMarkService benchMarkService;

    @GetMapping("/getCollection/{entityName}")
    public BenchMarkData getData(@PathVariable String entityName){
        return benchMarkService.fetchData(entityName);
    }
}
