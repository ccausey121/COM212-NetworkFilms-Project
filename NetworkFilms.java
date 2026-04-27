/* Nicole, Caleb, Miriam 4/30/26
This class will have a cutomer BST by credit card numbers
The Movie Heap by Rotten Tomatoes score, and the movie BST by release date
*/

public class NetworkFilms {

    //BST for customer record
	private Customer customerRoot;

    //Movie Heap by rating
    private Movie movieHeap[];
    private int heapN;

    //Movie BST by release date
    private Movie movieRoot;
    private Movie newRoot;

    //Movie Hash with IDs
    private Movie movieHash[];
    private int hashSize;
    private int hashN;

    public NetworkFilms() {
        //everything has to be empty to start
        customerRoot = null;

        movieHeap = new Movie[255]; //max of 255 available movies
        heapN = 0; 

        movieRoot = null;
        newRoot = null;

        hashSize = 255;
        movieHash = new Movie[hashSize];
        hashN = 0;

    }

//Customer record BST

public void insertCustomer(Customer c) // inserting customer
	{
		customerRoot = insertCustomer2(customerRoot, c);
	}

	private Customer insertCustomer2(Customer root, Customer c)
	{
		if (root == null) {
			return c;
        }

		if (c.getCard() < root.getCard()) {
			root.setLeft(insertCustomer2(root.getLeft(), c));
            //went to left if smaller

        } else if (c.getCard() > root.getCard()) {
			root.setRight(insertCustomer2(root.getRight(), c));
            //went to right if bigger 
        }
		return root;
	}

	public Customer searchCustomer(int card) // search for card using BST
	{
		return searchCustomer2(customerRoot, card);
	}

	private Customer searchCustomer2(Customer root, int card)
	{
		if (root == null || root.getCard() == card) {
			return root; 
        }

		if (card < root.getCard()) { //if card is smaller search left
			return searchCustomer2(root.getLeft(), card);
        } else {
            return searchCustomer2(root.getRight(), card); //if card is bigger search right
        }
	}

	public void updateCustomerName(int card, String newName) // updating 
	{
		Customer c = searchCustomer(card);

		if (c != null) {
			c.setName(newName);
        } else {
			System.out.println("Customer not found");
        }
	}

	public void updateCustomerEmail(int card, String newEmail)
	{
		Customer c = searchCustomer(card);

		if (c != null) {
			c.setEmail(newEmail);
        } else {
			System.out.println("Customer not found");
        }
	}

	public void updateCustomerCard(int oldCard, int newCard)
	{
		Customer c = searchCustomer(oldCard);

		if (c != null)
		{
			deleteCustomer(oldCard); // delete old card here 
			c.setCard(newCard); //change the card number
			insertCustomer(c); //reinsert in correct position
		} else {
			System.out.println("Customer not found");
        }
	}
	public void deleteCustomer(int card)
	{
		customerRoot = deleteCustomer2(customerRoot, card);
	}
	private Customer deleteCustomer2(Customer root, int card)
	{
		if (root == null) {
			return null;
        }

		if (card < root.getCard()) {
			root.setLeft(deleteCustomer2(root.getLeft(), card));

        } else if (card > root.getCard()) {
			root.setRight(deleteCustomer2(root.getRight(), card));

        } else
		{
			if (root.getLeft() == null) {
				return root.getRight(); //no left child
            }
			else if (root.getRight() == null) {
				return root.getLeft(); //no right child
            }
			Customer successor = getCustomerSuccessor(root.getRight());
			root.setCard(successor.getCard());
			root.setRight(deleteCustomer2(root.getRight(), successor.getCard()));
		}

		return root;
	}

	private Customer getCustomerSuccessor(Customer t)
	{
        if (t.getLeft() == null) {
            return t;
        } else {
            return getCustomerSuccessor(t.getLeft());
        }
	}
	public void printCustomerBST() {
		printCustomerBST2(customerRoot);
		System.out.println();
	}

	private void printCustomerBST2(Customer c) {
		if (c != null) {
			printCustomerBST2(c.getLeft());
			System.out.println(c.getCard() + " " + c.getName());
			printCustomerBST2(c.getRight());
		}
	}
//Movie Heap 

    public Movie findMovieMin() {
        //for this we need to return the movie with the lowest rated score (which will be the root of the heap)
        if (heapN == 0) {
            return null; //if the list of movies is empty return null
        } else {
            return movieHeap[0]; //if not return the root of the tree (first index)
        }
    }

