//Nicole, Caleb, Miriam 4/30/26

public class TestNetworkFilms {
    public static void main(String[] args) {
        NetworkFilms network = new NetworkFilms();

        //create list of movies 
        Movie m1 = new Movie("Wizard of Oz", 19390825, 12345, 98, true);
        Movie m2 = new Movie("Jaws", 19750620, 54321, 97, true);
        Movie m3 = new Movie("Elf", 20031107, 98765, 85, true);

        network.addMovie(m1);
        network.addMovie(m2);
        network.addMovie(m3);

        System.out.println("Movies in order of release date: ");
        network.printMovies();

        //finding movies by ID
        System.out.println("Which movie has ID: 54321...?");
        Movie found = network.findMovieID(54321);
        if (found != null) {
            System.out.println(found.getTitle());
        } //should be printing Jaws

        System.out.println(); //printing the heap
        System.out.println("Movie heap printed in order of rotten tomatoes: ");
        network.printHeap();
        System.out.println();


        System.out.print("MovieBST Structure ");
        System.out.println();
        network.printMovieTree();

        

        //removing lowest rated movie from the heap
        Movie lowest = network.removeLowestRated();
        if (lowest != null) {
            System.out.println("The lowest rated movie is: " + lowest.getTitle());
            System.out.println("Is " + lowest.getTitle() + " still availble? " + lowest.isAvailable());
        }
        System.out.println();
        System.out.println(); //we removed lowest rated reprint the movies in order of rating
        System.out.println("Movie heap printed in order of rotten tomatoes after removal of lowest rated: ");
        network.printHeap();
        System.out.println();

        System.out.println("MovieBST in order of release date: ");
        network.printMovies();


        //need to create a customer
        Customer c1 = new Customer("Nicole", "nicole@email.com", 1212);
        Customer c2 = new Customer("Caleb", "caleb@email.com", 2323);
        Customer c3 = new Customer("Miriam", "miriam@email.com", 4646);


        network.insertCustomer(c1);
        network.insertCustomer(c2);
        network.insertCustomer(c3);

        System.out.println();
        System.out.println("Customer BST in order of card number: ");
        network.printCustomerBST();



        System.out.println("Customer with credit card number 1212 is: ");
        Customer c = network.searchCustomer(1212);
        if (c != null) {
            System.out.println(c.getName());
        }
        Customer foundCustomer = network.searchCustomer(1212);
        if (foundCustomer != null) {
            System.out.println("Customer found: " + foundCustomer.getName());
            //change customer info
            network.updateCustomerEmail(1212, "prescott@email.com");
            network.updateCustomerName(1212, "Nicole Prescott");
            System.out.println();
            System.out.println("Updated customer name: " + foundCustomer.getName());
            System.out.println("Updated customer email: " + foundCustomer.getEmail());
        } else {
            System.out.println("Customer not found");
        }

        //Nicole Wishlist
    
        c1.addMovie(m1);
        c1.addMovie(m2);
        c1.addMovie(m3);

        System.out.println();
        System.out.println("Nicole's Next Ups: ");
        c1.front();
     

        System.out.println();
        c1.watchMovie();
        System.out.println("Nicole watched this movie and now removed from wishlist");
        System.out.println();
        System.out.println("Nicole's watched list: ");
        c1.printWatched();

        System.out.println();
        System.out.println("Nicole's wishlist now: ");
        c1.printWishlist();

        System.out.println();
        System.out.println("testing unavailable movie: ");
        System.out.println();
        System.out.println("These are the movies we have in 2025; ");
        System.out.println("is " + m1.getTitle() + " available? " + m1.isAvailable());
        System.out.println("is " + m2.getTitle() + " available? " + m2.isAvailable());
        System.out.println("is " + m3.getTitle() + " available? " + m3.isAvailable());
        System.out.println();
        m2.setAvailable(false);

        System.out.println("These are the movies we have in 2026; ");
        System.out.println("is " + m1.getTitle() + " available? " + m1.isAvailable());
        System.out.println("is " + m2.getTitle() + " available? " + m2.isAvailable());
        System.out.println("is " + m3.getTitle() + " available? " + m3.isAvailable());
        System.out.println();

        c1.front();
        System.out.println();

    }
    
}
