package com.example.benchmark.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "entity-esg-details")
public class BenchMarkData {

    @Id
    String id;
    String entityName;
    List<BenchMarkDetails> benchmarkDetails = new ArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<BenchMarkDetails> getBenchmarkDetails() {
        return benchmarkDetails;
    }

    public void setBenchmarkDetails(List<BenchMarkDetails> benchMarkDetailsList) {
        this.benchmarkDetails = benchMarkDetailsList;
    }
}
