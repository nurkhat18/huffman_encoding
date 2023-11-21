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
    Huffman huff = new Huffman("HI");
    ObservableList<text> list;
    HashMap<account, ObservableList<text>> accountsTable;
  
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

	public void get() {
		System.out.println(textArea.getText());
	}
	
	public void add(String content)
	{
		textArea.setText(content);
	}
	
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


	@FXML
	public void logoutButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
	      root = loader.load();
	      
	      SampleController scene1 = loader.getController();
	      account = scene1.getAccount();
	      System.out.println("account: " + account.getUserName());
	      
	      stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	      scene = new Scene(root);
	      stage.setScene(scene);
	      stage.show();
	}
	
	@FXML
	public void decodeButtonOnAction(ActionEvent e) throws IOException {
		System.out.println("DECD");
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
	
	public void updateTableView(ObservableList<text> newList, account compare) {
		if(account.getUserName().equals(compare.getUserName()))
		{
			tableView.refresh();
			list = accountsTable.get(compare);
			for(text texts : list)
			{
				System.out.println("TEST UPDATE " + texts.getTitle());
			}
			tableView.setItems(list);
		}
		
	}

	public ObservableList<text> getList()
	{
		return list;
	}
	
	public void getAccount2(account newaccount)
	{
		account = newaccount;
		list = accountsTable.get(account);
        
        for(account accounts: accountsTable.keySet()) {
        	System.out.println("USER NAME: " + accounts.getUserName());
        	for(text texts: accountsTable.get(accounts))
        	{
        		
        		System.out.println("get USER : " + texts.getUser());
        	}
        }
        
        tableView.setItems(list);	
	}
}
