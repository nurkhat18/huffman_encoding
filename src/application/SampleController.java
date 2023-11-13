package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class SampleController {
	
	private textList textList = new textList();
	
	private account account = new account();	
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
	
	
	
	
	public void loginButtonOnAction(ActionEvent e) throws IOException {
		
		if(!account.checkUser(usernameTextField.getText(), passwordPasswordField.getText()))
		{
			loginMessageLabel.setText("Please enter correct username and password.");
		}
		
		else{
			loginMessageLabel.setText("Log in!");
			Main m = new Main();
			m.changeScene("Sample2.fxml");
			
		}
	}
	
	public void signinButtonOnAction(ActionEvent e)
	{
		
		if(usernameTextField.getText().isBlank() == true || passwordPasswordField.getText().isBlank() == true) {
			
			loginMessageLabel.setText("Please enter username and password to sign in.");
		}
		
		else {
			account.add(usernameTextField.getText(), passwordPasswordField.getText());
			loginMessageLabel.setText("Your account is created!");
			usernameTextField.clear();
			passwordPasswordField.clear();
			
		}
	
	}
	
	public void sendButtonOnAction(ActionEvent e) throws IOException
	{
		
		Main m = new Main();
		m.changeScene("Sample3.fxml");
	}
	
	public void cancelButtonOnAction(ActionEvent e) throws IOException
	{
		
		Main m = new Main();
		m.changeScene("Sample2.fxml");
	}
	
	public void newsendButtonOnAction(ActionEvent e) throws IOException
	{
		String toUser = toTextField.getText();
		String message = sendTextField.getText();
		String title = titleTextField.getText();		
		
	}
	
	public void logoutButtonOnAction(ActionEvent e) throws IOException
	{
		
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
}
