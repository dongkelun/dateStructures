package com.dkl.sougou;

public class HelloSogou{
    public static  void main(String[] a){
        Thread t=new Thread(){
            public void run(){Sogou();}
    };
    int i = 0;
    i = i++;
    System.out.println(i);
    t.run();
    System.out.print("Hello");
    }
    static  void Sogou(){
    System.out.print("Sogou");
   }
}
