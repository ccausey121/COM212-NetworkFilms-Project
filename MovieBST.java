// Caleb Causey | 3/2/2026
// Program 4:
//Implement a binary search tree class using linked nodes with the following methods:
// isEmptyTree(), insert(), search(x), traverse(), delete(x), printTree()

public class MovieBST
{
	private Movie root;
	private Movie newRoot;
	
	public MovieBST()
	{
		root = null;
	}
	
	public boolean isEmptyTree()
	{
	//returns true if T is empty and false if it is not
		return root == null;
	}
	
	public void insert(Movie x)
	{
	//the node pointed to by p added in
		if (root == null) //if the tree is empty, the new movie is the root
		{
			root = x;
		}
		else
		{
			insert2(root, x); //otherwise recursive function
		}
	}
	
	private void insert2 (Movie t, Movie x)
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
				insert2(t.getLeft(), x);
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
				insert2(t.getRight(), x);
			}
		}
	}
	
	public Movie search(int releaseDate)
	{
		return searchr(root, releaseDate);
	}
	private Movie searchr(Movie t, int releaseDate)
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
			return searchr(t.getLeft(), releaseDate); //search left 
		}
		else
		{
			return searchr(t.getRight(), releaseDate); //search right 
		}
	}
	
	public void traverse()
	{
	//prints the contents of T in order
		traverser(root);
		System.out.println();
	}
	
	private void traverser(Movie t)
	{
	//recurssive method for traverse
		if (t != null)
		{
			traverser(t.getLeft()); //left half
			System.out.print(t.getReleaseDate() + " "); //print current movies
			System.out.print(t.getTitle());
			System.out.println();
			traverser(t.getRight()); //right half of tree
		} else {
			return;
		}
	}
	
	public Movie delete(Movie p)
	{
	//removes the node pointed to by p from the tree T
		if (p == null) { //does movie exist?
			System.out.println("Movie not found");
			return null;
		} else if (p.isAvailable()) { //cannot delete available ones
			System.out.println("Can't delete an available movie!");
			return null;
		} else {
			if (p == root){
				root = deleteRoot(root);
			} else {
				delete2(root, p); //delete with release date 
			}
			return p;
		}
	}
	
	private Movie deleteRoot(Movie t)
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
			
			newRoot = getSuccessor(t.getRight());
			delete(newRoot);

			newRoot.setLeft(t.getLeft());
			newRoot.setRight(t.getRight());

			t.setLeft(null);
			t.setRight(null);

			return newRoot;
		}
	}

	public void delete2(Movie t, Movie p) {
		//need for deleting movies that are not the root of the tree
		//cases would be no childre, one child, or two children.  
		if (t.getLeft() != null && p.getReleaseDate() < t.getReleaseDate()) {
			if (p.getReleaseDate() == t.getLeft().getReleaseDate()) {
				t.setLeft(deleteRoot(t.getLeft()));
			} else {
				delete2(t.getLeft(), p);
			}
		} else if (t.getRight() != null && p.getReleaseDate() > t.getReleaseDate()) {
			if (p.getReleaseDate() == t.getRight().getReleaseDate()) {
				t.setRight(deleteRoot(t.getRight()));
			} else {
				delete2(t.getRight(), p);
			}
		}
	}
	
	private Movie getSuccessor(Movie t)
	{
	//returns the successor for deleteRoot
		if (t.getLeft() == null)
		{
			return t;
		}
		else
		{
			return getSuccessor(t.getLeft());
		}
	}
	
	public void printTree() 
	{
	//printTree method for BST
		printTree2(root);
		System.out.println();
	}

	private void printTree2(Movie tree) 
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
			
		printTree2(tree.getLeft());
		printTree2(tree.getRight());
		}	
	}
}
	
