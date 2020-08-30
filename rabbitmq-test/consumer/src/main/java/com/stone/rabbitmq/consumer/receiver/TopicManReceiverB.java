package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiverB {

    @RabbitHandler
    public void process(Map<String, Object> testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  B: " + testMessage.toString());
    }
}