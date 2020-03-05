package com;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Client {
    public static void main(String[] args) {
        try {
          
            Socket my_socket = new Socket("localhost", 6666);  //A common endpoint for Server and Client
            DataOutputStream dos = new DataOutputStream(my_socket.getOutputStream());
            dos.writeUTF("This is my first hello world to the server");
            dos.writeUTF("This is my second message");
            dos.flush();
            dos.close();
            my_socket.close();

        } catch (IOException e) {
            
            e.printStackTrace();
        }



        System.out.println( "Hello World!" );
    }
}
