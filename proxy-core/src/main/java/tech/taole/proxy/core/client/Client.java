package tech.taole.proxy.core.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import tech.taole.proxy.core.client.connector.LocalConnector;

import java.nio.charset.StandardCharsets;

public class Client {

    private LocalConnector localConnector;

    public Client(){
        localConnector = new LocalConnector();
    }

    public void startService(){
        localConnector.startService();
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.startService();
        Channel channel = client.localConnector.connect("127.0.0.1", 12123);
        String hello = "hello server";
        ByteBuf byteBuf = Unpooled.buffer();
        byte[] bytes = hello.getBytes(StandardCharsets.UTF_8);
        byteBuf.writeShort(bytes.length);
        byteBuf.writeBytes(bytes);
        channel.writeAndFlush(byteBuf);

    }

}
