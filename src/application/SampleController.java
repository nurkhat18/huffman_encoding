package application;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Huffman;

public class SampleController {

    private textList textList = new textList();
    private accountList accountList = new accountList();

    @FXML
    private Button loginButton;
    @FXML
    private Button signinButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button sendButton;
    @FXML
    private Button decodeButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button newsendButton;
    @FXML
    private TextField toTextField;
    @FXML
    private TextField sendTextField;
    @FXML
    private TextField titleTextField;
    @FXML
    private Button logoutButton;

    @FXML
    private TextArea textArea;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private String userName;
    private account account;
    private 
    
    @FXML
    void loginButtonOnAction(ActionEvent e) throws IOException {
        if (!accountList.checkUser(usernameTextField.getText(), passwordPasswordField.getText())) {
            loginMessageLabel.setText("Please enter correct username and password.");
        } else {
        	HashMap<account, ObservableList<text>> accountTable = accountList.getHashMap();
        	userName = usernameTextField.getText();
        	for(account accounts: accountTable.keySet())
        	{
        		if(accounts.getUserName().equals(userName))
        		{
        			System.out.println("dd");
        			account = accounts;
        		}
        	}
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
            root = loader.load();
            
            SampleController2 scene2 = loader.getController();
            scene2.get();
            
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
    }

    @FXML
    public void signinButtonOnAction(ActionEvent e) {
        if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank()) {
            loginMessageLabel.setText("Please enter username and password to sign in.");
        } else {
        	accountList.add(usernameTextField.getText(), passwordPasswordField.getText());
            loginMessageLabel.setText("Your account is created!");
            usernameTextField.clear();
            passwordPasswordField.clear();
        }
    }


    
    public accountList getAccountList()
    {
    	System.out.println(accountList);
    	return accountList;
    }

    
    public account getAccount()
    {
//    	System.out.println(account.getUserName());
    	return account;
    }

//    @FXML
//    public void logoutButtonOnAction(ActionEvent e) throws IOException {
//    	System.out.println(textArea.getText());
////        Main.changeScene("Sample.fxml");
//    }
    
 

}
