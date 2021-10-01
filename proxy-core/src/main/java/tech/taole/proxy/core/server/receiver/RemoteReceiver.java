package tech.taole.proxy.core.server.receiver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import tech.taole.proxy.core.AbstractReceiver;

public class RemoteReceiver extends AbstractReceiver {

    @Override
    protected ChannelInitializer<?> channelInitializer() {

        return new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(256, 0, 2,0,2));
                ch.pipeline().addLast(new MyHandler());
            }
        };
    }
}
