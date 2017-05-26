package com.cn.pr;

public class test {
	public static void main(String[] args) {
		int i = 0;
		String str = new String();
		char[] a = {'a','b','c'};
		String s = test(i,str,a);
		System.out.println("i+++++++++"+i);
		System.out.println("str+++++++"+str);
		System.out.println("char[]+++++++"+a[0]);
		System.out.println(s);
	}
	public static String test(int i,String str, char[] a) {
		String s = "";
		i=4;
		str="123456";
		a[0]='d';
		System.out.println("i====="+i);
		System.out.println("str======"+str);
		System.out.println("char[]====="+a[0]);
		return s+i+"   "+str+"   "+a[0];
	}
}
