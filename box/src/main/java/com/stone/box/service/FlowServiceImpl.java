package com.stone.box.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stone.box.model.*;
import com.stone.box.task.DayTask;
import com.stone.box.util.HttpClientUtil;

import com.stone.box.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlowServiceImpl implements FlowService {

    private static Logger logger = LoggerFactory.getLogger(DayTask.class);

    private final HttpClientUtil httpClientUtil;

    @Autowired
    public FlowServiceImpl(HttpClientUtil httpClientUtil) {
        this.httpClientUtil = httpClientUtil;
    }

    @Override
    @CacheEvict(value = "precious", key = "'list' + #appId")
    public void getPrecious(String appId) {
        String uri = "http://api.irichi.cn:8348/screenlock/limited/attend";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("id", "10");
        parameters.put("data", "{\"score\":\"20164\",\"preciousId\":\"3\"}");

        String result = httpClientUtil.post(uri, parameters);
        logger.info("getPrecious:" + result);
    }

    @Override
    @Cacheable(value = "precious", key = "'list' + #appId")
    public List<Precious> getPreciousList(String appId) {
        String uri = "http://api.irichi.cn:8348/screenlock/precious/listUnlock";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("getPreciousList:" + result);

        ResultData<List<Precious>> resultData = new Gson().fromJson(result, new TypeToken<ResultData<List<Precious>>>() {
        }.getType());
        return resultData.getData();
    }

    @Override
    @CacheEvict(value = "precious", key = "'list' + #appId")
    public void unlockPrecious(String appId, String preciousNo) {
        String uri = "http://api.irichi.cn:8348/screenlock/precious/unlock";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("preciousNo", preciousNo);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("unlockPrecious:" + result);
    }

    @Override
    @CacheEvict(value = "precious", key = "'list' + #appId")
    public void awardPrecious(String appId, String preciousNo) {
        String uri = "http://api.irichi.cn:8348/screenlock/precious/award";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("preciousNo", preciousNo);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("awardPrecious:" + result);
    }

    @Override
    public List<Friend> getFriends(String appId) {
        String uri = "http://api.irichi.cn:8348/screenlock/friend/list";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("needStep", "false");

        String result = httpClientUtil.post(uri, parameters);
        logger.info("getFriends:" + result);
        ResultData<List<Friend>> resultData = new Gson().fromJson(result, new TypeToken<ResultData<List<Friend>>>() {
        }.getType());

        return resultData.getData();
    }

    @Override
    public List<Balloon> getBalloonList(String appId, String userId) {
        String uri = "http://api.irichi.cn:8348/screenlock/balloon/list";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("userId", userId);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("getBalloonList:" + result);
        ResultData<List<Balloon>> resultData = new Gson().fromJson(result, new TypeToken<ResultData<List<Balloon>>>() {
        }.getType());

        return resultData.getData();
    }

    @Override
    public void drawBalloon(String appId, String balloonId) {
        String uri = "http://api.irichi.cn:8348/screenlock/balloon/draw";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);
        parameters.put("balloonId", balloonId);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("drawBalloon:" + result);
    }

    @Override
    public Pool getPoolStat(String appId) {
        String uri = "http://api.irichi.cn:8348/screenlock/pool/stat";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);

        String result = httpClientUtil.post(uri, parameters);
        logger.info("getPoolStat:" + result);
        ResultData<Pool> resultData = new Gson().fromJson(result, new TypeToken<ResultData<Pool>>() {
        }.getType());

        return resultData.getData();
    }

    @Override
    public void withdraw(String appId) {
        String uri = "http://api.irichi.cn:8348/screenlock/pool/withdraw";

        Map<String, String> parameters = ParamUtil.getParametersMap(appId);

        parameters.put("amount", "100");
        parameters.put("mobile", "18334791077");

        String result = httpClientUtil.post(uri, parameters);
        logger.info("withdraw:" + result);
    }
}
