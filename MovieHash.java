public class MovieHash {
    private Movie movieHash[];
    private int hashSize;
    private int hashN;

    public MovieHash() {
        hashSize = 255;
        movieHash = new Movie[hashSize];
        hashN = 0;
    }    
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
    
    public Movie findMovieID(int id) { //uses hash to find movie by ID
        return lookUpMovie(id);
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
}