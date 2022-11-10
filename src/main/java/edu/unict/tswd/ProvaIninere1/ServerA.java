package edu.unict.tswd.ProvaIninere1;

import edu.unict.tswd.socket.tcp.echoserver.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.PortUnreachableException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerA {
    public static final String stop = "stop";
    public static void main(String[] args) throws IOException {
        int serverPort = 2222;

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader in;
        PrintWriter out;
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println(serverSocket);
            System.out.println("Socket Creata");
        } catch (IOException e) {
            System.out.println("Socket non Creata");
            throw new RuntimeException(e);
        }


        //wait connection
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata");


            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



            out = new PrintWriter(clientSocket.getOutputStream(),true);

            String request;
            while ((request = in.readLine()) != null) {
                if (in.equals(stop)) {
                    break;
                }

                System.out.println(request);
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
