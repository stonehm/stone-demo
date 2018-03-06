package com.stone.sjwt.service;

import java.util.List;

public interface DataService {
    void save(String name);

    List<String> findAll();
}
