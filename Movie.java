//Nicole, Caleb, Miriam 4/21/26
//This will be our movie class where we will have:
//titles, release date, unique ID code, rotton tomatoes score, do we have the movie or not?

public class Movie
{
	private String title;
	private int releaseDate;
	private int id;
	private int rating;
	private boolean available;
	//For BST
	private Movie left;
	private Movie right;
	
	public Movie(String title0, int released0, int id0, int rating0, boolean available0) {
		title = title0;
		releaseDate = released0;
		id = id0;
		rating = rating0;
		available = available0;

		left = null; 
		right = null;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title0) {
		title = title0;
	}
	
	public int getReleaseDate() 
	{
		return releaseDate;
	}
	public void setReleaseDate(int released0) 
	{
		releaseDate = released0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id0) {
		id = id0;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating0) {
		rating = rating0;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available0) {
		available = available0;
	}
	//For BST:
	public void setRight(Movie right0)
	{
		right = right0;
	}
	public Customer getRight()
	{
		return right;
	}
	public void setLeft(Movie left0)
	{
		left = left0;
	}
	public Customer getLeft()
	{
		return left;
	}
	
}
