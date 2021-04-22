package com.atguigu.springcloud.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.EnableBinding;

@Component
@EnableBinding(Sink.class)
public class controller {
    @Value("${server.port}")
    String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消息是"+message.getPayload()+"\t"+port);

    }

}
