package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket my_client_socket = null;
        
        while (true) {
            try {
                
                
                my_client_socket = ss.accept();  //A common endpoint for Server and Client
                DataInputStream dis = new DataInputStream(my_client_socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(my_client_socket.getOutputStream());
                
                Thread t = new ClientHandler(my_client_socket,dis,dos);
                t.start();
                System.out.println("My new customer thread Id is: "+t.getId()+"and name is "+t.getName());
                
            } catch (IOException e) {
                ss.close();
                my_client_socket.close();  //You get to close this if the socket is declared outside main
                e.printStackTrace();
            }
        }
        
    }
}
