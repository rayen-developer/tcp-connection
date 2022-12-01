package com.example.demo;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class DemoTcpConsumer {

    @ServiceActivator(inputChannel = "demo-channel")
    public void consume(byte[] bytes) {
        System.out.println(new String(bytes));
    }

}