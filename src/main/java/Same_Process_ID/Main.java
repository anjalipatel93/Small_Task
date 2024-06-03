package Same_Process_ID;
public class Main { 
	public static void main(String[] args) 
	{ 
		
		// Creating objects of player Class
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		
		//Setting partner to each other
		player1.setPartner(player2);
		player2.setPartner(player1); 
		
		//Player1 initiate the conversation
		player1.sendMessage(new Message("Hello, ", 1));
		
		//Printing the process id of both player
		System.out.println("Player1 ProcessID: "+player1.getProcessId()); 
		System.out.println("Player2 ProcessID: "+player2.getProcessId()); 
	}
}