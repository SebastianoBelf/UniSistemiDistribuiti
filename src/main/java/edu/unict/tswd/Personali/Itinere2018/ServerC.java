package edu.unict.tswd.Personali.Itinere2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerC {
    static String history = "";
    public static String list(String s){
        if(s.equals("SHOW")) return history;
        history = history.concat(s);
        return "OK";
    }
    public static void main(String[] args) {
        BufferedReader in;
        PrintWriter out;
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
                    out = new PrintWriter(newSocket.getOutputStream(),true);
                    String info;
                    while ((info = in.readLine()) != null) {
                        out.println(list(info));
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
