package com.example;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // ServerStr server = new ServerStr();
        // server.pause();
        // server.communicate();

        try{
            System.out.println("server started and executing");
            ServerSocket server = new ServerSocket(3000);
            Socket client = server.accept();
            server.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());   
            
            System.out.println("welcome client, write a phrase and I'll make it upper case");
            String receivedString = in.readLine();
            System.out.println("string received from client: "+receivedString);
            String modifiedString = receivedString.toUpperCase();
            System.out.println("sending modified string to client");
            out.writeBytes(modifiedString+'\n');
            System.out.println("server: finished. goodnight!");
            client.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error during server instance");
            System.exit(1);
        }
    }
}
