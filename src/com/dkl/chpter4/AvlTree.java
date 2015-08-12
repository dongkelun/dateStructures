package com.dkl.chpter4;

public class AvlTree<T extends Comparable<? super T>> {
	
	public AvlTree(){
		root = null;
	}
	
	public boolean contains(T x){
		return contains(x, root);
	}
	
	private boolean contains(T x, AvlNode<T> t) {
		if(t == null)
			return false;
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
			return contains(x, t.left);
		else if(compareResult > 0)
			return contains(x, t.right);
		else
			return true;
			
	}

	private AvlNode<T> insert(T x, AvlNode<T> t){
		if(t == null)
			return new AvlNode<T>(x, null , null);
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0){
			t.left = insert(x, t.left);
			if(height(t.left) - height(t.right) == 2)
				if(x.compareTo(t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else 
					t = doubleWithLeftChild(t);
		}else if(compareResult > 0){
			t.right = insert(x, t.right);
			if(height(t.right) - height(t.left) == 2)
				if(x.compareTo(t.right.element) > 0)
					t = rotateWithRightChild(t);
				else 
					t = doubleWithRightChild(t);
		}
		
		return t;
		
	}
	private AvlNode<T> doubleWithRightChild(AvlNode<T> t) {
		t.right = rotateWithLeftChild(t.right);
		return rotateWithRightChild(t);
	}

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> t) {
		t.left = rotateWithRightChild(t.left);
		return rotateWithLeftChild(t);
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right)) +1;
		k1.height = Math.max(height(k1.left), height(k1.right)) +1;
		
		return k1;
	}
	private static class AvlNode<T>{
		
		public AvlNode(T theElement){
			this(theElement, null, null);
		}
		public AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt){
			element = theElement;
			left = lt;
			right = rt;
			height = 0;
		}
		T element;
		AvlNode<T> left;
		AvlNode<T> right;
		int height;
	}
	/**
	 * return the height of node t, or -1, if null
	 */
	private int height(AvlNode<T> t){
		return t == null ? -1 : t.height;
	}
	
	
	AvlNode<T> root;
}
