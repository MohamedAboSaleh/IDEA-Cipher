package gui;

import java.net.URL;
import java.util.ResourceBundle;

import idea_cipher.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewOrSendConroller implements Initializable{

    @FXML
    private Button viewBtn;

    @FXML
    void exitSystem(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void viewMails(ActionEvent event) {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	ViewMailController viewMailController=new ViewMailController();
    	try {
    		viewMailController.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void writeMails(ActionEvent event) {

    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	WriteEmailController writeEmailController=new WriteEmailController();
    	try {
			writeEmailController.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(!MainApp.mails)
			viewBtn.setDisable(true);
	}
	

	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewOrSend.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Idea Cipher");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
