package com.stone.box.task;

import com.stone.box.model.Precious;
import com.stone.box.service.FlowService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class DayTask {

    private static Logger logger = LoggerFactory.getLogger(DayTask.class);

    private final
    FlowService flowService;

    @Value("${user.appId}")
    private String appId;

    @Autowired
    public DayTask(FlowService flowService) {
        this.flowService = flowService;
    }

    @Scheduled(cron = "0 10,30,50 6-23 * * ?")
    public void balloon() {
        logger.info("execute balloon()");
        logger.info("appId:" + appId);
        flowService.getFriends(appId)
                .forEach(p -> flowService.getBalloonList(appId, p.getFriendUserId())
                        .forEach(balloon -> flowService.drawBalloon(appId, balloon.getId())));
        logger.info("exit balloon()");
    }

    @Scheduled(cron = "0 0,20,40 * * * ?")
    public void getPrecious() {
        logger.info("execute getPrecious()");
        logger.info("appId:" + appId);
        AtomicBoolean isAward = new AtomicBoolean(false);
        List<Precious> preciousList = flowService.getPreciousList(appId);
        preciousList.forEach(p -> {
            if ("1".equals(p.getUnlockStatus()) && (System.currentTimeMillis() - p.getUnlockStartTime()) / 60000 > p.getUnlockPeriod()) {
                flowService.awardPrecious(appId, p.getPreciousNo());
                flowService.getPrecious(appId);
                isAward.set(true);
            }
        });
        if (isAward.get()) {
            preciousList.forEach(p -> {
                if ("0".equals(p.getUnlockStatus())) {
                    flowService.unlockPrecious(appId, p.getPreciousNo());
                }
            });
        }
        logger.info("exit getPrecious()");
    }
}