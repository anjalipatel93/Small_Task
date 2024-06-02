package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Player implements Runnable {
    private final String playerId;
    private Player otherPlayer;
    private final BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
    private int messageCounter = 0;
    private int receivedCounter = 0;
    private final int maxMessages;
    private final Object lock = new Object();

    public Player(String playerId, int maxMessages) {
        this.playerId = playerId;
        this.maxMessages = maxMessages;
    }


	public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, this.playerId);
        otherPlayer.receiveMessage(message);
        synchronized (lock) {
            messageCounter++;
            lock.notifyAll();
        }
    }

    public void receiveMessage(Message message) {
        messageQueue.offer(message);
    }

    @Override
    public void run() {
        while (receivedCounter < maxMessages) {
            try {
                Message message = messageQueue.take();
                String newContent = message.getContent() + " " + receivedCounter;
                receivedCounter++;
                sendMessage(newContent);
                System.out.println(newContent);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        //System.out.println(receivedCounter);
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
