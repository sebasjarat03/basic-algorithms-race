package model;

public class ABBHandler extends DataStructure{
	private ABB root;
	public ABBHandler() {
		
	}
	public void addIterative(long n) {
		ABB parent = root;
		ABB child = root;
		ABB newNode = new ABB(n);
		
		boolean setToRight = false;
		while(child != null) {
			parent = child;
			if(parent.compareTo(n) < 0) {
				child = parent.getRightNode();
				setToRight = true;
			}else {
				child = parent.getLeftNode();
				setToRight = false;
			}
		}
		child = newNode;
		child.setParent(parent);
		
		if(root == null) {
			root = child;
		}else if(setToRight) {
			parent.setRightNode(newNode);
		}else{
			parent.setLeftNode(newNode);
		}
	}

	@Override
	public boolean searchIterative(long n) {
		ABB actual = root;
		boolean found = false;
		
		while(actual != null && !found) {
			if(actual.compareTo(n) < 0) {
				actual = actual.getRightNode();
			}else if(actual.compareTo(n) > 0){
				actual = actual.getLeftNode();
			}else {
				found = true;
			}
		}
		return found;
	}
	
	//DELETE
	@Override
	public boolean removeIterative(long n){
		ABB current = root;
		ABB parent = root;
        boolean isLeftChild = false;
        while(!current.equals(n)){
            parent = current;
            if(current.compareTo(n) > 0){
                current = current.getLeftNode();
                isLeftChild = true;
            }
            else{
                current = current.getRightNode();
                isLeftChild = false;
            }
            if(current == null){
                return false;
            }
        }
        
        if(current.getLeftNode() == null && current.getRightNode() == null){
            if(current == root){
                root = null;
            }
            else if(isLeftChild){
                parent.setLeftNode(null);
            }
            else{
                parent.setRightNode(null);
            }
        }
        
        else if(current.getLeftNode() == null){
            if(current == root){
                root = current.getRightNode();
            }
            else if(isLeftChild){
                parent.setLeftNode(current.getRightNode());
            }
            else{
                parent.setRightNode(current.getRightNode());
            }
        }
        else if(current.getRightNode() == null){
            if(current == root){
                root = current.getLeftNode();
            }
            else if(isLeftChild){
                parent.setLeftNode(current.getLeftNode());
            }
            else{
                parent.setRightNode(current.getLeftNode());
            }
        }
        else{            
        	ABB successor = findSuccessor(current);
            if(current == root){
                root = successor;
            }
            else if(isLeftChild){
                parent.setLeftNode(successor);
            }
            else{
                parent.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        }
        return true;
    }
    private ABB findSuccessor(ABB node){
        ABB successor = node;
        ABB successorParent = node;

        ABB current = node.getRightNode();
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        
        if(successor != node.getRightNode()){
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(node.getRightNode());
        }
        return successor;
    }

	
	public void addRecursive(long n) {
		ABB newNode = new ABB(n);
		if(root == null) {
			root = newNode;
		}else {
			addRecursive(root, newNode);
		}
	}
	private void addRecursive(ABB nodeInTree, ABB newNode) {
		if(nodeInTree.compareTo(newNode.getN()) > 0) {
			if(nodeInTree.getLeftNode() != null) {
				addRecursive(nodeInTree.getLeftNode(), newNode);
			}else {
				newNode.setParent(nodeInTree);
				nodeInTree.setLeftNode(newNode);
			}
		}else {
			if(nodeInTree.getRightNode() != null) {
				addRecursive(nodeInTree.getRightNode(), newNode);
			}else {
				newNode.setParent(nodeInTree);
				nodeInTree.setRightNode(newNode);
			}
		}
	}
	
	////SEARCH
	@Override
	public boolean searchRecursive(long n) {
		return searchRecursive(root, n);
	}
	private boolean searchRecursive(ABB nodeInTree, long n) {
		if(nodeInTree == null) {
			return false;
		}else {
			boolean found = false;
			
			if(nodeInTree.compareTo(n) < 0) {
				found = searchRecursive(nodeInTree.getLeftNode(), n);
			}else if(nodeInTree.compareTo(n) > 0){
				found = searchRecursive(nodeInTree.getRightNode(), n);
			}else {
				found = true;
			}
			
			return found;
		}
	}
	
	////DELETE
	@Override
	public boolean removeRecursive(long n) { 
        return (removeRecursive(root, n) == null) ? false : true; 
    }
    private ABB removeRecursive(ABB node, long n) { 
        if (node == null) {
        	return node; 
        }
        if (node.compareTo(n) > 0) { 
            node.setLeftNode(removeRecursive(node.getLeftNode(), n)); 
        }else if (node.compareTo(n) < 0) {
        	node.setRightNode(removeRecursive(node.getRightNode(), n)); 
        }else{
            if (node.getLeftNode()== null) {
            	return node.getRightNode();
            }else if (node.getRightNode() == null) {
                return node.getLeftNode();
            }
            node.setN(minValue(node.getRightNode()).getN()); 
            node.setRightNode(removeRecursive(node.getRightNode(), node.getN())); 
        }
        
        return node; 
    } 
	private ABB minValue(ABB node) { 
    	ABB minValue = node; 
        while (node.getLeftNode() != null) { 
            minValue = node.getLeftNode(); 
            node = node.getLeftNode(); 
        } 
        return minValue; 
    }

}
