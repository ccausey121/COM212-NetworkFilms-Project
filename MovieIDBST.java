//Nicole Prescott
// 
import java.io.*;
public class MovieIDBST implements Serializable { 
    
    private Movie movieIDRoot;

    public MovieIDBST() {
        movieIDRoot = null;
    }

    public boolean isIDBSTEmpty() {
        return movieIDRoot == null;
    }

    public void insertMovie(Movie m) {
        movieIDRoot = insertMovie2(movieIDRoot, m);
    }

    private Movie insertMovie2(Movie root, Movie m) {
        if (root == null) {
            return m;
        }

        else if (m.getID() > root.getID()) {
            root.setIDRight(insertMovie2(root.getIDRight(), m));
        }

        return root;
    }

    public Movie searchMovieID(int id) {
        return searchMovieID2(movieIDRoot, id);
    } 

    private Movie searchMovieID2(Movie root, int id) {
        if (root == null) {
            return null;
        }

        else if (id == root.getID()) {
            return root;
        }

        else if (id < root.getID()) {
            return searchMovieID2(root.getIDLeft(), id);
        }

        else {
            return searchMovieID2(root.getIDRight(), id);
        }
    }

    public void printMovieIDBST() {
        printMovieIDBST2(movieIDRoot);
        System.out.println();
    }

    private void printMovieIDBST2(Movie m) {
        if (m != null) {
            printMovieIDBST2(m.getIDLeft());
            System.out.println(m.getID() + " " + m.getTitle());
            printMovieIDBST2(m.getIDRight());
        }
    }

}