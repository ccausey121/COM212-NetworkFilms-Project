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
	
	public Movie(String title0, int released0, int id0, int rating0, boolean available0) {
		title = title0;
		releaseDate = released0;
		id = id0;
		rating = rating0;
		available = available0;
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
	public void setReleaseDate(int release0) 
	{
		releaseDate = released;
	}

	public int getID() {
		return id;
	}

	public void setID(int id0) {
		id = id0;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating0) {
		rating = rating0;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available0) {
		available = available0;
	}
	
}
