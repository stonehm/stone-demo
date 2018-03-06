package com.stone.sjwt.service.impl;

import com.stone.sjwt.service.DataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private static List<String> data = new ArrayList<>();

    static {
        data.add("张三");
        data.add("李四");
        data.add("王五");
    }

    @Override
    public void save(String name) {
        data.add(name);
    }

    @Override
    public List<String> findAll() {
        return data;
    }
}
