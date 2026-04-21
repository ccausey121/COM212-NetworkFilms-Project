// Customer:
// A class with identification and methods to change view info
/// Caleb Causey

public class Customer
{
	private String name;
	private String email;
	private int card;
	private Node next;
	private Wishlist wishlist = new Wishlist[20];
	public Customer(String name0, String email0, int ssn0) 
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

	// For BST:
	
	public void setRight(Node right0)
	{
		right = right0;
	}
	public Node getRight()
	{
		return right;
	}
	public void setLeft(Node left0)
	{
		left = left0;
	}
	public Node getLeft()
	{
		return left;
	}
}
