public class Database implements Serializable 
{
	Database data = new Database(x, y, z, n);
        String filename = "data.ser";

        // Serialization
	public void saveData()
	{
		try 
		{
		    FileOutputStream file = new FileOutputStream("data.ser");
		    ObjectOutputStream out = new ObjectOutputStream(file);
		    out.writeObject(data);
		    out.close();
		    data.close();
		    System.out.println("Data has been saved!");

		} 
		catch (IOException ex) 
		{
		    System.out.println("IOException is caught");
		}
	}
	public void loadData()
	{
		try 
		{
		    FileInputStream file = new FileInputStream("data.ser");
		    ObjectInputStream in = new ObjectInputStream(file);
		    data1 = (Database) in.readObject();
		    in.close();
		    file.close();
		    System.out.println("Data has been loaded!");
		} 
		catch (IOException ex) 
		{
		    System.out.println("IOException is caught");
		} 
		catch (ClassNotFoundException ex) 
		{
		    System.out.println("ClassNotFoundException is caught");
		}
	}
}