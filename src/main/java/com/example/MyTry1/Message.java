package com.example.MyTry1;

public class Message { private String content; 
private int counter; 
public Message(String content, int counter) 
{ this.content = content; this.counter = counter; } 
public int getCounter() {
    return counter;
}

@Override public String toString() 
{ return content + counter; } 
}	