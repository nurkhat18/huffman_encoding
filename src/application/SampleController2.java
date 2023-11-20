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
    TableView<text> tableView;
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
  
    @Override
    public void initialize(URL url, ResourceBundle resource) {
    	userColumn.setCellValueFactory(new PropertyValueFactory<text, String>("user"));
    	title.setCellValueFactory(new PropertyValueFactory<text, String>("title"));
    	time.setCellValueFactory(new PropertyValueFactory<text, String>("time"));
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        SampleController scene5 = loader.getController();
        accountList = scene5.getAccountList();
        account = scene5.getAccount();
        
        accountsTable = accountList.getHashMap();
        list = accountsTable.get(account);
//        System.out.println(account.getUserName());
    	tableView.setItems(list);
    }
	
	public void get() {
		System.out.println(textArea.getText());
	}
	
	public void add(String content)
	{
		textArea.setText(content);
	}
	
	public void listAdd(text newText, account account) {
		list = account.returnList();
		list.add(newText);
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
	      Main m = new Main();
	      m.changeScene("Sample.fxml");
	}
	
	@FXML
	public void decodeButtonOnAction(ActionEvent e) throws IOException {
		System.out.println("DECD");
		 int index = tableView.getSelectionModel().getSelectedIndex();
		 tableView.getSelectionModel().select(index);
		 text selectedText = list.get(index);
		 String encodedText = selectedText.getHuffman().getEncodedText();
		 String decodedText = selectedText.getHuffman().decode(encodedText);
		 
		 textArea.setText(decodedText);
	}
	
	public accountList getAccountList()
    {
    	return accountList;
    }

}
