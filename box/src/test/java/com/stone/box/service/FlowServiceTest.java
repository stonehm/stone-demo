package com.stone.box.service;

import com.stone.box.model.Balloon;
import com.stone.box.model.Friend;
import com.stone.box.model.Precious;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FlowServiceTest {
//
//    @Autowired
//    FlowService flowService;
//
//    private String appId = "yuYsd0cOYKyWGbRO";
//
//    @Test
//    public void getPrecious() {
//        flowService.getPrecious(appId);
//    }
//
//    @Test
//    public void getPreciousList() {
//        List<Precious> list = flowService.getPreciousList("AysG55kMICs6ZQx6");
//        for (Precious p : list) {
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    public void unlockPrecious() {
//        List<Precious> list = flowService.getPreciousList(appId);
//        for (Precious p : list) {
//            flowService.unlockPrecious(appId, p.getPreciousNo());
//        }
//
//    }
//
//    @Test
//    public void awardPrecious() {
//        List<Precious> list = flowService.getPreciousList(appId);
//        for (Precious p : list) {
//            flowService.awardPrecious(appId, p.getPreciousNo());
//        }
//
//    }
//
//    @Test
//    public void time() {
//        System.out.println((System.currentTimeMillis() - (1523708161000L)) / 60000);
//    }
//
//    @Test
//    public void getFriends() {
//        List<Friend> list = flowService.getFriends(appId);
//        for (Friend p : list) {
//            System.out.println(p);
//        }
//
//    }
//
//    @Test
//    public void getBalloonList() {
//        List<Friend> list = flowService.getFriends(appId);
//        for (Friend p : list) {
//            List<Balloon> balloonList = flowService.getBalloonList(appId, p.getFriendUserId());
//            for (Balloon b : balloonList) {
//                System.out.println(b);
//            }
//
//        }
//    }
//
//    @Test
//    public void drawBalloon() {
//        List<Friend> list = flowService.getFriends(appId);
//        for (Friend p : list) {
//            List<Balloon> balloonList = flowService.getBalloonList(appId, p.getFriendUserId());
//            for (Balloon b : balloonList) {
//                flowService.drawBalloon(appId, b.getId());
//            }
//        }
//    }
}