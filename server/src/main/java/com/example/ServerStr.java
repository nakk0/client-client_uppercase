package com.example;
import java.io.*;
import java.net.*;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String receivedString = null;
    String modifiedString = null;
    BufferedReader in;
    DataOutputStream out;
    
    public Socket pause(){
        try{
            System.out.println("server started and executing");
            server = new ServerSocket(42069);
            client = server.accept();
            server.close();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());                        
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error during server instance");
            System.exit(1);
        }
        return client;
    }

    public void communicate(){
        try{
            System.out.println("welcome client, write a phrase and I'll make it upper case");
            receivedString = in.readLine();
            System.out.println("string received from client: "+receivedString);
            modifiedString = receivedString.toUpperCase();
            System.out.println("sending modified string to client");
            out.writeBytes(modifiedString+'\n');
            System.out.println("server: finished. goodnight!");
            client.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
