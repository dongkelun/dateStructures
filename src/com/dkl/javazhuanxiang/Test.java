package com.dkl.javazhuanxiang;

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }
 
    public static void main(String[] args) {
       
    	byte b1 = 1, b2 = 2, b3, b6;
    	final byte b4 = 4, b5 = 5;
    	b6 = b4 +b5;
    	b3 = (byte) (b1 + b2);
    	System.out.println(b6+b3);
    	new Test();
    }
}
