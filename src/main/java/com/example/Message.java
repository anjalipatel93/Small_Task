package com.example;

public class Message {
    private final String content;
    private final String senderId;

    public Message(String content, String senderId) {
        this.content = content;
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public String getSenderId() {
        return senderId;
    }


}
