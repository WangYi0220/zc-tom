package com.zc.tom.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

public interface StatisticsService {
    ResponseEntity<InputStreamResource> statistics(String classUUID, String beginDate, String endDate);
}
