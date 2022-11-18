package edu.unict.tswd.Personali.Itinere2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAA {
    public static void main(String[] args) {
        BufferedReader in;

        ServerSocket socket;
        Socket newSocket;
        try {
            socket = new ServerSocket(3333);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                newSocket = socket.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                    String info;
                    while ((info = in.readLine()) != null) {
                        System.out.println(info);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
