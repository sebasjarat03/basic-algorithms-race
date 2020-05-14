package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import model.Control;
import threads.CirclesThread;
import threads.Timekeeper;

public class AlgorithmsRaceGUI {
	
	private CirclesThread crt;
	
	private Timekeeper tmk;
	
	private Control c;
	
	private boolean runningRace;
	
	public AlgorithmsRaceGUI() {
		runningRace = false;
		this.c = new Control(this);
	}
	
	@FXML
    private TextField numberField;

    @FXML
    private RadioButton addRButton;

    @FXML
    private ToggleGroup algorithm;

    @FXML
    private RadioButton searchRButton;

    @FXML
    private RadioButton deleteRButton;

    @FXML
    private RadioButton iterRButton;

    @FXML
    private ToggleGroup mode;

    @FXML
    private RadioButton recursRButton;

    @FXML
    private Button runButton;

    @FXML
    private Label timekeeper;

    @FXML
    private Circle circleOne;

    @FXML
    private Circle circleTwo;

    @FXML
    private Label alResult;

    @FXML
    private Label leResult;

    @FXML
    private Label abbResult;

    @FXML
    public void runRace(ActionEvent event) {
    	alResult.setText("00:00:00");
		abbResult.setText("00:00:00");
		leResult.setText("00:00:00");
    	try {
    		long N = Long.parseLong(numberField.getText());
    		RadioButton selected = (RadioButton) mode.getSelectedToggle();
    		String selectedMode = selected.getText();
    		RadioButton selectedAlg = (RadioButton) algorithm.getSelectedToggle();
    		String selectedAlgorithm = selectedAlg.getText();
    		c.startRace(N, selectedMode, selectedAlgorithm);
    		runningRace = true;
    		startCircleAnim();
    		startTimekeeper();
    		
        	//runButton.setDisable(true);
        	
        	class Handler extends Thread {
        		public void run() {
        			while(c.raceRunning()) {
        				runButton.setDisable(true);
        				
        				
        			}
        			runningRace= false;
        			
        			Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							runButton.setDisable(false);
		        			numberField.setText("");
		        			
		        			timekeeper.setText("00:00:00");
							
						}
					}); 
        			
        		}
        	}
        	
        	Handler raceHandler = new Handler();
        	raceHandler.start();
    	}
    	catch(Exception e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error reading number or you had not selected all the fields!");
        	alert.setContentText("You may introduced invalid info on the text field \nOr maybe you have not selected the mode or the action");

        	alert.showAndWait();
    	}
    	
    	

    }
    
    public void animateCircles(double c1R, double c2R) {
    	circleOne.setRadius(c1R);
    	circleTwo.setRadius(c2R);
    }
    
    public void updateTime(String time) {
    	timekeeper.setText(time);
    }

	public Label getAlResult() {
		return alResult;
	}

	public void setAlResult(Label alResult) {
		this.alResult = alResult;
	}

	public Label getLeResult() {
		return leResult;
	}

	public void setLeResult(Label leResult) {
		this.leResult = leResult;
	}

	public Label getAbbResult() {
		return abbResult;
	}

	public void setAbbResult(Label abbResult) {
		this.abbResult = abbResult;
	}

	public Label getTimekeeper() {
		return timekeeper;
	}

	public void setTimekeeper(Label timekeeper) {
		this.timekeeper = timekeeper;
	}

	public boolean isRunningRace() {
		return runningRace;
	}

	public void setRunningRace(boolean runningRace) {
		this.runningRace = runningRace;
	}
	
	public void startCircleAnim() {
		crt = new CirclesThread(this, circleOne.getRadius(), circleTwo.getRadius());
    	
    	crt.start();
    	
	}
	
	public void startTimekeeper() {
		tmk = new Timekeeper(this);
		tmk.start();
	}
    
    

}
