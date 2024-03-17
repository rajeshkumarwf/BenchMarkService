package com.example.benchmark.service;

import com.example.benchmark.entity.BenchMarkData;
import com.example.benchmark.entity.BenchMarkDetails;
import com.example.benchmark.repository.ESGDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class BenchMarkService {


    @Autowired
    private WebClient webClient;

    @Autowired
    private ESGDetailsRepository esgDetailsRepository;

    @Autowired
    Environment env;

    @Value("${contextUrl}")
    private String contextUrl;

    public BenchMarkData fetchData(String entityName) {
        return esgDetailsRepository.findByEntityName(entityName);
    }

    public BenchMarkDetails findByEventNameEsgAndInd(String entityName, String esgType, String esgIndicator) {
        BenchMarkDetails benchMarkDetails = new BenchMarkDetails();
        BenchMarkData benchMarkData = esgDetailsRepository.findByEntityName(entityName);
        for (BenchMarkDetails obj : benchMarkData.getBenchmarkDetails()) {
            if (obj.getEsgType().equalsIgnoreCase(esgType)
                    && obj.getEsgIndicators().equalsIgnoreCase(esgIndicator)) {
                return obj;
            }
        }
        return benchMarkDetails;
    }

    public void invokeEngine(String entityName) {
        //Async API call
        webClient.get().uri(contextUrl + entityName).retrieve().
                onStatus(httpStatus -> httpStatus.value() != 200,
                        error -> Mono.error(new Exception("error Body"))).
                bodyToMono(BenchMarkData.class)
                .subscribe();
    }
}

