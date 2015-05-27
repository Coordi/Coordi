package com.example.jeonsoomin.coordi0;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Jeon SooMin on 2015-05-21.
 */
public class SocClient implements Runnable{
    private Socket socket;
    private String ServerIP = "192.168.123.1";
    PrintWriter outToServer = null;
    BufferedReader in = null;
    public void run()
    {
        try
        {
            socket = new Socket("192.168.123.1", 4444);
            outToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(Exception e)
        {
            System.out.print("Whoops! It didn't work!:");
            System.out.print(e.getLocalizedMessage());
            System.out.print("\n");
        }
    }

    public void send(String s)
    {
         outToServer.print(s + "\n");
         outToServer.flush();
        //Create BufferedReader object for receiving messages from server.
        try {
            String input = in.readLine();
            System.out.println("Input: " + input);
            Log.d("Server Send", in.readLine());
        }
        catch (Exception e) {
            System.out.print(e.toString());
        }
    }

}