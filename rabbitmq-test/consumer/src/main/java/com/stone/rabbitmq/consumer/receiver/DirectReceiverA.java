package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "TestDirectQueue", durable = "false", autoDelete = "true"),
        exchange = @Exchange(value = "TestDirectExchange"), key = "TestDirectRouting"))//监听的队列名称 TestDirectQueue
public class DirectReceiverA {

    @RabbitHandler
    public void process(Map<String, Object> testMessage) {
        System.out.println("DirectReceiver消费者收到消息  A: " + testMessage.toString());
    }

}