package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "topic.man", durable = "false", autoDelete = "true"),
        exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC), key = "topic.man"))
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map<String, Object> testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }
}