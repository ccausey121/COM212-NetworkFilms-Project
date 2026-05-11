//Nicole, Caleb, Miriam 4/30/26
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Database data = Database.loadData();

		CustomerBST customerBST = data.customerBST;
		MovieHeap movieHeap = data.movieHeap;
		MovieRDBST movieRDBST = data.movieRDBST;
		MovieIDBST movieIDBST = data.movieIDBST;
		
		Scanner input = new Scanner(System.in);
		
		int choice = 0; //storing options
		
		while (choice != 13) 
		{
			System.out.println();
			System.out.println("Welcome to Network Films!");
			System.out.println("1: Add Movie to Network Films"); // adds to call data stractures
			System.out.println("2: Print Movies by release date: "); //MovieRDBST
			System.out.println("3: Find movie by ID: "); //MovieIDBST
			System.out.println("4: Print Movie Ratings: "); //MovieHeap
			System.out.println("5: Remove lowest rated (available) movie: "); //we gotta remove this one and make it semi automatic I believe?
			System.out.println("6: Print Movie Directory: "); //MovieIDBST
			System.out.println("7: Add Customer: ");
			System.out.println("8: Search customer by card: ");
			System.out.println("9: Update customer name:");
			System.out.println("10: Update customer email: ");
			System.out.println("11: Print Customers: ");
			System.out.println("12: Customer Wishlist: ");
			System.out.println("13: EXIT ");
			System.out.println("Enter Choice: ");

			boolean valid = false;
			while(!valid) {
				try {
				choice = input.nextInt();
				input.nextLine();
					if (choice >=1 && choice <= 13) {
						valid = true;
					} else {
						System.out.print("Invalid input, try again: ");
					}
				} catch (Exception e) {
				System.out.print("Invalid input, try again: ");
				input.nextLine();
			}
			}
		
			//First thing we want to do is add movies into the Network films
			if (choice == 1) 
			{
				System.out.print("Title: ");
				String title0 = input.nextLine();
				
				System.out.print("Release Date (yyyymmdd): ");
				valid = false;
				int date0 = 0;

				while(!valid) {
					try {
						date0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}
			
				System.out.print("Movie ID: ");
				valid = false;
				int id0 = 0;

				while(!valid) {
					try {
						id0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}

				System.out.print("Rotten Tomatoes (0-100): ");
				valid = false;
				int rating0 = 0;

				while(!valid) {
					try {
						rating0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}

				Movie m = new Movie(title0, date0, id0, rating0);
				m.setAvailable(true);
		
				movieIDBST.insertMovie(m);
				movieRDBST.insertMovie(m);
				movieHeap.insertMovieHeap(m);

				System.out.println("Movie added to Network Films");
				
				int next0 = pauseAnswers(input);
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 2)
			{
				if (movieRDBST.isMovieRDTreeEmpty())
				{
					System.out.println("Movie list is empty");
				}
				else
				{
					movieRDBST.printMovies();
				}
				
				int next0 = pauseAnswers(input);
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 3)
			{
				System.out.print("Enter movie ID: ");
				valid = false;
				int id0 = 0;

				while(!valid) {
					try {
						id0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}
				
				Movie m = movieIDBST.searchMovieID(id0);

				if (m != null)
				{
					System.out.println(m.getTitle() + " " + m.getReleaseDate());
					System.out.println("Available: " + m.isAvailable());
				}
				else
				{
					System.out.println("Movie not found.");
				}
				
				int next0 = pauseAnswers(input);
				
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 4)
			{
				movieHeap.printHeap();
				
				int next0 = pauseAnswers(input);
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 5) 
			{
				Movie m = movieHeap.removeLowestRated();
				
				if (m != null)
				{
					System.out.println("Lowest Rated movie removed from available list: " + m.getTitle());
					System.out.println("Available? " + m.isAvailable());
				}
				else
				{
					System.out.println("No available movies.");
				}
				
				int next0 = pauseAnswers(input);

				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 6)
			{
				movieIDBST.printMovieIDBST();
				
				int next0 = pauseAnswers(input);
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 7)
			{
				System.out.print("Customer name: ");
				String name0 = input.nextLine();

				System.out.print("Customer email: ");
				String email0 = input.nextLine();

				System.out.print("Customer credit card (4 digits): ");
				valid = false;
				int card0 = 0;

				while(!valid) {
					try {
						card0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}

				Customer c = new Customer(name0, email0, card0);
				customerBST.insertCustomer(c);

				System.out.println("Customer added.");
				
				int next0 = pauseAnswers(input);
				if (next0 == 2)
				{
					choice = 13;
				}
			}

			else if (choice == 8)
			{
				System.out.print("Enter card number: ");
				valid = false;
				int card0 = 0;

				while(!valid) {
					try {
						card0 = input.nextInt();
						input.nextLine();
						valid = true;
					} catch (Exception e) {
						System.out.print("Invalid input, try again: ");
						input.nextLine();
					}
				}
				
				Customer c = customerBST.searchCustomer(card0);
				
				if (c!= null)
				{
					System.out.println("Customer found: " + c.getName());
					System.out.println("email: " + c.getEmail());
				}
				else
				{
					System.out.println("Customer not found.");
				}
				
			int next0 = pauseAnswers(input);
			if (next0 == 2)
			{
				choice = 13;
			}
		}

		else if (choice == 9)
		{
			System.out.println("Enter card number: ");
			valid = false;
			int card0 = 0;

			while(!valid) {
				try {
					card0 = input.nextInt();
					input.nextLine();
					valid = true;
				} catch (Exception e) {
					System.out.print("Invalid input, try again: ");
					input.nextLine();
				}
			}

			System.out.print("New name: ");
			String name0 = input.nextLine();

			customerBST.updateCustomerName(card0, name0);
			
			int next0 = pauseAnswers(input);
			if (next0 == 2)
			{
				choice = 13;
			}
		}

		else if (choice == 10)
		{
			System.out.println("Enter card number: ");
			valid = false;
			int card0 = 0;

			while(!valid) {
				try {
					card0 = input.nextInt();
					input.nextLine();
					valid = true;
				} catch (Exception e) {
					System.out.print("Invalid input, try again: ");
					input.nextLine();
				}
			}

			System.out.print("New email: ");
			String email0 = input.nextLine();

			customerBST.updateCustomerEmail(card0, email0);
			
			int next0 = pauseAnswers(input);
			if (next0 == 2)
			{
				choice = 13;
			}
		}

		else if (choice == 11)
		{
			customerBST.printCustomerBST();
			
			int next0 = pauseAnswers(input);
			if (next0 == 2)
			{
				choice = 13;
			}
		}

		else if (choice == 12)
		{
			System.out.println("Enter card number: ");
			valid = false;
			int card0 = 0;

			while(!valid) {
				try {
					card0 = input.nextInt();
					input.nextLine();
					valid = true;
				} catch (Exception e) {
					System.out.print("Invalid input, try again: ");
					input.nextLine();
				}
			}

			Customer c = customerBST.searchCustomer(card0);

			if (c == null)
			{
				System.out.println("Customer not found!");
			}
			else
			{
				System.out.println("You have selected " + c.getName() + "'s wishlist!");
				int wishChoice = 0;

				while (wishChoice != 6)
				{
					System.out.println();
					System.out.println("1: Add Movie to wishlist by ID: ");
					System.out.println("2: See next movie: ");
					System.out.println("3: Watch next movie: ");
					System.out.println("4: Print wishlist: ");
					System.out.println("5: Print watched list");
					System.out.println("6: BACK");
					System.out.print("Enter Choice: ");
					
					valid = false;

					while (!valid) {
						try {
							wishChoice = input.nextInt();
							input.nextLine();
							valid = true;
						} catch (Exception e) {
							System.out.print("Invalid input, try again: ");
							input.nextLine();
						}
					}

					if (wishChoice == 1)
					{
						System.out.print("Movie ID: ");
						valid = false;
						int id0 = 0;

						while(!valid) {
							try {
								id0 = input.nextInt();
								input.nextLine();
								valid = true;
							} catch (Exception e) {
								System.out.print("Invalid input, try again: ");
								input.nextLine();
							}
						}
				
						Movie m = movieIDBST.searchMovieID(id0);
						if (m != null)
						{
							c.addMovie(m);
						}
						else
						{
							System.out.println("Movie not found");
						}
					}
					else if (wishChoice == 2)
					{
						c.front();
					}
					else if (wishChoice == 3)
					{
						c.watchMovie();
					}
					else if (wishChoice == 4)
					{
						c.printWishlist();
					}
					else if (wishChoice == 5)
					{
						c.printWatched();
					}
				}
			}
			int next0 = pauseAnswers(input);
			if (next0 == 2) {
				choice = 13;
			}
		}
		
		else if (choice == 13)
		{
			Database.saveData(data);
			System.out.println("Exiting");
		}
		else
		{
			System.out.println("Invalid Choice");
		}
		
	}
	Database.saveData(data);
	input.close();
	
}

	private static int pauseAnswers(Scanner input)
	{
		System.out.println();
		System.out.println("1: Back to options");
		System.out.println("2: EXIT");

		boolean valid = false;
		int choice = 0;
		
		while(!valid) {
			try {
				System.out.print("Choice: ");
				choice = input.nextInt();
				input.nextLine();
				if (choice == 1 || choice == 2) {
					valid = true;
				} else {
					System.out.println("Invalid input, try again: ");
				}
			} catch (Exception e) {
				System.out.print("Invalid input, try again: ");
				input.nextLine();
			}
		}
		
		return choice;
	}	
}
