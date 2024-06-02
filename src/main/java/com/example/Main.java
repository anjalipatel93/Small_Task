package com.example;
//import com.example.*;
//import com.example.Player.java;

public class Main {
    public static void main(String[] args) {
        int maxMessages = 10;

        Player player1 = new Player("Player1", maxMessages);
        Player player2 = new Player("Player2", maxMessages);

        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        player1.sendMessage("Message from Player1");

         while (player1.getMessageCounter() < maxMessages) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        thread1.interrupt();
        thread2.interrupt();
    }
}
