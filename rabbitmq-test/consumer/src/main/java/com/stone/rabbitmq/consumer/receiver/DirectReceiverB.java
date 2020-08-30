package com.stone.rabbitmq.consumer.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
@RabbitListener(queues = "TestDirectQueue", ackMode = "MANUAL")//监听的队列名称 TestDirectQueue
public class DirectReceiverB {

    @RabbitHandler(isDefault = true)
    public void process(Message testMessage, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        System.out.println("DirectReceiverB消费者收到消息  Message: " + testMessage.toString());
        channel.basicAck(deliveryTag, false);
    }

    @RabbitHandler
    public void process(Map<String, Object> testMessage, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        System.out.println("DirectReceiverB消费者收到消息  Map: " + testMessage.toString());
        channel.basicNack(deliveryTag, true, true);
    }

    @RabbitHandler
    public void process(String testMessage, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        System.out.println("DirectReceiverB消费者收到消息  String: " + testMessage);
        channel.basicReject(deliveryTag, false);
    }
}