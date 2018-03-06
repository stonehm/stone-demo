package com.stone.sjwt.controller;

import com.stone.sjwt.service.DataService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> list() {
        Map<String, Object> data = new HashMap<>();
        data.put("code", "0");
        data.put("msg", "查询成功");
        data.put("data", dataService.findAll());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/save/{name}")
    public ResponseEntity<List<String>> save(@PathVariable String name) {
        dataService.save(name);
        return new ResponseEntity<>(dataService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getJwt")
    public ResponseEntity<String> getJwt() {

        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512, "123123")
                .compact();
        return new ResponseEntity<>(compactJws, HttpStatus.OK);
    }
}
