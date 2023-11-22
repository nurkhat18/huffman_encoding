/*
 * Gijeong Lee
 * This is for Sample2.fxml
 */

package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Huffman;


public class SampleController2 implements Initializable{
	
	@FXML
	TextArea textArea;
	
	@FXML
    TableView<text> tableView = new TableView<text>();
    @FXML
    TableColumn<text, String> userColumn;
    @FXML
    TableColumn<text, String> title;
    @FXML
    TableColumn<text, String> time;
    @FXML
    Button decodeButton;
	
	private Parent root;
    private Scene scene;
    private Stage stage;
    private String decodedText;
    private accountList accountList;
    private String userName;
    private account account;
    
    
    ObservableList<text> list;
    HashMap<account, ObservableList<text>> accountsTable;
  
    /*
     * This is for TableView.
     * It assigns each column of TableView.
     * Then it uses some functions in SampleController
     * It gets observable list based on the account
     */
    public void initialize(URL url, ResourceBundle resource) {
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        	
        SampleController scene5 = loader.getController();
        accountList = scene5.getAccountList();
        accountsTable = accountList.getHashMap();
        account = scene5.getAccount();

        // Ensure the account has its own list
        ObservableList<text> list = accountsTable.get(account);
        if (list == null) {
            list = FXCollections.observableArrayList();
            accountsTable.put(account, list);
        }
        
        // Set the TableView to display the correct list
        tableView.setItems(list);
    }


	/*
	 * show the content on textArea.
	 */
	public void add(String content)
	{
		textArea.setText(content);
	}
	
	/*
	 * it adds newText which is an text Object
	 * and its account which is newAccount
	 * it gets the observable list by using newAccount which is an account object and key.
	 * then, it updates the list.
	 */
	public void listAdd(text newText, account newAccount) {
	    accountsTable = accountList.getHashMap();
	    
	    // Ensure the recipient account has its own list
	    ObservableList<text> list = accountsTable.get(newAccount);
	    if (list == null) {
	        list = FXCollections.observableArrayList();
	        accountsTable.put(newAccount, list);
	    }
	    
	    list.add(newText);

	    // Only update the TableView if the message is added to the current account's list
	    if (account.getUserName().equals(newAccount.getUserName())) {
	        tableView.setItems(list);
	    }
	}
	
		/*
		 * This is for send Button.
		 * When it is pressed, it will switch to Sample3.fxml.
		 */
    @FXML
    public void sendButtonOnAction(ActionEvent e) throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample3.fxml"));
		  root = loader.load();
		  
		  SampleController3 scene3 = loader.getController();
		  
		  stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
    }

    /*
     * It is for log out Button
     * This is for going back to log in scene which is Sample.fxml
     * It gets the logged in account.
     */
	@FXML
	public void logoutButtonOnAction(ActionEvent e) throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
	      root = loader.load();
	      
	      SampleController scene1 = loader.getController();
	      account = scene1.getAccount();
	      
	      
	      stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	      scene = new Scene(root);
	      stage.setScene(scene);
	      stage.show();
	}
	
	/*
	 * It is for decode Button.
	 * When it is pressed, it will show the encoded text and decoded text of
	 * selected one on TableView.
	 */
	@FXML
	public void decodeButtonOnAction(ActionEvent e) throws IOException {
		
		 int index = tableView.getSelectionModel().getSelectedIndex();
		 tableView.getSelectionModel().select(index);
		 text selectedText = list.get(index);
		 String encodedText = selectedText.getHuffman().getEncodedText();
		 String decodedText = selectedText.getHuffman().decode(encodedText);
		 
		 
		 textArea.setText("Encoded Text: " + encodedText + "\n" + "Decded Text: " + decodedText);
		
		 
	}
	
	public accountList getAccountList()
    {
    	return accountList;
    }
	
	/*
	 * This is for updating the TableView.
	 * It checks whether it uses the correct list by using compare which is an account object
	 */
	public void updateTableView(ObservableList<text> newList, account compare) {
		if(account.getUserName().equals(compare.getUserName()))
		{
			tableView.refresh();
			list = accountsTable.get(compare);
			tableView.setItems(list);
		}
		
	}

	/*
	 * It returns list
	 */
	public ObservableList<text> getList()
	{
		return list;
	}
	
	/*
	 * it assign account to newaccount.
	 * then it updates the tableView.
	 * 
	 */
	public void getAccount2(account newaccount)
	{
		account = newaccount;
		list = accountsTable.get(account);
        
        tableView.setItems(list);	
	}
}
