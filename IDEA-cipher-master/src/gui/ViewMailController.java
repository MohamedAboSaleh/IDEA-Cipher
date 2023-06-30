package gui;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import hash.SHA;
import idea_cipher.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modes.FileCipher;
import modes.OperationMode;
import signature.Verify;

public class ViewMailController implements Initializable {

	@FXML
	private TextArea mail_txt;

	private FileCipher task;
	@FXML
	void decrypt_txt(ActionEvent event) {

		
		MainApp.mails=false;
		MainApp.waiting=true;
		boolean encrypt = false;
		OperationMode.Mode mode = OperationMode.Mode.OFB;
		 task = new FileCipher("out.txt", "out1.txt", "", encrypt, mode);
		 new Thread(task).start();
		 while(MainApp.waiting);
		 StringBuilder stringBuilder = new StringBuilder();
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader("out1.txt"));
				while (in.ready()) {
					stringBuilder.append(in.readLine());
					stringBuilder.append("\n");
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mail_txt.setText(stringBuilder.toString());
			mail_txt.setText(mail_txt.getText().substring(0, mail_txt.getText().length()-1));
			try {
				
				System.out.println(mail_txt.getText().charAt(mail_txt.getText().length()-1)=='\n');
				SHA.getSHA(mail_txt.getText());
				System.out.println(mail_txt.getText());
				byte[] bytes=SHA.digest.getBytes();
				long val = 0;
				for (byte b : bytes) {
				    val= (val << 8) + (b & 0xFF);
				}
				System.out.println("val1 "+val);
				Verify verify=new Verify(WriteEmailController.sign.p, WriteEmailController.sign.alpha, WriteEmailController.sign.yA, val%20, WriteEmailController.sign.r, WriteEmailController.sign.s);
				verify.verified();
				//Verify verify=new  
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Verify verify
	}

	@FXML
	void goBack(ActionEvent event) {
		// Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		ViewOrSendConroller viewOrSendConroller = new ViewOrSendConroller();
		try {
			viewOrSendConroller.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("out.txt"));
			while (in.ready()) {
				stringBuilder.append(in.readLine());
				stringBuilder.append("\n");
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mail_txt.setText(stringBuilder.toString());
	}

	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewMail.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Idea Cipher");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
