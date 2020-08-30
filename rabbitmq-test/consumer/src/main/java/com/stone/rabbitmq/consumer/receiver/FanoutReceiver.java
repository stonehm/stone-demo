package com.stone.rabbitmq.consumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.A", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processA(Message message) {
        System.out.println("FanoutReceiverA消费者收到消息  : " + message.toString());
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.B", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processB(Message message) {
        System.out.println("FanoutReceiverB消费者收到消息  : " + message.toString());
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.C", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)))
    public void processC(Message message) {
        System.out.println("FanoutReceiverC消费者收到消息  : " + message.toString());
    }

    @RabbitListener(queues = "fanout.A")
    public void processD(Message message) {
        System.out.println("FanoutReceiverD消费者收到消息  : " + message.toString());
    }
}