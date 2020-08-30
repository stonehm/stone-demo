package com.stone.rabbitmq.consumer.receiver;

import com.rabbitmq.client.Channel;
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

    @RabbitHandler
    public void process(Map<String, Object> testMessage, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        System.out.println("DirectReceiver消费者收到消息  B: " + testMessage.toString());
//        channel.basicAck(deliveryTag, false);
//        channel.basicReject(deliveryTag, false);
        channel.basicNack(deliveryTag, true, true);
    }

}