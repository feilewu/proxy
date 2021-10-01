package tech.taole.proxy.core.client.connector;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import tech.taole.proxy.core.AbstractConnector;

public class LocalConnector extends AbstractConnector {

    @Override
    protected ChannelInitializer<?> channelInitializer() {
        return new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {

            }
        };
    }


}
