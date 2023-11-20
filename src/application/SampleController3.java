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
	
	private Parent root;
    private Scene scene;
    private Stage stage;
	private account account;
	private accountList accountList;
	
    @FXML
    public void newsendButtonOnAction(ActionEvent e) throws IOException {
    	
 
        String toUser = toTextField.getText();
        String message = sendTextField.getText();
        System.out.println(message);
        String title = titleTextField.getText();
        Huffman huffman = new Huffman(message);
        String encodedText = huffman.getEncodedText();
       
        
        System.out.println(encodedText);
        
        
        String time = LocalTime.now().toString();
        text newText = new text(toUser, title, time, huffman);

        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
        root = loader.load();
        
        SampleController2 scene2 = loader.getController();
        accountList = scene2.getAccountList();
        HashMap<account, ObservableList<text>> accountTable = accountList.getHashMap();
        
        
        for(account accounts: accountTable.keySet())
        {
        	System.out.println(accounts.getUserName());
        	if(accounts.getUserName().equals(toUser)) {
        		System.out.println("DD");
        		ObservableList<text> list = accountTable.get(accounts);
        		list.add(newText);
        	}
        }
        
        
//        account = 
//        scene2.listAdd(newText);
        
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void cancelButtonOnAction(ActionEvent e) throws IOException {
        Main.changeScene("Sample2.fxml");
    }
    
  
    

}
