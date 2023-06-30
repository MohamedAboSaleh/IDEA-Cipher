package idea_cipher;

import gui.ViewOrSendConroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Starts IDEA cipher GUI.
 */
public class MainApp extends Application{
	public static boolean mails=false;
	public static boolean waiting=true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*final Parent root = FXMLLoader.load(getClass().getResource("/fxml/gui.fxml"));
        final Scene scene = new Scene(root);
        primaryStage.setTitle("IDEA cipher");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();*/

    	ViewOrSendConroller aFrame = new ViewOrSendConroller();
		aFrame.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
