/*
 * 
 * Gijeong Lee
 * This is for Sample3.fxml
 */

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
	
	/*
	 * This is for send Button
	 * When it is pressed, it will send the text Message to another user.
	 * It will assign all the variables needed.
	 * It will use the function in SampleController
	 * It will also encode the text Message by using Huffman object and its functions.
	 */
    @FXML
    public void newsendButtonOnAction(ActionEvent e) throws IOException {
    	
        toUser = toTextField.getText();
        message = sendTextField.getText();
       
        title = titleTextField.getText();
        huffman = new Huffman(message);
        encodedText = huffman.getEncodedText();
        from = toTextField.getText();
        

        time = LocalTime.now().toString();
        newText = new text(from, title, time, huffman);

        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        root = loader.load();
        
        SampleController scene4 = loader.getController();
        accountList = scene4.getAccountList();
        
       
    }
    
    /*
     * This is for cancel Button
     * When it is pressed, it will go back to Sample2.fxml
     * It will update the accountTable which is a hashMap.
     * Then it uses updateTableView function in SampleController2.
     */
    @FXML
    public void cancelButtonOnAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
        root = loader.load();

        SampleController2 scene2 = loader.getController();

        HashMap<account, ObservableList<text>> accountTable = accountList.getHashMap();

        

        for (account accounts : accountTable.keySet()) {
           
            if (accounts.getUserName().equals(toUser)) {
                scene2.listAdd(newText, accounts);
                account = accounts;
            }
        }

        ObservableList<text> list = scene2.getList();

      

        // Update the TableView in SampleController2
        scene2.updateTableView(list, account);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}
