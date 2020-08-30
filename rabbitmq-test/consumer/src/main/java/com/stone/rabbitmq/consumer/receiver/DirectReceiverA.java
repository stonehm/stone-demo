package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "TestDirectQueue", durable = "false", autoDelete = "true"),
        exchange = @Exchange(value = "TestDirectExchange"), key = "TestDirectRouting"))//监听的队列名称 TestDirectQueue
public class DirectReceiverA {

    @RabbitHandler(isDefault = true)
    public void process(Message testMessage) {
        System.out.println("DirectReceiverA消费者收到消息  Message: " + testMessage.toString());
    }

    @RabbitHandler
    public void process(Map<String, Object> testMessage) {
        System.out.println("DirectReceiverA消费者收到消息  Map: " + testMessage.toString());
    }

    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("DirectReceiverA消费者收到消息  String: " + testMessage);
    }
}