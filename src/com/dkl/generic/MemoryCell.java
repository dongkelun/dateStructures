package com.dkl.generic;

public class MemoryCell {
	public Object read(){	return storedValue;	}
	public void write(Object x){	storedValue = x;	}
	private Object storedValue;
}
