import java.util.*;


public class BST<T extends Comparable<T>>{

	private BSTNode root; 
	 
	public BST(){			
		root =null; 		
	}

	private class BSTNode{
		 
		BSTNode(Comparable value){
			data = value;
			left = right = null;
		}

		Comparable data;
		BSTNode left; 
		BSTNode right;
	}


								
	public void insert(Comparable value){ 
		root = insert(root, value);
	}


	//
	private BSTNode insert(BSTNode root, Comparable value){ 
		if(root == null){
			BSTNode newnode = new BSTNode(value);					 
			return newnode;
		}else if(root.data.compareTo(value) < 0){
			root.right = insert(root.right, value);
			return root;											

		}else{
			root.left = insert(root.left, value);					
			return root;
		}

		
	}

	public boolean find(Comparable value){		
		return findFunction(root, value);				


	}

	public boolean findFunction(BSTNode node, Comparable value){ 
		while(node!= null ){
			if(node.data.compareTo(value) == 0){		 
				return true;							
			}else if(node.data.compareTo(value) >0){	 
				return findFunction(node.left, value);
			}else{
				return findFunction(node.right, value);			
			}
	
		}
		return false;
	}

	public void print(){
		print(root);    
	}

	private void print(BSTNode node){   
		if (node!= null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	public void delete(Comparable value){ 	
		root = delete(value, root);
	}

	
	protected BSTNode delete(Comparable value, BSTNode root){
		if( root == null){
			return null;

		}else if(value.compareTo(root.data) < 0){
			root.left = delete(value, root.left);
		}else if(value.compareTo(root.data) > 0){
			root.right = delete(value, root.right);
		}else{
			if(root.left == null){
				return root.right; 
			}if(root.right == null){
				return root.left; 
		
			}
		}
		return root;
	}
}