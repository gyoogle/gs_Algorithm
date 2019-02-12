package com.prac;

public class Z18_Divide {

	public static int power(int base, int ex) {
		int result = 1;
		for(int i=0;i<ex;i++) {
			result *= base;
		}
		return result;
	}
	
	public static int power2(int base, int ex) {
		if(ex ==0 ) {
			return 1;
		}else if(ex == 1){
			return base;
		}else {
			int n = power2(base,ex/2);
			if(ex %2 ==0) {				
				return n*n;
			}else {				
				return n*n * base;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2의 10승을 구하기
		System.out.println(power2(2,10));
		
	}

}
