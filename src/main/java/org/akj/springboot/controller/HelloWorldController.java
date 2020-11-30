package org.akj.springboot.controller;

import org.akj.springboot.utils.IpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public ResponseEntity hello(HttpServletRequest request) {
        String sourceIp = IpUtil.getIpAddr(request);
        String localIp = IpUtil.getLocalIpAddress();
        HashMap<String, Object> map = new HashMap<>();
        map.put("sourceIp",sourceIp);
        map.put("targetIp",localIp);
        map.put("message", "hello,world!");

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
    }
}
