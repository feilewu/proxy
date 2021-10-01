package tech.taole.proxy.core;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.taole.proxy.core.server.ServerConfiguration;

public abstract class AbstractReceiver {

    private static final Logger logger = LoggerFactory.getLogger(AbstractReceiver.class);

    public void startService(){
        init();
    }

    protected abstract ChannelInitializer<?> channelInitializer();

    private void init(){
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boss,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(channelInitializer());

        try {
            Channel channel = serverBootstrap
                    .bind(ServerConfiguration.HOST, ServerConfiguration.PORT)
                    .sync().channel();
            logger.info("RemoteReceiver listen on {}",ServerConfiguration.PORT);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }


}
