package com.dkl.memory;


public class MyArrayList<T> implements Iterable<T>{
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private T[] theItems;
	
	public MyArrayList(){
		clear();
	}

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if(newCapacity < size())
			return;
		T[] old = theItems;
		theItems = (T[])new Object[newCapacity];
		for(int i = 0; i < size(); i++){
			theItems[i] = old[i];
		}
	}

	public int size() {
		return theSize;
	}
	public T get(int idx){
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	public T set(int idx, T x){
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		T old = theItems[idx];
		theItems[idx] = x;
		return old;
	}
	public void trimToSize(){
		ensureCapacity(size());
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public boolean add(T x){
		add(size(), x);
		return true;
	}

	private void add(int idx, T x) {
		if( theItems.length == size())
			ensureCapacity(size() * 2 + 1);
		for(int i = size(); i > idx; i--)
			theItems[i + 1] = theItems[i];
		theItems[idx] = x;
	
		theSize++;
	}
	public T remove(int idx){
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		T removeItem = theItems[idx];
		for(int i = idx; i <size() - 1; i++)
			theItems[i] = theItems[i + 1];
		
		theSize--;
		return removeItem;
	}
	public java.util.Iterator<T> iterator(){
		return new MyArrayListIterator();
	}
	private class MyArrayListIterator implements java.util.Iterator<T>{
		private int current = 0;
		public boolean hasNext(){
			return current < size();
		}
		public T next(){
			if( !hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
}
