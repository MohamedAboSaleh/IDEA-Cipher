package gui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import hash.SHA;
import idea_cipher.MainApp;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import modes.FileCipher;
import modes.OperationMode;
import signature.signAlgo;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class WriteEmailController implements Initializable {

	@FXML
	private TextArea mail_txt;

	@FXML
	private TextField key_txt;

	private FileCipher task;
	@FXML
	private Button send_btn;

	public static signAlgo sign;
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

	@FXML
	void sendMail(ActionEvent event) {

		if (mail_txt.getText().equals("")) {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("the text is empty");
			a.setHeaderText("Error");
			a.showAndWait();
		} else if (key_txt.getText().equals("")) {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("the key text is empty");
			a.setHeaderText("Error");
			a.showAndWait();
		} else {
			
			try {
				SHA.getSHA(mail_txt.getText());
				byte[] bytes=SHA.digest.getBytes();
				long val = 0;
				for (byte b : bytes) {
				    val= (val << 8) + (b & 0xFF);
				}
				System.out.println(mail_txt.getText());
				System.out.println("val2 "+val);
				sign=new signAlgo(19,10,val);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			send_btn.setDisable(true);
			String str = mail_txt.getText();
			File file = new File("in.txt");
			byte[] byteArr = str.getBytes();

			try {
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(byteArr, 0, byteArr.length);
				bos.flush();
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean encrypt = true;
			OperationMode.Mode mode = OperationMode.Mode.OFB;
			MainApp.mails = true;
			MainApp.waiting = true;
			task = new FileCipher("in.txt", "out.txt", key_txt.getText(), encrypt, mode);
			new Thread(task).start();

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/WriteEmail.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Idea Cipher");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
