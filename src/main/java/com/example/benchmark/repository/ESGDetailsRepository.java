package com.example.benchmark.repository;

import com.example.benchmark.entity.BenchMarkData;
import com.example.benchmark.entity.ESGDetails;
import com.example.benchmark.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ESGDetailsRepository extends MongoRepository<BenchMarkData,String> {

    //@Query(value = "{'eventName':?0, 'benchmarkDetails.esgType': ?1, 'benchmarkDetails.esgIndicators': ?2}")
    //List<BenchMarkData> findByEntityNameAndBenchmarkDetails_esgTypeAndBenchmarkDetails_esgIndicator(String eventName, String esgType, String esgIndicator);

    BenchMarkData findByEntityName(String entityName);
}
