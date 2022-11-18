package edu.unict.tswd.Personali.Itinere2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {


    public static void main(String[] args){

        Socket socket = null;
        PrintWriter outs;
        BufferedReader in;
        BufferedReader sockin;
        InetAddress inet = null;
        try {
            inet = InetAddress.getByName(null);

            socket = new Socket(inet,3333);

            outs = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(System.in));
            sockin = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String info = null;
            String recv = null;
            while((info = in.readLine()) != null){
                outs.println(info);
                recv = sockin.readLine();
                System.out.println("Ricevuto -> "+recv);
            }

            socket.close();
            outs.close();
            in.close();

        }catch(Exception e){
            System.out.println(e);
        }


    }

}
