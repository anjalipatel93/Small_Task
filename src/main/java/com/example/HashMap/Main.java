package com.example.HashMap;

import java.lang.management.ManagementFactory;

public class Main { 
	public static void main(String[] args) { 
	// Print the Process ID (PID) of the current Java process 
	String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0]; System.out.println("PID: " + pid); 
	Player player1 = new Player("Player 1"); Player player2 = new Player("Player 2"); 
	MessageBroker broker = new MessageBroker(); broker.sendMessage(player1, player2, "Hello", 1); } 
	
	}
