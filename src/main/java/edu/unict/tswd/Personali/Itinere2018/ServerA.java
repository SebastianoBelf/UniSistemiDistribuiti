package edu.unict.tswd.Personali.Itinere2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerA {
    public static void main(String[] a){
        BufferedReader in;
        Socket newSocket = null;
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(3333);

        }catch(Exception e){
            System.out.println(e);
        }
        while(true) {
            try {

                newSocket = socket.accept();
                System.out.println(newSocket);
                try {
                    in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));

                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
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
