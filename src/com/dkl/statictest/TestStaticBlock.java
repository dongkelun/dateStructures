package com.dkl.statictest;

public class TestStaticBlock {

	static{
		Thread t = new Thread(){
			public void run(){
				System.out.println("running");
				System.out.println("Thread: " + str);
				str = "111";
				System.out.println("end...");
			}
		};
		
		t.start();
		
		try{
			t.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	static String str ="000";
	
	public static void main(String[] args) {
		System.out.println(str);
	}

}
