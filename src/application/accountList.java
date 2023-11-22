/*
 * Gijeong Lee and Swarn
 * This class has a HashMap containing account object and its ObservableList.
 * 
 */
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
	

	/*
	 * It adds new account object to accountsTable with userName and Password.
	 */
	public void add(String userName, String password)
	{
		if(!accountsTable.containsKey(userName))
		{
			account newAccount = new account(userName, password);
			ObservableList<text> list = newAccount.returnList();
			accountsTable.put(newAccount, list);
			
		}
	}
	
	
	/*
	 * It checks the username and password.
	 * It is for log in.
	 */
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
	
	/*
	 * @return accountsTable (HashMap)
	 */
	public HashMap<account, ObservableList<text>> getHashMap()
	{
		return accountsTable;
	}
	
	/*
	 * return accountsTable.keySet() (Set<account>)
	 */
	public Set<account> getAccount()
	{
		return accountsTable.keySet();
	}
	

}
