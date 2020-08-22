package com.SecureWatch;

public class Force implements Show {

	public void addition() {
		int num = 45;
		int num1 = 76;
		System.out.println(num+num1);
	}

	public void subtraction() {
		int num = 145;
		int num1 = 76;
		System.out.println(num-num1);
		
	}
	
	
	public static void main(String[] args) {
		
		Force obj = new Force();
		
		obj.addition();
		
		Show test = new Force();
		
		test.addition();
	}
	

}
