// Wishlist:
// The customer's wish-list of what to watch next (up to twenty movies) with the following requirements:
// - Access the next movie in constant time (if it is marked as no longer available, a note should be displayed, 
// the movie deleted, and the next movie shown).
// - After access, give an option to delete (constant runtime).
// - Add new movies to the back of the list (constant runtime).

public class Wishlist
{
	private Movie q[] = new Movie[20]; // we want to change this line so its not automatically 20 we want it to be empty to start
	private int n;
	private int front;

	
	public Wishlist()
	{
		n = 0;
		front = 0;
		
	}
	
	public Movie front()
	{
	//returns the first movie of wishlist
	//check if empty and then check what is in the queue and return the front
		return q[front];
	}
	
	public Movie dequeue()
	{
	//returns and removes the first movie of wishlist
		//check if it is empty first 
		int temp = front;
		front = (front + 1) % 20;
		n--;
		return q[temp]; 
	}
	
	public void enqueue(Movie x)
	{
	//x added as the last element
	// we need to check if the wihlist is full first and then proceed:
		int tail = (front + n) % 20; //this would be the back of the queue
		q[tail] = x;
		n++;
	}
	
	public boolean isEmpty()
	{
	//returns true if wishlist is empty and false if it is not
		return n == 0;
	}
	
	public void printWishlist() //we do not have a get Key method so we need to adjust
	// we want to print the movies in the list
	//check if it is empty, if not keep going and print

	{
	// printWishlist method for Wishlist
		int tail = (front + n) % 20;
		System.out.println(front);
		System.out.println(tail);
		if (front <= tail)
			for(int i = front; i < tail; i++) 
				System.out.println(q[i].getKey());
		else 
		{
			for(int i = front; i < 20; i++) 
				System.out.println(q[i].getKey());          
			for(int i = 0; i < tail; i++) 
				System.out.println(q[i].getKey());
		}          
	}
}
