package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class accountList {
	public static HashMap<account, ObservableList<text>> accountsTable = new HashMap<>();
	

	
	public void add(String userName, String password)
	{
		if(!accountsTable.containsKey(userName))
		{
			account newAccount = new account(userName, password);
			ObservableList<text> list = newAccount.returnList();
			accountsTable.put(newAccount, list);
			
		}
	}
	
	
	
	public boolean checkUser(String username, String password)
	{
		for(account accounts: accountsTable.keySet())
		{
			if(accounts.getUserName().equals(username))
			{
				if(accounts.getPassword().equals(password))
				{
					
					return true;
					
				}
			}
		}
		
		return false;
	}
	
	public HashMap<account, ObservableList<text>> getHashMap()
	{
		return accountsTable;
	}
	
	public Set<account> getAccount()
	{
		return accountsTable.keySet();
	}
	

//	public void saveNewAccounts() {
//        try {
//            FileOutputStream bytesToDisk = new FileOutputStream("accounts.ser");
//            ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
//            outFile.writeObject(accountsTable);
//            outFile.close();
//        } catch (IOException ioe) {
//            System.out.println("Write failed... " + ioe);
//        }
//    }
//	
//	
//	
//	@SuppressWarnings("unchecked")
//	public void readSavedAccounts() {
//        try {
//            FileInputStream disk = new FileInputStream("accounts.ser");
//            ObjectInputStream inputStreamIn = new ObjectInputStream(disk);
//            
//            accountsTable = (HashMap<String, String>) inputStreamIn.readObject();
//            inputStreamIn.close();
//        } catch (ClassNotFoundException | IOException a) {
//            System.out.println("Something went wrong! " + a);
//        }
//    }
}
