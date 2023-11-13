package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class textList {
	private ArrayList list;
	
	private ObservableList<String> textList;
	
	
//	private JukeboxAccount user;

	/*
	 * Constructor creating a new LinkedList for queue.
	 */
	public textList() {
		list = new ArrayList<String>();
		textList = FXCollections.observableArrayList();
		
	}
	


	@SuppressWarnings("unchecked")
	public void savePlayList() {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("playlist.ser");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);

			list.clear();
			list.addAll(textList);

			outFile.writeObject(list);

			list.clear();

			outFile.close();

		} catch (IOException ioe) {
			System.out.println("Write failed");
		}
	}

	/**
	 * Deserializes the playlist into an observable arraylist
	 */
	@SuppressWarnings("unchecked")
	public void readPlayList() {
		try {
			FileInputStream bytesFromDisk = new FileInputStream("playlist.ser");
			ObjectInputStream inFile = new ObjectInputStream(bytesFromDisk);

			list = (ArrayList<String>) inFile.readObject();

			textList.clear();
			textList.addAll(list);

			inFile.close();

		} catch (IOException ioe) {
			System.out.println("read failed");
		} catch (ClassNotFoundException e) {
			System.out.println("Class cast exception");
			e.printStackTrace();
		}
	}

	/**
	 * Returns the current playlist object
	 * 
	 * @return playlist the song in a given playlist
	 */
	public ObservableList<String> getPlayList() {
		return this.textList;
	}

	
}
