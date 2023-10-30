package model;

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
	private String name;
	private LocalDate lastSelectionDate;
	private LocalDate today;
	private boolean login = false;
	private String userName;

	public static Hashtable<String, String> accountsTable = new Hashtable<>();
	
	public account(String name) {
		this.name = name;
		this.lastSelectionDate = LocalDate.now();
		
	}
		
	
	public account(String name, String password) {
		today = LocalDate.now();
		this.userName = name;

		// New account
		if (!accountsTable.containsKey(name)) {
			accountsTable.put(name, password);
			
			this.userName = name;
			this.login = true;
			System.out.println("Account created success for " + name);
			
		} 
		
		else {
			// Invalid credentials
			if (!accountsTable.get(name).equals(password)) {
				this.login = false;
			}

			// Correct login info
			if (accountsTable.get(name).equals(password)) {
				this.login = true;
				System.out.println("Login done");
			}
		}
		
	}
	
	
	public boolean getLogin() {
		return login;
	}
    
	public Hashtable<String, String> getAccountsTable() {
		return accountsTable;
	}
	
	public String getUserName() {
		return userName;
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
            
            accountsTable = (Hashtable<String, String>) inputStreamIn.readObject();
            inputStreamIn.close();
        } catch (ClassNotFoundException | IOException a) {
            System.out.println("Something went wrong! " + a);
        }
    }
	
	
}
