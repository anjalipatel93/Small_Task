package Same_Process_ID;

public class Message 
{ 
	private String content; 
    private int counter; 
    
    public Message(String content, int counter) 
    { 
    	this.content = content; this.counter = counter;
    }
    
    public int getCounter() 
    {
    return counter;
    }
    
    /*
     Overrides the toString method to provide a string representation of the message.
     @return The content string concatenated with the counter value.
     */
    @Override public String toString() 
    { 
    	return content + counter; 
    } 
}	