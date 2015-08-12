package com.dkl.generic;

public class TestMemoryCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemoryCell m = new MemoryCell();
		m.write("37");
		Object val = m.read();
		System.out.println("contents are: " + val);
	}

}
