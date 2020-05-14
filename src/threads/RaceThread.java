package threads;

import java.util.Random;

import javafx.application.Platform;
import model.AL;
import model.Control;
import model.DataStructure;
import model.LEHandler;
import ui.AlgorithmsRaceGUI;

public class RaceThread extends Thread{
	private AlgorithmsRaceGUI arGUI;
	
	private long N;
	private Random gen;
	private boolean iterative;
	private int algorithm;
	private DataStructure dataStructure;
	
	public RaceThread(AlgorithmsRaceGUI gui, long n, Random gen, boolean i, int alg, DataStructure ds) {
		this.arGUI = gui;
		this.N = n;
		this.gen = gen;
		this.iterative = i;
		this.algorithm = alg;
		this.dataStructure = ds;
	}
	
	public void run() {
		switch(algorithm) {
		case 1:
			if(iterative) addIterative();
			else addRecursive();
			break;
		case 2:
			if(iterative) searchIterative();
			else searchRecursive();
			break;
		case 3:
			if(iterative) removeIterative();
			else removeRecursive();
			break;
		}
		
		end();
	}
	
	public void end() {
		Platform.runLater(new Runnable(){

			@Override
			public void run() {
				if(dataStructure instanceof AL) {
					arGUI.getAlResult().setText(arGUI.getTimekeeper().getText());
				}
				else if(dataStructure instanceof LEHandler) {
					arGUI.getLeResult().setText(arGUI.getTimekeeper().getText());
				}
				else {
					arGUI.getAbbResult().setText(arGUI.getTimekeeper().getText());
				}
			}
		});
	}

	private void addIterative() {
		for(int i = 0; i < N; i++) {
			dataStructure.addIterative(gen.nextLong());
		}
	}
	private void searchIterative() {
		for(int i = 0; i < N; i++) {
			dataStructure.searchIterative(gen.nextLong());
		}
	}
	private void removeIterative() {
		for(int i = 0; i < N; i++) {
			dataStructure.removeIterative(gen.nextLong());
		}
	}
	
	
	private void addRecursive() {
		for(int i = 0; i < N; i++) {
			dataStructure.addRecursive(gen.nextLong());
		}
	}
	private void searchRecursive() {
		for(int i = 0; i < N; i++) {
			dataStructure.searchRecursive(gen.nextLong());
		}
	}
	private void removeRecursive() {
		for(int i = 0; i < N; i++) {
			dataStructure.removeRecursive(gen.nextLong());
		}
	}

}
