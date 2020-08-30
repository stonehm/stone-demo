package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.A", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processA(Map<String, Object> testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.B", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processB(Map<String, Object> testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.C", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processC(Map<String, Object> testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = "fanout.A")
    public void processD(Map<String, Object> testMessage) {
        System.out.println("FanoutReceiverD消费者收到消息  : " + testMessage.toString());
    }
}