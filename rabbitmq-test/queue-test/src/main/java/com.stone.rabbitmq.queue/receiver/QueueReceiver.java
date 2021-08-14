package com.stone.rabbitmq.queue.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiver {

    @RabbitListener(queuesToDeclare = @Queue(value = "TestQueue",durable = "false", autoDelete = "true"))
    public void process(Message testMessage) {
        System.out.println("消费者收到消息  Message: " + testMessage.toString());
    }
}
