package com.example.benchmark.controller;

import com.example.benchmark.entity.BenchMarkData;
import com.example.benchmark.entity.BenchMarkDetails;
import com.example.benchmark.service.BenchMarkService;
import com.example.benchmark.service.MyBlobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class BlobController {
    @Autowired
    private MyBlobService myBlobService;

    @Autowired
    private BenchMarkService benchMarkService;


    @GetMapping("/listBlobs")
    public List<String> blobitemst() {
        return myBlobService.listFiles();
    }

    @PostMapping("/esg/benchmark/upload/{entityName}")
    public BenchMarkData uploadFileV1(MultipartFile file, @PathVariable String entityName) throws Exception {
        myBlobService.storeFile(entityName+".pdf", file.getInputStream(), file.getSize(),entityName);
        benchMarkService.invokeEngine(entityName);
        return benchMarkService.fetchData(entityName);
    }
    @PostMapping("/esg/benchmark/fetch/{entityName}")
    public BenchMarkData fetchByEntityNameV1(MultipartFile file, @PathVariable String entityName) throws IOException {
        return benchMarkService.fetchData(entityName);
    }

    @PostMapping("/esg/benchmark/upload/{entityName}/{esgType}/{esgIndicator}")
    public BenchMarkDetails uploadByTypeAndIndicator(MultipartFile file, @PathVariable String entityName, @PathVariable String esgType, @PathVariable String esgIndicator) throws Exception {
        myBlobService.storeFile(entityName+".pdf", file.getInputStream(), file.getSize(),entityName);
        benchMarkService.invokeEngine(entityName);
        return benchMarkService.findByEventNameEsgAndInd(entityName, esgType, esgIndicator);
    }
}