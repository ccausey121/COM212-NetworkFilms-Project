// Customer BST
// Miriam Clemente

public class CustomerBST {

	private Customer customerRoot;

	public CustomerBST() {
		
		customerRoot = null;
	}

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
}