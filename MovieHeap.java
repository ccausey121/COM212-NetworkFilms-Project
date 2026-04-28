/*For this class we will be implenting a heap where the administrators need to be able to see 
least rated available movies (small rotton tomatoes)
they will need to be able to check the least rated movies and remove them when they are no longer needed
this is to make sure there is always room for new movies.  
*/

public class MovieHeap {
    
    private Movie movieHeap[];
    private int heapN;

    public MovieHeap() {
        movieHeap = new Movie[255]; //max of 255 available movies
        heapN = 0; 
    }
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
    public Movie removeLowestRated() { //removing lowest rated from the heap
        Movie m = deleteMovieMin(); //root is lowest
        if (m != null) { //mark as unnavailable, only removing from heap
            m.setAvailable(false);
        }

        return m;
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
}
