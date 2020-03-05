package com;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket my_socket = ss.accept();  //A common endpoint for Server and Client
            DataInputStream dis = new DataInputStream(my_socket.getInputStream());
            String client_message = dis.readUTF();
            System.out.println("Message from client: "+ client_message);
            ss.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }



        System.out.println( "Hello World!" );
    }
}
