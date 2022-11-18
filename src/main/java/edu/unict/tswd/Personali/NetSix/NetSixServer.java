package edu.unict.tswd.Personali.NetSix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetSixServer {


    public static void main(String[] args) {
        int PORT = 39999;
        ServerSocket socket = null;
        Socket newSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        OffertaAbbonati offertaAbbonati = new OffertaAbbonati();

        try {
            socket = new ServerSocket(PORT);

            while (true) {
                newSocket = socket.accept();
                System.out.println("Connessione stabilita : \n "+newSocket);
                try { // se elimino questo try quando un client chiude la connessione il server finisce l'esequzione
                    in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                    out = new PrintWriter(newSocket.getOutputStream(),true);

                    String info;
                    while ((info = in.readLine()) != null) {
                        System.out.println("Ho ricevuto il messaggio : "+info);
                        out.println(offertaAbbonati.getDisponibilita(info));
                    }
                    newSocket.close();
                    in.close();
                    out.close();
                } catch (IOException ea) {
                    System.out.println(ea);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
