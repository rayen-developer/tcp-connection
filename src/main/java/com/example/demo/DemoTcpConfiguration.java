package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.connection.TcpNetClientConnectionFactory;
import org.springframework.integration.ip.tcp.serializer.ByteArraySingleTerminatorSerializer;


@Configuration
public class DemoTcpConfiguration {

    @Bean
    public TcpReceivingChannelAdapter demoTcpReceivingChannelAdapter() {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(prepareDemoTcpNetClientConnectionFactory());
        adapter.setClientMode(true);
        adapter.setOutputChannelName("demo-channel");
        return adapter;
    }

    private TcpNetClientConnectionFactory prepareDemoTcpNetClientConnectionFactory(){
        TcpNetClientConnectionFactory factory =
                new TcpNetClientConnectionFactory("localhost", 8081);
        factory.setDeserializer(new ByteArraySingleTerminatorSerializer((byte) '\n'));
        return factory;
    }

}
