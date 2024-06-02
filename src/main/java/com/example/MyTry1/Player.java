package com.example.MyTry1;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Player { private String name; private int messageCounter = 0; 
private Player partner; public Player(String name) { this.name = name; } 
public void setPartner(Player partner) { this.partner = partner; } 

public void sendMessage(Message message) 
{
	System.out.println(name + " sent: " + message);
	partner.receiveMessage(message);
	messageCounter++;
	if (messageCounter == 10) {
		System.exit(0); // Terminate the program after 10 messages
	}
} 
public void receiveMessage(Message message) 
{ 
	System.out.println(name + " received: " + message);
	if (message.getCounter() < 10) {
		sendMessage(new Message(message.toString(), message.getCounter() + 1));
	} 
} 

public String getProcessId() {
    RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    String name = runtime.getName();
    return name.split("@")[0]; // PID is before the '@' symbol
}

}