    public Movie deleteMovieMin() {
        // we want to delete the min node and return it 
        //we need to remove first index and subtract n-1
        //this requires swapping the positions of the items in the heap
        if (heapN == 0) {
            return null; //if the heap is empty we cannot delete anything 
        }

        Movie temp = movieHeap[0]; //we want to save the root because we will return later

        movieHeap[0] = movieHeap[heapN-1]; //moving the last movie to the first spot in heap
        movieHeap[heapN-1] = null; //removing the last one in the heap
        heapN = heapN - 1; 

        int i = 0; //starting at the first index 
        while (2 * i + 1 < heapN) { //while there is a left child 
            int left = 2 * i + 1; //left child index 
            int right = 2 * i + 2; //right child index 

            int small = left; //this will assume the left child is the smaller one
            //now we need to check if there is a right and that is smaller 
            if ( right < heapN && movieHeap[right].getRating() < movieHeap[left].getRating()) {
                small = right;  //right would now be the smaller child
            } else if (movieHeap[i].getRating() <= movieHeap[small].getRating()) {
                break; //the current one is actually smaller than the children so leave as is
            }

            Movie current = movieHeap[i]; //saving current node
            movieHeap[i] = movieHeap[small]; //swapping it with the smaller child
            movieHeap[small] = current; //making the swapped one the new current

            i = small; //moving down the child index 
        }
        return temp; //returning the movie that we removed 
    }

    public void insertMovieHeap(Movie x) {
        //we want to add x if the movie is available which means we need to check that 
        if (heapN == 255) { //if the heap is full we cannot add anything
            System.out.println("FULL!");
            return;
        }

        if (!x.isAvailable()) {
            return;
        }

        movieHeap[heapN] = x; //inserting x at the end of the heap
        int i = heapN; //this is the index where we added the movie 
        heapN = heapN + 1; //increasing the size of the list

        while(i > 0) { //while the movie is not at the root
            int parent = (i - 1) / 2; //fidn the index of the parent 
            if (movieHeap[parent].getRating() <= movieHeap[i].getRating()) { //if the parent is smaller stop
                return;
            }

            Movie temp = movieHeap[i]; //save the current
            movieHeap[i] = movieHeap[parent]; //swap the current with the parent 
            movieHeap[parent] = temp; 

            i = parent; // change position of the parent 
        }
    }

    public boolean isMovieEmpty() {
        return heapN == 0; //checking if the heat is empty 
    }

    public void printHeap() { 
        if (heapN == 0) {
            System.out.println("EMPTY"); //nothing is in the heap
            return;
        }
        for (int i = 0; i < heapN; i++) { //printing movies in order of score
            System.out.print(movieHeap[i].getTitle() + ": " + movieHeap[i].getRating() + ", ");
        }
        System.out.println();

    }
//Movie BST

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
//Hashing 

    public int hash1 (int id) { //finding where the movie needs to go
        return id % hashSize;
    }

    public Movie lookUpMovie(int id) {
        //find and return movies with ID
        int h1 = hash1(id); //find index
        Movie current = movieHash[h1]; //start at that index 

        while (current != null) {
            if (current.getID() == id) {
                return current; //we found the movie 
            } else {
                current = current.getNext(); //move to next
            }
        }
        return null; //movie was never found
    }

    public Movie insertHash(Movie x) {
        //inserting movies into the hash table
        int id = x.getID(); //get movie ID
        int h1 = hash1(id); //find index

        x.setNext(movieHash[h1]); //insert at the front
        movieHash[h1] = x; 
        hashN = hashN + 1; //increase the count 
        return x;
    }

    public Movie deleteHash(int id) {
        //delete movies by ID
        int h1 = hash1(id); //find index
        Movie current = movieHash[h1]; //start at front
        Movie old = null; //previous movie 

        while (current != null) {
            if (current.getID() == id) {
                //this means we found the movie
                if (old == null) {
                    //deleting the first in the list
                    movieHash[h1] = current.getNext();
                } else {
                    //deleting anywhere else
                    old.setNext(current.getNext());
                }
                
                current.setNext(null); //disconnect node
                hashN = hashN - 1;
                return current;
            }
            old = current; //move forward in the list
            current = current.getNext();
        }
        return null;    
    }

    public boolean isHashEmpty() {
        //checks if hash is empty 
        return hashN == 0;
    }

    public void printHash() {
        //prints the hash table
        for (int i = 0; i < hashSize; i++) { 
            System.out.print(i + ": "); //writing the index 

            Movie current = movieHash[i]; //

            while (current != null) {
                System.out.print(current.getTitle() + ", "); //getting the name of movie
                current = current.getNext(); //moving down the list
            }
            System.out.println("null"); //end of the list
        }
    }

    public void addMovie(Movie m) {
        insertMovie(m); //BST by release date
        insertMovieHeap(m); //heap rating
        insertHash(m); //hash by ID
    }

    public Movie removeLowestRated() { //removing lowest rated from the heap
        Movie m = deleteMovieMin(); //root is lowest
        if (m != null) { //mark as unnavailable, only removing from heap
            m.setAvailable(false);
        }

        return m;
    }

    public Movie findMovieID(int id) { //uses hash to find movie by ID
        return lookUpMovie(id);
    }

    public void printMovies() { //prints movies by release date order
        traverseMovie();
    }

}
	
