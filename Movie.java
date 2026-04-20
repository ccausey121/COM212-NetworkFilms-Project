//Movie:
//A class with identification and methods to change view info
//Caleb Causey

public class Movie
{
	private String title;
	private int released;
	private int id;
	private int tomatoes;
	private boolean availability;
	private Node next;
	
	public Node(String title0, int released0, int id0, int tomatoes0, boolean availability0;) 
	{
		title = title0;
		released = released0;
		id = id0;
		tomatoes = tomatoes0;
		availability = availability0;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title0) 
	{
		title = title0;
	}
	public void setReleased(int released0) 
	{
		released = released0;
	}
	public int getReleased() 
	{
		return released;
	}
	public void setNext(Node next0)
	{
		next = next0;
	}
	public Node getNext()
	{
		return next;
	}
}
