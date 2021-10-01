package tech.taole.proxy.core.server.connector;

import io.netty.channel.ChannelInitializer;
import tech.taole.proxy.core.AbstractConnector;

public final class RemoteConnector extends AbstractConnector {


    @Override
    protected ChannelInitializer<?> channelInitializer() {
        return null;
    }
}
