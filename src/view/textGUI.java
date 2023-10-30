package view;

import java.io.Serializable;
import java.util.Optional;

import model.account;
import model.textList;

import view.LoginCreateAccountPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class textGUI extends Application implements Serializable{

		
	public static void main(String[] args) {
		launch(args);
	}

	transient LoginCreateAccountPane loginPane;
	private transient BorderPane everything;
	private transient textList textList;
	private transient ListView<textList> listview;
	private transient Button playButton;
	private transient TableView<textList> table;
	private transient ObservableList<textList> observableSongs;
	
	private transient Label songList;
	private transient Label songQueue;
	
	private transient HBox topView;
		
	private transient account user;
	
	
	/**
	 * All the layout of the main GUI
	 */
	private void LayoutGUI() {
		everything = new BorderPane();
		table = new TableView<textList>();

		user = new account("Chris", "1");
		
		loginPane = new LoginCreateAccountPane();
		everything.setPadding(new Insets(10, 10, 10, 10));

		textList = new textList();

		topView(); 
		everything.setTop(topView);

		playButton = new Button("Play");
	    everything.setCenter(playButton);
		
	    listView();
		everything.setRight(listview);
		everything.setBottom(loginPane);
		everything.setLeft(table);
		
		registerHandlers();

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void listView() {
		//listview = new ListView(textList.getPlayList());
	    listview.setMaxHeight(450);
	    listview.setMinWidth(300);
	    listview.setMouseTransparent(true);
	    listview.setFocusTraversable(false);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void tableView() {
		table.setItems(observableSongs);



		table.setMinWidth(400);
		table.setMaxSize(400, 450);
	}

	private void topView() {
		songList = new Label("Song List");
		songList.setStyle("-fx-font-size: 22;");
		
		songQueue = new Label("Song Queue");
		songQueue.setStyle("-fx-font-size: 20;");
		
		topView = new HBox(430, songList, songQueue);
		topView.setPadding(new Insets(10, 0, 0, 15));
	}
	
	
	/**
	 * This will add song objects to an observable list of songs so that the table
	 * view can access them
	 */
	private void gettingSongDetails() {
		observableSongs = FXCollections.observableArrayList();

	

	}

	
	/**
	 * This will play the song if songsPlayed is less than 3, and add in 
	 * queue if song is being played right now
	 */
	private void registerHandlers() {	
		playButton.setOnAction(event -> {
			if (loginPane.loggedInStatus() == true) {
				account user = loginPane.getUser();

				

				
			}

		});

	}

	/**
	 * If user choose to get the old playlist back, then the songs will
	 * start playing according to the old playlist, otherwise it just get
	 * a new list
	 */
	private void getPlayList() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Start up Option");
		alert.setHeaderText("Read saved data?");
		alert.setContentText("Press cancel while system testing.");

		Optional<ButtonType> result = alert.showAndWait();
		
		
	}
	
	/**
	 * This alert will be shown at the time of closing the application
	 * and if the user clicks OK, then the program will save the playlist 
	 * sequence and accounts data. And if the user clicks no, then it
	 * start from a clean slate from the next time. 
	 */
	private void closingAlertSavingChanges() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Shut down Option");
		alert.setHeaderText("Save data?");
		alert.setContentText("Press cancel while system testing.");

		Optional<ButtonType> result = alert.showAndWait();
	
	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

