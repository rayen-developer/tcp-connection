package com.example.demo;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import com.euronext.optiq.dd.FullTradeInformationDecoder;
import com.euronext.optiq.dd.MessageHeaderDecoder;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

@MessageEndpoint
public class DemoTcpConsumer {

    @ServiceActivator(inputChannel = "demo-channel")
    public void consume(byte[] bytes) throws InstantiationException, IllegalAccessException {
	final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
	final FullTradeInformationDecoder fullTradeInformationDecoder = new FullTradeInformationDecoder();
	DirectBuffer buffer = new UnsafeBuffer();
	buffer.wrap(bytes);
	headerDecoder.wrap(buffer, 0);
	System.out.println(headerDecoder);
	//System.out.println(buffer.byteArray().toString());
	//fullTradeInformationDecoder.wrapAndApplyHeader(buffer, 0, headerDecoder);
	//fullTradeInformationDecoder.wrap(buffer, bufferOffset, actingBlockLength, actingVersion);
	//System.out.println(ahmed);
	//fullTradeInformationDecoder.wrapAndApplyHeader(buffer,0, headerDecoder);
	//System.out.println(fullTradeInformationDecoder.buffer());
	//fullTradeInformationDecoder.wrapAndApplyHeader(rayen, fullTradeInformationDecoder.offset(), headerDecoder);
       //System.out.println(headerDecoder.templateId());
	//for(int i=0;i<4;i++){
	//	System.out.println(bytes[i]);
	//}
	//System.out.println(bytes[0]);
	//System.out.println(new String(bytes));
 }
}
