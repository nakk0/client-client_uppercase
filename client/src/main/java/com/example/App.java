package com.example;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        try{
            Socket socket = new Socket("localhost", 3000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner inputtext = new Scanner(System.in);
            System.out.println("Insert text to convert");
            String linetoconvert = inputtext.nextLine();

            out.writeBytes(linetoconvert + " \n");

            String returnedString = in.readLine();

            System.out.println("received: " + returnedString);
            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
