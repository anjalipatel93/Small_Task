package com.example.MyTry1;
public class Main { 
	public static void main(String[] args) 
	{
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		
		player1.setPartner(player2);
		player2.setPartner(player1); 
		player1.sendMessage(new Message("Hello, ", 1));
		
		System.out.println("Player1 ProcessID: "+player1.getProcessId()); 
		System.out.println("Player2 ProcessID: "+player2.getProcessId()); 
	}
}