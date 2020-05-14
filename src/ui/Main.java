package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	
	public Main() {
		algorithmsRaceGUI = new AlgorithmsRaceGUI();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("algorithm-race.fxml"));
		fxml.setController(algorithmsRaceGUI);
		Parent root = fxml.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Algorithms race");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
