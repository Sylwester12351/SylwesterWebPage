package Sylwester.SylwesterWebPage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketListener implements ServletContextListener {
    private ServerSocket serverSocket;
    private final int PORT = 9092;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Starting server socket at port: " + PORT);
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected from: "+client.getInetAddress().getHostAddress());
                //handle connection ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if(serverSocket!=null) {
                System.out.println("Stopping server socket at port: " + PORT);
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
