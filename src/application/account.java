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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class account {
	private String userName;
	private String password;
	private ObservableList<text> list = FXCollections.observableArrayList();
	
	account(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	ObservableList<text> returnList()
	{
		return list;
	}
	
	String getUserName()
	{
		return userName;
	}
	
	String getPassword()
	{
		return password;
	}
	
}
