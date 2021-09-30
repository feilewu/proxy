package tech.taole.proxy.core.server;

import tech.taole.proxy.core.server.receiver.RemoteReceiver;

public class Server {

    private RemoteReceiver remoteReceiver;

    private RemoteConnector remoteConnector;

    public Server(){
        remoteReceiver = new RemoteReceiver();
    }

    public void start(){
        remoteReceiver.startService();
    }



    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }



}
