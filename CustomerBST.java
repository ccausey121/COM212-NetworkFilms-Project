// Customer BST
// Miriam Clemente

public class CustomerBST
{
	private Customer root;
	public CustomerBST()
	{
		root = null;
	}
	public void insert(Customer c) // inserting
	{
		root = insertRec(root, c);
	}
	private Customer insertRec(Customer root0, Customer c)
	{
		if (root0 == null)
			return c;
		if (c.getCard() < root0.getCard())
			root0.setLeft(insertRec(root0.getLeft(), c));
		else if (c.getCard() > root0.getCard())
			root0.setRight(insertRec(root0.getRight(), c));
		return root0;
	}

	public Customer search(int card) // search for card using BST
	{
		return searchRec(root, card);
	}

	private Customer searchRec(Customer root0, int card)
	{
		if (root0 == null || root0.getCard() == card)
			return root0;
		if (card < root0.getCard())
			return searchRec(root0.getLeft(), card);
		return searchRec(root0.getRight(), card);
	}

	public void updateName(int card, String newName) // updating 
	{
		Customer c = search(card);
		if (c != null)
			c.setName(newName);
		else
			System.out.println("Customer not found");
	}

	public void updateEmail(int card, String newEmail)
	{
		Customer c = search(card);
		if (c != null)
			c.setEmail(newEmail);
		else
			System.out.println("Customer not found");
	}

	public void updateCard(int oldCard, int newCard)
	{
		Customer c = search(oldCard);
		if (c != null)
		{
			delete(oldCard); // delete old car here 
			c.setCard(newCard);
			insert(c);
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
			return null;

		if (card < root0.getCard())
			root0.setLeft(deleteRec(root0.getLeft(), card));
		else if (card > root0.getCard())
			root0.setRight(deleteRec(root0.getRight(), card));
		else
		{
			if (root0.getLeft() == null)
				return root0.getRight();
			else if (root0.getRight() == null)
				return root0.getLeft();

			Customer min = findMin(root0.getRight());
			root0.setCard(min.getCard());
			root0.setRight(deleteRec(root0.getRight(), min.getCard()));
		}

		return root0;
	}

	private Customer findMin(Customer node)
	{
		while (node.getLeft() != null)
			node = node.getLeft();

		return node;
	}
}
