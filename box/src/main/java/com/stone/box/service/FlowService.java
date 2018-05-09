package com.stone.box.service;

import com.stone.box.model.Balloon;
import com.stone.box.model.Friend;
import com.stone.box.model.Pool;
import com.stone.box.model.Precious;

import java.util.List;

public interface FlowService {

    void getPrecious(String appId);

    List<Precious> getPreciousList(String appId);

    void unlockPrecious(String appId, String preciousNo);

    void awardPrecious(String appId, String preciousNo);

    List<Friend> getFriends(String appId);

    List<Balloon> getBalloonList(String appId, String userId);

    void drawBalloon(String appId, String balloonId);

    Pool getPoolStat(String appId);

    void withdraw(String appId);

}