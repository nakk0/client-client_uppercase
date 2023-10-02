package com.example;
import java.io.*;
import java.net.*;

public class Client {
    String serverName = "serverName";
    int serverPort = 42069;
    DataInputStream in;
    DataOutputStream out;

    protected Socket connect () throws IOException{
        Socket socket = new Socket(serverName, serverPort);
        
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        
        return socket;
    }
}
