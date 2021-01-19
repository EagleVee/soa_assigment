package week1;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        ServerSocket serverSocket = null;
        Socket socket = null;
        int portNumber = Integer.parseInt(args[0]);

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

        while (true) {
            try {
                assert serverSocket != null;
                socket = serverSocket.accept();
                new EchoThread(socket).start();
            } catch (IOException e) {
                System.out.println("ACCEPT FAILED");
            }
        }
    }

}
