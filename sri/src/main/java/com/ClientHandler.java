package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket channel;

    public ClientHandler(Socket channel, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.channel = channel;
    }

    // All the server handling of any particular client will go here
    @Override
    public void run() {

        try {
            this.dos.writeUTF("Welcome to the website"+ channel);
        } catch (Exception e) {
            //TODO: handle exception
        }
                
        while(true){
            try {
                
                String received = dis.readUTF();

                /*
                Stopping a server from client is a very bad idea 
                as this fucks up comm with remaining clients
                */
                if(received.equals("stop"))   //Client interrupter
                {
                    System.out.println("Stopping server as client requested");
                    break;
                }

                switch (received) {
                    case "Green":
                        dos.writeUTF("You sent green");
                        break;
                    case "Yellow":    
                        dos.writeUTF("You sent yellow");
                        break;
                    case "Red":    
                        dos.writeUTF("You sent red");
                        break;
                    default:
                        dos.writeUTF("Echo message from server:"+ received); // Send back in the default case 
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    try {
        this.dis.close();  // Close resources if the loop ends
        this.dos.close();
    } catch (Exception e) {
        //TODO: handle exception
    }

    }
    



}
