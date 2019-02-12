package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class Solution_탑레이저_김규석 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt(); // test case
		
		for (int i = 1; i <= ts; i++) {
			
			int len = sc.nextInt();
			int[] arr = new int[len+1];
			Stack<Integer> stack = new Stack<Integer>();
			Stack<Integer> copystack = new Stack<Integer>();
			
			int[] result = new int[len];
			
			for (int j = 1; j < len+1; j++) {
				arr[j] = sc.nextInt();
				stack.push(arr[j]);
			}
			
			
			int cnt = 0;
			
			while(!stack.isEmpty()) {
				
				int num = stack.peek();
				stack.pop();
				boolean flag = true;
				
				while(flag) {
					if(!stack.isEmpty()) {
						if(num < stack.peek()) { // 만약 바로 옆이 더 크면 
							result[cnt] = stack.peek();
							flag = false;
							cnt++;
							while(!copystack.isEmpty()) { //다시 넣어주기
								stack.push(copystack.pop());
							}
						}
						else { // 안 크면 
							copystack.push(stack.peek());
							stack.pop();
							if(stack.isEmpty()) {
								result[cnt] = 0;
								cnt++;
								while(!copystack.isEmpty()) { //다시 넣어주기
									stack.push(copystack.pop());
								}
								flag = false;
							}
						}
					}
					else {
						result[cnt] = 0;
						cnt++;
						flag = false;
					}
				}
			}
			
			System.out.print("#" + i + " ");
			
			int size = result.length - 1;
			int start = 0;
			while(start <= size){
				
				if(result[size] == 0){
					System.out.print(0 + " ");
				}
				
				for (int j = 0; j < arr.length; j++) {
					
					if(result[size] == arr[j] && result[size] != 0){
						System.out.print(j + " ");
					}
				}
				
				size--;
			}
			
			System.out.println();
			
		}
		
	} // end of main
} // end of class
