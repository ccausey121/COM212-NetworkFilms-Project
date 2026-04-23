// Customer:
// A class with identification and methods to change view info

public class Customer
{
	private String name;
	private String email;
	private int card; //going to be 4 digits 

	private Customer left;
	private Customer right;
	
	private Wishlist wishlist;
	
	public Customer(String name0, String email0, int card0) 
	{
		wishlist = new Wishlist(); //this is creating an empty wishlist that we will add movies into 
		name = name0;
		email = email0;
		card = card0;

		left = null; //nothing to start
		right = null; 
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

	public Wishlist getWishlist() {
		return wishlist
	}
	// For BST:
	public void setRight(Customer right0)
	{
		right = right0;
	}
	public Customer getRight()
	{
		return right;
	}
	public void setLeft(Customer left0)
	{
		left = left0;
	}
	public Customer getLeft()
	{
		return left;
	}
}
