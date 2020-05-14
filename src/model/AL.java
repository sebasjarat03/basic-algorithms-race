package model;

import java.util.ArrayList;

public class AL extends DataStructure{
	private ArrayList<Long> al;


	public AL() {
		al = new ArrayList<Long>();
	}

	public void addIterative(long n) {
		al.add(n );

	}

	public boolean searchIterative(long n) {
		boolean exists = false;
		for (int i = 0; i < al.size() && !exists; i++) {
			if(al.get(i)==n) {
				exists = true;
			}
		}
		return exists;
	}

	public boolean removeIterative(long n) {
		boolean removed = false;
		for (int i = 0; i < al.size() && !removed; i++) {
			if(al.get(i)==n) {
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public void addRecursive(long n) {
		al.add(n );
		
	}

	@Override
	public boolean searchRecursive(long n) {
		return searchRecursive(n, 0);
	}
	private boolean searchRecursive(long n, int idx) {
	    if(idx >= al.size() ) {
	         return false;
	     } else if(al.get(idx)== n) {
	         return true;
	     } else{
	         return searchRecursive(n, idx+1);
	     }
	}

	@Override
	public boolean removeRecursive(long n) {
		return removeRecursive(n, 0);
	}
	
	private boolean removeRecursive(long n, int idx) {
	    if(idx >= al.size() ) {
	         return false;
	     } else if(al.get(idx)== n) {
	    	 al.remove(idx);
	         return true;
	     } else{
	         return searchRecursive(n, idx+1);
	     }
	}

}
