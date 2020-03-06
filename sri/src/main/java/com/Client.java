package com;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket my_socket = null;
        Scanner scn = null;
        try {
            scn = new Scanner(System.in); 
            my_socket = new Socket("localhost", 6666);  //A common endpoint for Server and Client
            DataOutputStream dos = new DataOutputStream(my_socket.getOutputStream());
            DataInputStream dis = new DataInputStream(my_socket.getInputStream());
            String toSend = null;
            while(true){

                System.out.println(dis.readUTF());
                if(scn.hasNextLine())
                     toSend = scn.nextLine();
                dos.writeUTF(toSend);

                if(toSend.equals("Exit")) 
                { 
                    System.out.println("Closing this connection : " + my_socket); 
                    my_socket.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                
            }   
            dos.flush();   //All the bytes remaining in the TCP will be sent through the channel
            dos.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {   
            my_socket.close();
            scn.close();
        
        }

    
    }
}
