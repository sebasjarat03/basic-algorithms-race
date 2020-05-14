package threads;

import javafx.application.Platform;
import ui.AlgorithmsRaceGUI;

public class Timekeeper extends Thread{
private AlgorithmsRaceGUI arGUI;
	
	public Timekeeper(AlgorithmsRaceGUI arGUI) {
		this.arGUI = arGUI;
	}
	
	public void run() {
		long time = 0;
		while (arGUI.isRunningRace()){
			updateLabels(time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error while trying to sleep");
			}
			time++;
		}
	}
	
	private void updateLabels(long timeCounter) {
		
		long seconds = (timeCounter)%60;
		long minutes = (timeCounter/60)%60;
		long hours = (timeCounter/3600)%24;
		String secondsS = seconds<10 ? ("0" + seconds) : ""+ seconds;
		String minutesS = minutes<10 ? ("0" + minutes) : ""+ minutes;
		String hoursS = hours<10 ? ("0" + hours) : ""+ hours;
		String textTimer = hoursS+":"+minutesS+":"+secondsS;
		
		Platform.runLater(new Runnable(){
		
			@Override
			public void run() {
				arGUI.updateTime(textTimer);
			}
		});
		
	}
	
}
