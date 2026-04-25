// Customer:
// A class with identification and methods to change view info

public class Customer
{
	//For Identification
	private String name;
	private String email;
	private int card; //going to be 4 digits 
	
	//For BST
	private Customer left;
	private Customer right;
	
	//For Wishlist
	private Movie wishlist[] = new Movie[20];
	private int n;
	private int front;
	
	public Customer(String name0, String email0, int card0) 
	{
		name = name0;
		email = email0;
		card = card0;

		left = null; //nothing to start
		right = null;
		
		n = 0;
		front = 0;
	}
	//------------------------------------------------
	//For Identification
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

	//-----------------------------------------------------
	//For Wishlist
	public Movie front()
	{
	//returns the first movie of wishlist
	//check if empty and then check what is in the queue and return the front
		if (n == 0)
		{
			System.out.println("You have an empty wishlist!");
			return null;
		}
		else
		{
			System.out.println("Next to watch: " + wishlist[front].getTitle());
			return wishlist[front];
		}
	}
	
	public void watchMovie()
	{
	//returns and removes the first movie of wishlist
		//check if it is empty first
		if (n == 0)
		{
			System.out.println("You have an empty wishlist!");
		}
		else
		{
			Movie temp = wishlist[front];
			front = (front + 1) % 20;
			n--;
			System.out.println("You have watched " + temp.getTitle() + "!");
		}
	}
	
	public void addMovie(Movie x)
	{
	//x added as the last element
	// we need to check if the wihlist is full first and then proceed:
		if (n == 20)
		{
			System.out.println("You have a full wishlist!");
		}
		else
		{
			int tail = (front + n) % 20; //this would be the back of the queue
			wishlist[tail] = x;
			n++;
			System.out.println(x.getTitle() + " has been added!");
		}
	}
	
	public boolean isWishlistEmpty()
	{
	//returns true if wishlist is empty and false if it is not
		System.out.println("You have an empty wishlist!");
		return n == 0;
	}
	
	public void printWishlist()
	//check if it is empty, if not keep going and print
	{
	// printWishlist method for Wishlist
		int tail = (front + n) % 20;
		//System.out.println(front);
		//System.out.println(tail);
		if (front <= tail)
			for(int i = front; i < tail; i++) 
				System.out.println(wishlist[i].getID());
		else 
		{
			for(int i = front; i < 20; i++) 
				System.out.println(wishlist[i].getID());          
			for(int i = 0; i < tail; i++) 
				System.out.println(wishlist[i].getID());
		}          
	}

	
	//-----------------------------------------------------
	//For BST:
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
