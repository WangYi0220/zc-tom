package com.zc.tom.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    ResponseEntity<InputStreamResource> statistics(String classUUID);

    List<String> checkIn(String classUUID);

    void sendEmailToStudent(String email, Map<String, Object> content);
}
