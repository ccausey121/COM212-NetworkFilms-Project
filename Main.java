//Nicole, Caleb, Miriam 4/30/26
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NetworkFilms network = new NetworkFilms();
        Scanner input = new Scanner(System.in);

        int choice = 0; //storing options 

        while (choice != 13) {
            System.out.println();
            System.out.println("Network Films!");
            System.out.println("1: Add Movie to Network Films"); //
            System.out.println("2: Print Movies by release date: "); //
            System.out.println("3: Find movie by ID: "); //
            System.out.println("4: Print movie heap: ");
            System.out.println("5: Remove lowest rated (available) movie: ");
            System.out.println("6: Print movie hash: ");
            System.out.println("7: Add Customer: ");
            System.out.println("8: Search customer by card: ");
            System.out.println("9: Update customer name:");
            System.out.println("10: Update customer email: ");
            System.out.println("11: Print Customer BST: ");
            System.out.println("12: Customer wishlist: ");
            System.out.println("13: EXIT ");
            System.out.println("Enter Choice: ");

            choice = input.nextInt();
            input.nextLine();

        //First thing we want to do is add movies into the Network films
            if (choice == 1) {
                System.out.print("Title: ");
                String title0 = input.nextLine();

                System.out.print("Release Date (yyyymmdd): ");
                int date0 = input.nextInt();

                System.out.print("Movie ID (5 digits): ");
                int id0 = input.nextInt();

                System.out.print("Rotten Tomatoes (0-100): ");
                int rating0 = input.nextInt();

                System.out.print("Available? (True/False): ");
                boolean available0 = input.nextBoolean();

                Movie m = new Movie(title0, date0, id0, rating0, available0);
                network.addMovie(m);

                System.out.println("Movie added to Network Films");

                int next0 = pauseAnswers(input);
                if (next0 == 2){
                    choice = 13;
                }
            }

            else if (choice == 2) {
                if network.isMovieTreeEmpty(){
                    System.out.println("Movie list is empty");
                } else {
                    network.printMovies(); //prints movies by release date
                }
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter movie ID: ");
                int id0 = input.nextInt();

                Movie m = network.findMovieID(id0);

                if (m != null) {
                    System.out.println(m.getTitle() + " " + m.getReleaseDate());
                    System.out.println("Available: " + m.isAvailable());
                } 
                else {
                    System.out.println("Movie not found.");
                }
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 4) {
                network.printHeap();
                
            }
            else if (choice == 5) {
                Movie m = network.removeLowestRated();

                if (m != null) {
                    System.out.println("Lowest Rated movie removed from available list: " + m.getTitle());
                    System.out.println("Available? " + m.isAvailable());
                } else {
                    System.out.println("No available movies.");
                }
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 6) {
                network.printHash();
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 7) {
                System.out.print("Customer name: ");
                String name0 = input.nextLine();

                System.out.print("Customer email: ");
                String email0 = input.nextLine();

                System.out.print("Customer credit card (4 digits): ");
                int card0 = input.nextInt();

                Customer c = new Customer(name0, email0, card0);
                network.insertCustomer(c);

                System.out.println("Customer added.");
                
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 8) {
                System.out.print("Enter card number: ");
                int card0 = input.nextInt();

                Customer c = network.searchCustomer(card0);

                if (c!= null) {
                    System.out.println("Customer found: " + c.getName());
                    System.out.println("email: " + c.getEmail());
                } else {
                    System.out.println("Customer not found.");
                }
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 9) {
                System.out.println("Enter card number: ");
                int card0 = input.nextInt();
                input.nextLine();

                System.out.print("New name: ");
                String name0 = input.nextLine();

                network.updateCustomerName(card0, name0);
                
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 10) {
                System.out.println("Enter card number: ");
                int card0 = input.nextInt();
                input.nextLine();

                System.out.print("New email: ");
                String email0 = input.nextLine();

                network.updateCustomerEmail(card0, email0);
                
                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            } 
            else if (choice == 11) {
                network.printCustomerBST();

                int next0 = pauseAnswers(input);
                if (next0 == 2) {
                    choice = 13;
                }
            }
            else if (choice == 12) {
                System.out.println("Enter card number: ");
                int card0 = input.nextInt();

                Customer c = network.searchCustomer(card0);
                if (c == null) {
                    System.out.println("Customer not found!");
                } else {
                    int wishChoice = 0;

                    while (wishChoice != 6) {
                        System.out.println();
                        System.out.println("1: Add Movie to wishlist by ID: ");
                        System.out.println("2: See next movie: ");
                        System.out.println("3: Watch/ remove next movie: ");
                        System.out.println("4: Print wishlist: ");
                        System.out.println("5: P{rint watched list");
                        System.out.println("6: BACK");
                        System.out.print("Enter Choice: ");

                        wishChoice = input.nextInt();

                        if (wishChoice == 1) {
                            System.out.print("Movie ID: ");
                            int id0 = input.nextInt();

                            Movie m = network.findMovieID(id0);
                            if (m != null) {
                                c.addMovie(m);
                            } else {
                                System.out.println("Movie not found");
                            }
                        }
                        else if (wishChoice == 2) {
                            c.front();
                        }
                        else if (wishChoice == 3) {
                            c.watchMovie();
                        }
                        else if (wishChoice == 4) {
                            c.printWishlist();
                        }
                        else if (wishChoice == 5) {
                            c.printWatched();
                        }
                        int next0 = pauseAnswers(input);
                        if (next0 == 2) {
                            choice = 13;
                        }
                    }
                }
            }
            else if (choice == 13) {
                System.out.println("Exiting");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }

        public static int pauseAnswers(Scanner input) {
            System.out.println();
            System.out.println("1: Back to options");
            System.out.println("2: EXIT");
            System.out.println("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            return choice;
        }
}
