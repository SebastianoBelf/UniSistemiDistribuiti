package edu.unict.tswd.Personali.ServerDepositaRitira;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Integer decodeAndCompute(String str){
        int r = 0;
        if(str.charAt(0) == '-'){
            r = (str.charAt(1) -'0') - (str.charAt(2) -'0') - (str.charAt(3) -'0') - (str.charAt(4) -'0');
        }else{
            r = (str.charAt(1) -'0') + (str.charAt(2) -'0') + (str.charAt(3) -'0') + (str.charAt(4) -'0');
        }
        System.out.println("r:" +r);
        return r;
    }
    public static void main(String[] args){
        ServerSocket socket = null;
        Socket newSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new ServerSocket(4242);
            System.out.println("Connessione Creata");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        while(true){
            try{
                newSocket = socket.accept();
                System.out.println("Connessione Accettata");
                in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                out = new PrintWriter(newSocket.getOutputStream(),true);
                try{
                    String info;
                    while((info = in.readLine())!= null){
                        System.out.println("Ricevuto -> "+info);
                        int r = decodeAndCompute(info);
                        out.println(String.valueOf(r));
                    }
                }catch (Exception ee){
                    System.out.println(ee);
                }

            }catch(Exception ee){
                System.out.println(ee.getMessage());
            }
        }

    }
}
