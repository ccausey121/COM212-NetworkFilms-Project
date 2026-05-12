import java.io.*;

public class Database implements Serializable 
{
	public CustomerBST customerBST;
	public MovieHeap movieHeap;
	public MovieRDBST movieRDBST;
	public MovieIDBST movieIDBST;

	public Database() {
		customerBST = new CustomerBST();
		movieHeap = new MovieHeap();
		movieRDBST= new MovieRDBST();
		movieIDBST = new MovieIDBST();
	}

	public static void saveData(Database data)
	{
		try 
		{
		    FileOutputStream file = new FileOutputStream("data.ser");
		    ObjectOutputStream out = new ObjectOutputStream(file);

		    out.writeObject(data);

		    out.close();
		    // Data has been saved!

		} 
		catch (Exception e) 
		{
		    // IOException is caught
		}
	}
	public static Database loadData()
	{
		try 
		{
		    FileInputStream file = new FileInputStream("data.ser");
		    ObjectInputStream in = new ObjectInputStream(file);

		    Database data = (Database) in.readObject();
		    
			in.close();
		    file.close();
			return data;
		    // Data has been loaded!
		} 
		catch (Exception e) 
		{
			return new Database();
		    // IOException is caught
		} 

	}
}