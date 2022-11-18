package edu.unict.tswd.socket.udp.filestreamer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Server {
    public static void main(String[] a) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/edu/unict/tswd/socket/udp/filestreamer/ciao.txt"));

            System.out.println(in.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
