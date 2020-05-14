package model;

public class LEHandler extends DataStructure{
	
	private LE first;
	public LEHandler() {
		
	}
	
	
	public void addIterative(long n) {
		if(first!=null) {
			LE current = first;
			while(current.getNext()!= null) {
				current = current.getNext();
			}
			current.setNext(new LE(n));
			
		}
		else {
			first = new LE (n);
		}
	}
	
	public boolean searchIterative(long n) {
		boolean found = false;
		LE lookingFor = new LE(n);
		LE current = first;
		while(current!=null && !found) {
			if(current.equals(lookingFor)) {
				found = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	
	public boolean removeIterative(long n) {
		boolean removed = false;
		LE toRemove = new LE(n);
		
		if(first.equals(toRemove)) {
			first = first.getNext();
			removed = true;
		}
		else {
			LE prev = first;
			while(prev!=null && !removed) {
				if(prev.getNext()!=null && prev.getNext().equals(toRemove)) {
					prev.setNext(prev.getNext().getNext());
					removed=true;
				}
				prev = prev.getNext();
			}
		}
		return removed;
	}
	
	public void addRecursive(long n) {
		LE temp = new LE(n);
		if(first==null) {
			first = temp;
		}
		else {
			addRecursive(first, temp);
		}
	}
	
	private void addRecursive(LE aux, LE newEle) {
		if(aux.getNext()==null) {
			aux.setNext(newEle);
		}
		else {
			addRecursive(aux.getNext(), newEle);
		}
	}
	
	public boolean searchRecursive(long n) {
		boolean found = searchRecursive(first, n);
		return found;
	}
	
	private boolean searchRecursive(LE aux, long n) {
		LE temp = new LE(n);
		boolean found = false;
		if(aux==null) {
			found = false;
		}
		else {
			if(aux.equals(temp)) {
				found = true;
			}
			else {
				searchRecursive(aux.getNext(), n);
			}
		}
		return found;
	}
	
	public boolean removeRecursive(long n) {
		boolean removed = false;
		
			removed = removeRecursive(first, n);
		
		return removed;
	}

	private boolean removeRecursive(LE aux, long n) {
		LE temp = new LE(n);
		boolean removed = false;
		if(aux.equals(temp)) {
			aux = aux.getNext();
			removed = true;
		}
		
		if(aux!=null) {
			if(aux.getNext()!=null) {
				if(aux.getNext().equals(temp)) {
					aux.setNext(aux.getNext().getNext());
					removed = true;
				}
				else {
					removed = removeRecursive(aux.getNext(), n);
				}
			}
		}
		return removed;
	}
	
	
}
