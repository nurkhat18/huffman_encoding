package application;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Huffman;


public class SampleController3 {
	
	@FXML
	TextField toTextField;
	@FXML
	TextField sendTextField;
	@FXML
	TextField titleTextField;
	@FXML
	TextField fromTextField;
	
	private Parent root;
    private Scene scene;
    private Stage stage;
	private account account;
	private accountList accountList;
	String toUser;
	String message;
	String title;
	Huffman huffman;
	String encodedText;
	String time;
	text newText;
	String from;
	
    @FXML
    public void newsendButtonOnAction(ActionEvent e) throws IOException {
    	
        toUser = toTextField.getText();
        message = sendTextField.getText();
        System.out.println(message);
        title = titleTextField.getText();
        huffman = new Huffman(message);
        encodedText = huffman.getEncodedText();
        from = toTextField.getText();
        
        System.out.println(encodedText);
        
        
        time = LocalTime.now().toString();
        System.out.println(from);
        newText = new text(from, title, time, huffman);

        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        root = loader.load();
        
        SampleController scene4 = loader.getController();
        accountList = scene4.getAccountList();
        System.out.println(accountList);
        
       
    }
    
    @FXML
    public void cancelButtonOnAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
        root = loader.load();

        SampleController2 scene2 = loader.getController();

        HashMap<account, ObservableList<text>> accountTable = accountList.getHashMap();

        System.out.println("list: " + accountList);

        for (account accounts : accountTable.keySet()) {
            System.out.println("For 3: " + accounts.getUserName());
            if (accounts.getUserName().equals(toUser)) {
                System.out.println("DD");
                System.out.println("update: " + accounts.getUserName());
                scene2.listAdd(newText, accounts);
                account = accounts;
            }
        }

        ObservableList<text> list = scene2.getList();

        // Check if the list is null before attempting to iterate over it
        if (list != null) {
            for (text texts : list) {
                System.out.println(texts.getTitle());
            }
        }

        // Update the TableView in SampleController2
        scene2.updateTableView(list, account);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}
