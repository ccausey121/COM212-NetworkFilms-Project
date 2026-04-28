// Caleb Causey | 3/2/2026
// Program 4:
//Implement a binary search tree class using linked nodes with the following methods:
// isEmptyTree(), insert(), search(x), traverse(), delete(x), printTree()

public class MovieBST {
	private Movie movieRoot;
    private Movie newRoot;

	public MovieBST() {
		movieRoot = null;
        newRoot = null;
	}	
	public boolean isMovieTreeEmpty()
	{
	//returns true if T is empty and false if it is not
		return movieRoot == null;
	}

	public void insertMovie(Movie x)
	{
	//the node pointed to by p added in
		if (movieRoot == null) //if the tree is empty, the new movie is the root
		{
			movieRoot = x;
		}
		else
		{
			insertMovie2(movieRoot, x); //otherwise recursive function
		}
	}

	private void insertMovie2 (Movie t, Movie x)
	{
	//recurssive method for insert
		if (x.getReleaseDate() < t.getReleaseDate()) //compare release dates then, go left 
		{
			if (t.getLeft() == null)
			{
				t.setLeft(x);
			}
			else
			{
				insertMovie2(t.getLeft(), x);
			}
		}
		else //release dates compares, need to go right
		{
			if (t.getRight() == null)
			{
				t.setRight(x);
			}
			else
			{
				insertMovie2(t.getRight(), x);
			}
		}
	}

	public Movie searchMovie(int releaseDate)
	{
		return searchMovie2(movieRoot, releaseDate);
	}
	private Movie searchMovie2(Movie t, int releaseDate)
	{
		if (t == null) 
		{
			return null;
		}
		else if (releaseDate == t.getReleaseDate())
		{
			return t; //found the movie 
		}
		else if (releaseDate < t.getReleaseDate())
		{
			return searchMovie2(t.getLeft(), releaseDate); //search left 
		}
		else
		{
			return searchMovie2(t.getRight(), releaseDate); //search right 
		}
	}

	public void traverseMovie()
	{
	//prints the contents of T in order
		traverseMovie2(movieRoot);
		System.out.println();
	}

	private void traverseMovie2(Movie t)
	{
	//recurssive method for traverse
		if (t != null)
		{
			traverseMovie2(t.getLeft()); //left half
			System.out.print(t.getReleaseDate() + " "); //print current movies
			System.out.print(t.getTitle());
			System.out.println();
			traverseMovie2(t.getRight()); //right half of tree
		} else {
			return;
		}
	}
	public void printMovies() { //prints movies by release date order
        traverseMovie();
    }

	public Movie deleteMovie(Movie p)
	{
	//removes the node pointed to by p from the tree T
		if (p == null) { //does movie exist?
			System.out.println("Movie not found");
			return null;
		} else if (p.isAvailable()) { //cannot delete available ones
			System.out.println("Can't delete an available movie!");
			return null;
		} else {
			if (p.getReleaseDate() == movieRoot.getReleaseDate()){
				movieRoot = deleteMovieRoot(movieRoot);
			} else {
				deleteMovie2(movieRoot, p); //delete with release date 
			}
			return p;
		}
	}

	private Movie deleteMovieRoot(Movie t)
	{
	//method for delete
		Movie temp = t;
		if (t.getRight() == null && t.getLeft() == null)
		{
			return null;
			
		} else if (t.getLeft() == null) {
			t = t.getRight();
			temp.setRight(null);
			return t;

		} else if (t.getRight() == null) {
		
			t = t.getLeft();
			temp.setLeft(null);
			return t;

		} else {
			
			newRoot = getMovieSuccessor(t.getRight());
			deleteMovie2(t, newRoot);

			newRoot.setLeft(t.getLeft());
			newRoot.setRight(t.getRight());

			t.setLeft(null);
			t.setRight(null);

			return newRoot;
		}
	}

	public void deleteMovie2(Movie t, Movie p) {
		//need for deleting movies that are not the root of the tree
		//cases would be no childre, one child, or two children.  
		if (t.getLeft() != null && p.getReleaseDate() < t.getReleaseDate()) {
			if (p.getReleaseDate() == t.getLeft().getReleaseDate()) {
				t.setLeft(deleteMovieRoot(t.getLeft()));
			} else {
				deleteMovie2(t.getLeft(), p);
			}
		} else if (t.getRight() != null && p.getReleaseDate() > t.getReleaseDate()) {
			if (p.getReleaseDate() == t.getRight().getReleaseDate()) {
				t.setRight(deleteMovieRoot(t.getRight()));
			} else {
				deleteMovie2(t.getRight(), p);
			}
		}
	}

	private Movie getMovieSuccessor(Movie t)
	{
	//returns the successor for deleteRoot
		if (t.getLeft() == null)
		{
			return t;
		}
		else
		{
			return getMovieSuccessor(t.getLeft());
		}
	}

	public void printMovieTree() 
	{
	//printTree method for BST
		printMovieTree2(movieRoot);
		System.out.println();
	}

	private void printMovieTree2(Movie tree) 
	{
	//printTree2 method for BST
		if (tree != null) 
		{
			System.out.print(tree.getReleaseDate() + " ");
			System.out.print(tree.getTitle() + " ");
			
			if (tree.getLeft() != null) {
				System.out.print("Left: " + tree.getLeft().getReleaseDate() + " ");
			} else {
				System.out.print("Left: null ");
			}
			if (tree.getRight() != null) {
				System.out.println("Right: " + tree.getRight().getReleaseDate() + " ");
			} else
				System.out.println("Right: null ");
			
		printMovieTree2(tree.getLeft());
		printMovieTree2(tree.getRight());
		}	
	}	
}