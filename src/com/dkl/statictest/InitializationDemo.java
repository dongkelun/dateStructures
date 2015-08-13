package com.dkl.statictest;


public class InitializationDemo {
	 
    public static void main(String[] args) {
        new InitializationDemo();
    }
     
    public InitializationDemo() {
         
        new B();
    }
     
    {
        System.out.println("2. Initialization 的实例块。");
    }
     
    static {
        System.out.println("1. Initialization 的静态块。");
    }
 
}
 
 
class A {
     
    A() {
        System.out.println("6. A 的构造函数体。");
    }
     
    {
        System.out.println("5. A 的实例块。");
    }
     
    static {
        System.out.println("3. A 的静态块。");
    }
}
 
 
class B extends A {
     
    B() {
        System.out.println("8. B 的构造函数体。");
    }
     
    {
	        System.out.println("7. B 的实例块。");
	    }
     
    static {
        System.out.println("4. B 的静态块。");
    }
}

