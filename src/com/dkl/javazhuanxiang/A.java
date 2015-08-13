package com.dkl.javazhuanxiang;

class A {
    C c = new C();
 
    A() {
        this("A");
        System.out.print("A");
    }
 
    A(String s) {
        System.out.print(s);
    }
}
