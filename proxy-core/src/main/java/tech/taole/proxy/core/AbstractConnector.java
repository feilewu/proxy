package tech.taole.proxy.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public abstract class AbstractConnector {

    private NioEventLoopGroup worker;

    private Bootstrap bootstrap;

    public void startService(){
        init();
    }

    public Channel connect(String host, int port){
        return bootstrap.connect(host, port).channel();
    }

    protected abstract ChannelInitializer<?> channelInitializer();

    private void init(){
        worker = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap
                .group(worker)
                .channel(NioSocketChannel.class)
                .handler(channelInitializer());
    }


    public void stop(){
        if(worker!=null){
            worker.shutdownGracefully();
        }
    }

}
