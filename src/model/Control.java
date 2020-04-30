package model;

import java.util.ArrayList;

public class Control {
	
	private ArrayList<AL> al;
	
	public Control() {
		al = new ArrayList<AL>();
	}
	
	public ArrayList<Long> generateNumbers(long N){
		ArrayList<Long> numbers = new ArrayList<Long>();
		Long num;
		for (int i = 0; i <= N; i++) {
			num = (long) Math.random()*(Long.MIN_VALUE-Long.MAX_VALUE)+Long.MAX_VALUE;
			numbers.add(num);
		}
		return numbers;
	}
	
	
	public void addAl(ArrayList<Long> nums) {
		for (int i = 0; i < nums.size(); i++) {
			al.add(new AL(nums.get(i)) );
		}
	}
	
	public boolean searchIterAl(long n) {
		boolean exists = false;
		for (int i = 0; i < al.size() && !exists; i++) {
			if(al.get(i).getN()==n) {
				exists = true;
			}
		}
		return exists;
	}

}
