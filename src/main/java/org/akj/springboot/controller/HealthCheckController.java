package org.akj.springboot.controller;

import org.akj.springboot.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity hello(HttpServletRequest request) {
        final String sourceIp = Utils.getIpAddr(request);
        final String localIp = Utils.getLocalIpAddress();
        final String hostName = Utils.getHostName();

        HashMap<String, Object> map = new HashMap<>();
        map.put("sourceIp", sourceIp);
        map.put("targetIp", localIp);
        map.put("hostName", hostName);
        map.put("status", "UP");

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
    }
}
