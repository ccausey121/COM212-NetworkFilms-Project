//Customer:
//A class with identification and methods to change view info
/// Caleb Causey


public class Customer
{
	private String name;
	private String email;
	private int card;
	private Node next;
	
	public Node(String name0, String email0, int ssn0) 
	{
		name = name0;
		email = email0;
		card = card0;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name0) 
	{
		name = name0;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email0) 
	{
		email = email0;
	}
	public void setCard(int card0) 
	{
		card = card0;
	}
	public int getCard() 
	{
		return card;
	}
	public void setNext(Node next0)
	{
		next = next0;
	}
	public Node getNext()
	{
		return next;
	}
	public int getKey()
	{
		return card %10000;
	}
}
