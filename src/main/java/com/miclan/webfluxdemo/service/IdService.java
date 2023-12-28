package com.miclan.webfluxdemo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
public class IdService {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS-");

    public String getIdForDb() {
        String now = sdf.format(Date.from(Instant.now()));
        String random = RandomStringUtils.randomAlphabetic(10).toUpperCase();
        return now + random;
    }
}
