package model;

public class ABB {
	private long n;
	private ABB parent;
	private ABB leftNode;
	private ABB rightNode;
	
	public ABB(long n) {
		this.n = n;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public ABB getParent() {
		return parent;
	}

	public void setParent(ABB parent) {
		this.parent = parent;
	}

	public ABB getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(ABB leftNode) {
		this.leftNode = leftNode;
	}

	public ABB getRightNode() {
		return rightNode;
	}

	public void setRightNode(ABB rightNode) {
		this.rightNode = rightNode;
	}
	
	public long compareTo(long num) {
		return this.n - num;
	}
	public boolean equals(long value) {
		return this.n == value;
	}

}
