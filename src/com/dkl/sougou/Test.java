package com.dkl.sougou;

import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String args[]) {
		int [] a,b = {1,223};
		byte[] src = null,dst;
		try {
			dst=new String(src,"GBK").getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = 0;
		i = ++i;
		System.out.println(i);
		
	}
	
}
