package model;

public class LE {
	
	private LE next;
	

	private long n;
	
	public LE(long number) {
		this.n = number;
	}

	public LE getNext() {
		return next;
	}

	public void setNext(LE next) {
		this.next = next;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}
	
	public boolean equals(long n) {
		return this.n == n;
	}

}
