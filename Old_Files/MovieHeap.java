/*For this class we will be implenting a heap where the administrators need to be able to see 
least rated available movies (small rotton tomatoes)
they will need to be able to check the least rated movies and remove them when they are no longer needed
this is to make sure there is always room for new movies.  
*/

public class MovieHeap {
    
    private Movie h[]; //this will be the array of movies 
    private int n; //this will be the number of movies inside the heap

    public MovieHeap() {
        h = new Movie[255]; //max of 255 movies available
        n = 0; // need to keep track of the movies inside the heap
    }

    public Movie findMin() {
        //for this we need to return the movie with the lowest rated score (which will be the root of the heap)
        if (n == 0) {
            return null; //if the list of movies is empty return null
        } else {
            return h[0]; //if not return the root of the tree (first index)
        }
    }

    public Movie deleteMin() {
        // we want to delete the min node and return it 
        //we need to remove first index and subtract n-1
        //this requires swapping the positions of the items in the heap
        if (n == 0) {
            return null; //if the heap is empty we cannot delete anything 
        }

        Movie temp = h[0]; //we want to save the root because we will return later

        h[0] = h[n-1]; //moving the last movie to the first spot in heap
        h[n-1] = null; //removing the last one in the heap
        n = n - 1; 

        int i = 0; //starting at the first index 
        while (2 * i + 1 < n) { //while there is a left child 
            int left = 2 * i + 1; //left child index 
            int right = 2 * i + 2; //right child index 

            int small = left; //this will assume the left child is the smaller one
            //now we need to check if there is a right and that is smaller 
            if ( right < n && h[right].getRating() < h[left].getRating()) {
                small = right;  //right would now be the smaller child
            } else if (h[i].getRating() <= h[small].getRating()) {
                break; //the current one is actually smaller than the children so leave as is
            }

            Movie current = h[i]; //saving current node
            h[i] = h[small]; //swapping it with the smaller child
            h[small] = current; //making the swapped one the new current

            i = small; //moving down the child index 
        }
        return temp; //returning the movie that we removed 
    }

    public void insert(Movie x) {
        //we want to add x if the movie is available which means we need to check that 
        if (n == 255) { //if the heap is full we cannot add anything
            System.out.println("FULL!");
            return;
        }

        if (!x.isAvailable()) {
            return;
        }

        h[n] = x; //inserting x at the end of the heap
        int i = n; //this is the index where we added the movie 
        n = n + 1; //increasing the size of the list

        while(i > 0) { //while the movie is not at the root
            int parent = (i - 1) / 2; //fidn the index of the parent 
            if (h[parent].getRating() <= h[i].getRating()) { //if the parent is smaller stop
                return;
            }

            Movie temp = h[i]; //save the current
            h[i] = h[parent]; //swap the current with the parent 
            h[parent] = temp; 

            i = parent; // change position of the parent 
        }
    }

    public boolean isEmpty() {
        return n == 0; //checking if the heat is empty 
    }

    public void printHeap() { 
        if (n == 0) {
            System.out.println("EMPTY"); //nothing is in the heap
            return;
        }
        for (int i = 0; i < n; i++) { //printing movies in order of score
            System.out.print(h[i].getRating() + " ");
        }
        System.out.println();

    }
}

