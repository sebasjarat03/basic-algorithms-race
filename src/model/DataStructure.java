package model;

public abstract class DataStructure {
	public DataStructure() {
		
	}
	public abstract void addIterative(long n);
	public abstract boolean searchIterative(long n);
	public abstract boolean removeIterative(long n);
	
	public abstract void addRecursive(long n);
	public abstract boolean searchRecursive(long n);
	public abstract boolean removeRecursive(long n);

}
