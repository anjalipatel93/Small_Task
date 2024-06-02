package com.example.HashMap;
//import java.lang.management.ManagementFactory;
import java.util.HashMap; 
public class MessageBroker { 
	public HashMap<Player, Integer> messageCounts = new HashMap<>(); 
	public void sendMessage(Player sender, Player receiver, String message, int i) 
	{ 
		System.out.println(sender.getName() + " sent message: " + message + ":"+ i);
		if(i==1) {messageCounts.put(sender, 1); messageCounts.put(receiver, 0); }
		else {
	messageCounts.put(sender, messageCounts.get(sender)); }
	if (messageCounts.get(sender) < 10)
	
	 { int count = messageCounts.get(sender) + 1;
	 if (messageCounts.get(receiver)== 0)
	 {sendMessage(receiver, sender, message, 1);}
	 else {
		sendMessage(receiver, sender, message, count); }} } } 

