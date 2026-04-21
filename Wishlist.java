// Caleb Causey | 4/21/2026
// Wishlist:
// The customer's wish-list of what to watch next (up to twenty movies) with the following requirements:
// - Access the next movie in constant time (if it is marked as no longer available, a note should be displayed, 
// the movie deleted, and the next movie shown).
// - After access, give an option to delete (constant runtime).
// - Add new movies to the back of the list (constant runtime).

public class Wishlist
{
	private Movie q[] = new Movie[20];
	private int n;
	private int front;
	public Wishlist()
	{
		n = 0;
		front = 0;
	}
	
	public Movie front()
	{
	//returns the first node of Q
		return q[front];
	}
	public Movie dequeue()
	{
	//returns and removes the first node of Q
		int temp = front;
		front = (front + 1) %20;
		n--;
		return q[temp];
	}
	public void enqueue(Movie x)
	{
	//x added as the last element
		int tail = (front + n) %20;
		q[tail] = x;
		n++;
	}
	public boolean isEmpty()
	{
	//returns true if Q is empty and false if it is not
		return n==0;
	}
	public void printQueue() 
	{
	// printQueue method for QueueA
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