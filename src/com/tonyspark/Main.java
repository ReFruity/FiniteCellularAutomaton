package com.tonyspark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args) {
        try
        {
            ServerSocket serverSocket = new ServerSocket(440);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Board board = new Board(2);

            board.paintBlack(0, 0);
            board.paintBlack(1, 1);

            board.associateConfigurations(new int[]{1,0,0,1}, new int[]{1,1,1,1});
            board.associateConfigurations(new int[]{1,1,1,1}, new int[]{0,1,0,0});
            board.associateConfigurations(new int[]{0,1,0,0}, new int[]{0,0,1,1});
            board.associateConfigurations(new int[]{0,0,1,1}, new int[]{1,0,0,0});
            board.associateConfigurations(new int[]{1,0,0,0}, new int[]{1,1,1,1});

            for(int i = 0; i < 10; i++) {
                out.println(board.toString());
                board.step();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
