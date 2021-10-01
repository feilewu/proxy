package tech.taole.proxy.core.server;

public class Server {

    private ServerContext serverContext;

    public Server(){
        serverContext = new ServerContext();
    }

    public void start(){
        serverContext.start();
    }


    public ServerContext getServerContext(){
        return serverContext;
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }



}
