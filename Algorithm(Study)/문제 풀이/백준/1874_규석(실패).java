<<<<<<< HEAD
package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class Problem1874_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[num];
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		String str = "";
		
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
			sc.nextLine();
		}
		
		int cnt = 1; // 증가시킬 수
		int arrCnt = 0;
		boolean check = true;
		boolean check1 = true;
		stack.push(cnt); // 1 넣기
		str += "+ ";
		while(check){
			
			if(!stack.isEmpty()){
				if(stack.peek().intValue() == arr[arrCnt]){
					str += "- ";
					int pop = stack.pop();
					arrCnt++;
				}
				else if (stack.peek() < arr[arrCnt]){
					str += "+ ";
					stack.push(++cnt);
				}
				
				else {
					System.out.println("NO");
					return;
				}
				if(arrCnt == 8){
					check = false;
				}
			}
			else {
				System.out.println("NO");
				check = false;
				check1 = false;
			}
		}
		
		str = str.trim();
		String[] arrStr = new String[str.length()];
		arrStr = str.split(" ");
		if(check1){
			for (int i = 0; i < arrStr.length; i++) {
				System.out.println(arrStr[i]);
			}
		}
	}

}
=======
package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class Problem1874_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[num];
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		String str = "";
		
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
			sc.nextLine();
		}
		
		int cnt = 1; // 증가시킬 수
		int arrCnt = 0;
		boolean check = true;
		boolean check1 = true;
		stack.push(cnt); // 1 넣기
		str += "+ ";
		while(check){
			
			if(!stack.isEmpty()){
				if(stack.peek().intValue() == arr[arrCnt]){
					str += "- ";
					int pop = stack.pop();
					arrCnt++;
				}
				else if (stack.peek() < arr[arrCnt]){
					str += "+ ";
					stack.push(++cnt);
				}
				
				else {
					System.out.println("NO");
					return;
				}
				if(arrCnt == 8){
					check = false;
				}
			}
			else {
				System.out.println("NO");
				check = false;
				check1 = false;
			}
		}
		
		str = str.trim();
		String[] arrStr = new String[str.length()];
		arrStr = str.split(" ");
		if(check1){
			for (int i = 0; i < arrStr.length; i++) {
				System.out.println(arrStr[i]);
			}
		}
	}

}
>>>>>>> e53f85b9c2b65019788f00bb8a45f42eae1570bf
