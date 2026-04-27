// Customer BST
// Miriam Clemente

public class CustomerBST
{
	private Customer root;
	public CustomerBST()
	{
		root = null; // setting empty tree
	}
	public void insert(Customer c) // calling inserting
	{
		root = insertRec(root, c);
	}
	private Customer insertRec(Customer root0, Customer c) 
	{
		if (root0 == null)
			return c; // if found empty spot insert
		if (c.getCard() < root0.getCard())
			root0.setLeft(insertRec(root0.getLeft(), c)); // check left
		else if (c.getCard() > root0.getCard())
			root0.setRight(insertRec(root0.getRight(), c));// check right
		return root0; // updated node is returned 
	}

	public Customer search(int card) // search for card using BST
	{
		return searchRec(root, card); // searchRec begins at root
	}

	private Customer searchRec(Customer root0, int card)
	{
		if (root0 == null || root0.getCard() == card)
			return root0; // returns when found
		if (card < root0.getCard())
			return searchRec(root0.getLeft(), card); // serching left
		return searchRec(root0.getRight(), card);// serching right
	}

	public void updateName(int card, String newName) // updating 
	{
		Customer c = search(card); // searching for customer
		if (c != null)
			c.setName(newName); // updating name when found
		else
			System.out.println("Customer not found"); // if not found outputs not found
	}

	public void updateEmail(int card, String newEmail)
	{
		Customer c = search(card); // finding customer
		if (c != null)
			c.setEmail(newEmail); // updating email
		else
			System.out.println("Customer not found"); // output if email is not found
	}

	public void updateCard(int oldCard, int newCard)
	{
		Customer c = search(oldCard); // finding customer
		if (c != null)
		{
			delete(oldCard); // delete old card node 
			c.setCard(newCard); // change key
			insert(c); // insert 
		}
		else
			System.out.println("Customer not found");
	}
	public void delete(int card)
	{
		root = deleteRec(root, card);
	}
	private Customer deleteRec(Customer root0, int card)
	{
		if (root0 == null)
			return null; // nothing to delete

		if (card < root0.getCard())
			root0.setLeft(deleteRec(root0.getLeft(), card)); // checking left
		else if (card > root0.getCard())
			root0.setRight(deleteRec(root0.getRight(), card)); // checking right
		else
		{
			if (root0.getLeft() == null)
				return root0.getRight(); // after being found replace with right child 
			else if (root0.getRight() == null)
				return root0.getLeft(); // replace with left child

			Customer min = findMin(root0.getRight()); // if there are 2 nodes found find smallest in right
			root0.setCard(min.getCard());
			root0.setRight(deleteRec(root0.getRight(), min.getCard())); // or smallest on the left side 
		}

		return root0; return the updated version
	}

	private Customer findMin(Customer node)
	{
		while (node.getLeft() != null)
			node = node.getLeft(); 

		return node;
	}
}
