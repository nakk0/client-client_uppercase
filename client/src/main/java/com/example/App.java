package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientStr client = new ClientStr();
        client.connect();
        client.communicate();
    }
}
