package com.stone.box.task;

import com.stone.box.model.Balloon;
import com.stone.box.model.Friend;
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
    private String[] appId;

    @Autowired
    public DayTask(FlowService flowService) {
        this.flowService = flowService;
    }

    @Scheduled(cron = "0 10,30,50 6-23 * * ?")
    public void balloon() {
        logger.info("execute balloon()");
        for (String id : appId) {
            logger.info("appId:" + id);
            flowService.getFriends(id)
                    .forEach(p -> flowService.getBalloonList(id, p.getFriendUserId())
                            .forEach(balloon -> flowService.drawBalloon(id, balloon.getId())));
        }
        logger.info("exit balloon()");
    }

    @Scheduled(cron = "0 0,20,40 0-6,19-23 * * ?")
    public void getPrecious() {
        logger.info("execute getPrecious()");
        for (String id : appId) {
            logger.info("appId:" + id);
            AtomicBoolean isAward = new AtomicBoolean(false);
            List<Precious> preciousList = flowService.getPreciousList(id);
            preciousList.forEach(p -> {
                if ("1".equals(p.getUnlockStatus()) && (System.currentTimeMillis() - p.getUnlockStartTime()) / 60000 > p.getUnlockPeriod()) {
                    flowService.awardPrecious(id, p.getPreciousNo());
                    flowService.getPrecious(id);
                    isAward.set(true);
                    return;
                }
                if (isAward.get()) {
                    isAward.set(false);
                    flowService.unlockPrecious(id, p.getPreciousNo());
                }
            });
            if (isAward.get()) {
                preciousList.forEach(p -> {
                    if ("0".equals(p.getUnlockStatus())) {
                        flowService.unlockPrecious(id, p.getPreciousNo());
                    }
                });

            }
        }
        logger.info("exit getPrecious()");
    }
}
