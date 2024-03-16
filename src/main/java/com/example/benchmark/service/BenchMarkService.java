package com.example.benchmark.service;

import com.example.benchmark.entity.BenchMarkData;
import com.example.benchmark.entity.BenchMarkDetails;
import com.example.benchmark.entity.ESGDetails;
import com.example.benchmark.entity.Inventory;
import com.example.benchmark.repository.ESGDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenchMarkService {

    @Autowired
    private ESGDetailsRepository esgDetailsRepository;

    public BenchMarkData fetchData(String entityName) {
        return esgDetailsRepository.findByEntityName(entityName);
    }

    public BenchMarkDetails findByEventNameEsgAndInd(String entityName, String esgType, String esgIndicator) {
        BenchMarkDetails benchMarkDetails = new BenchMarkDetails();
        BenchMarkData benchMarkData = esgDetailsRepository.findByEntityName(entityName);
        for(BenchMarkDetails obj:benchMarkData.getBenchmarkDetails()){
            if(obj.getEsgType().equalsIgnoreCase(esgType)
            && obj.getEsgIndicators().equalsIgnoreCase(esgIndicator)){
                return obj;
            }
        }
        return benchMarkDetails;
    }

    public void invokeEngine(String entityName) {
        //Async API call
    }
}
