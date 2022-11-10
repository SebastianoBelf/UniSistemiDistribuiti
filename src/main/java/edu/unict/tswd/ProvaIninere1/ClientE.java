package edu.unict.tswd.ProvaIninere1;

import edu.unict.tswd.socket.tcp.echoserver.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientE {


    public static void main(String[] args) {
        BufferedReader in;
        BufferedReader inkb;
        PrintWriter out;

        InetAddress addr;
        Socket socket;

        try {
            addr = InetAddress.getByName(null);
            socket = new Socket(addr, 2222);
            System.out.println(socket);


            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            inkb = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(),true);

            String send;
            while(true){
                send = inkb.readLine();
                out.println(send);
                if(send.equals(ServerA.stop)) {break;}

            }
            in.close();
            inkb.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
