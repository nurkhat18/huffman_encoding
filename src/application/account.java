package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class account {
	public static HashMap<String, String> accountsTable = new HashMap<>();
	
	public void add(String username, String password)
	{
		if(!accountsTable.containsKey(username))
		{
			accountsTable.put(username, password);
			
		}
	}
	
	
	public boolean checkContain(String username)
	{
		if(!accountsTable.containsKey(username))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean checkUser(String username, String password)
	{
		if(accountsTable.containsKey(username))
		{
			if(accountsTable.get(username).equals(password))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	public void saveNewAccounts() {
        try {
            FileOutputStream bytesToDisk = new FileOutputStream("accounts.ser");
            ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
            outFile.writeObject(accountsTable);
            outFile.close();
        } catch (IOException ioe) {
            System.out.println("Write failed... " + ioe);
        }
    }
	
	
	
	@SuppressWarnings("unchecked")
	public void readSavedAccounts() {
        try {
            FileInputStream disk = new FileInputStream("accounts.ser");
            ObjectInputStream inputStreamIn = new ObjectInputStream(disk);
            
            accountsTable = (HashMap<String, String>) inputStreamIn.readObject();
            inputStreamIn.close();
        } catch (ClassNotFoundException | IOException a) {
            System.out.println("Something went wrong! " + a);
        }
    }
	
	
}
