package com.example;
import java.io.*;
import java.net.*;

public class ClientStr {
    String serverName = "localhost";
    int serverPort = 42069;
    Socket mySocket;
    BufferedReader keyboard;
    String userString;
    String receivedString;
    DataOutputStream out;
    BufferedReader in;

    public Socket connect(){
        System.out.println("Client started.");
        try{
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            mySocket = new Socket(serverName, serverPort);
            out = new DataOutputStream(mySocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        }catch(UnknownHostException e){
            System.err.println("Unknown host");
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error during connection");
            System.exit(1);
        }
        return mySocket;
    }

    public void communicate(){
        try{
            System.out.println("insert string to transmit to server: "+'\n');
            String userString = keyboard.readLine();
            System.out.println("sending string to server and waiting...");
            out.writeBytes(userString + '\n');
            receivedString=in.readLine();
            System.out.println("server answer " + '\n' + receivedString);
            System.out.println("client: termiates elaboration and closes connection");
            mySocket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server!");
            System.exit(1);
        }
    }
}
