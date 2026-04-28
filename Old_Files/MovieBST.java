// Caleb Causey | 3/2/2026
// Program 4:
//Implement a binary search tree class using linked nodes with the following methods:
// isEmptyTree(), insert(), search(x), traverse(), delete(x), printTree()

public class MovieBST
{
	private Node root;
	public BST()
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
		if (root == null)
		{
			root = x;
		}
		else
		{
			insert2(root, x);
		}
	}
	private void insert2 (Movie t, Movie x)
	{
	//recurssive method for insert
		if (x.getReleaseDate() < t.getReleaseDate())
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
		else
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
	public Movie search(int id)
	{
		return searchr(root, id);
	}
	private Movie searchr(Movie t, int id)
	{
		if (t == null)
		{
			return null;
		}
		else if (id == t.getID())
		{
			return t;
		}
		else if (date < t.getReleaseDate())
		{
			return searchr(t.getLeft(), date);
		}
		else
		{
			return searchr(t.getRight(), date);
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
			traverser(t.getLeft());
			System.out.print(t.getReleaseDate());
			System.out.print(" ");
			traverser(t.getRight());
		}
	}
	public void delete(Movie p)
	{
	//removes the node pointed to by p from the tree T
		if (p.getAvailable == true)
		{
			System.out.println("Can't delete an available movie!");
		else if (p.getAvailable == false && root != null)
		{
			if (p == root)
			{
				root = deleteRoot(root);
			}
			else
			{
				delete2(root, p);
			}
		}
	}
	private Node deleteRoot(Movie t)
	{
	//method for delete
		Node temp = t;
		if (t.getRight() == null && t.getLeft() == null)
		{
			return null;
		}
		else if (t.getLeft() == null)
		{
			t = t.getRight();
			temp.setRight(null);
			return t;
		}
		else if (t.getRight() == null)
		{
			t = t.getLeft();
			temp.setLeft(null);
			return t;
		}
		else
		{
			Movie newRoot = getSuccessor(t.getRight());
			delete(newRoot);
			newRoot.setLeft(t.getLeft());
			newRoot.setRight(t.getRight());
			t.setLeft(null);
			t.setRight(null);
			return newRoot;
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

	private void printTree2(Node tree) 
	{
	//printTree2 method for BST
		if (tree != null) 
		{
			System.out.print(tree.getKey() + " ");
		if (tree.getLeft() != null)
			System.out.print("Left: " + tree.getLeft().getReleaseDate() + " ");
		else
			System.out.print("Left: null ");
		if (tree.getRight() != null)
			System.out.println("Right: " + tree.getRight().getReleaseDate() + " ");
		else
			System.out.println("Right: null ");
		printTree2(tree.getLeft());
		printTree2(tree.getRight());
		}	
	}
}
