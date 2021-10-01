package tech.taole.proxy.core.server;

import tech.taole.proxy.core.AbstractReceiver;
import tech.taole.proxy.core.server.connector.RemoteConnector;
import tech.taole.proxy.core.server.receiver.RemoteReceiver;

public class ServerContext {

    private AbstractReceiver remoteReceiver;

    private RemoteConnector remoteConnector;

    public ServerContext(){
        remoteReceiver = new RemoteReceiver();
    }

    public void start(){
        remoteReceiver.startService();
    }

}
