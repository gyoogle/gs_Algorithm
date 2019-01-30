package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_5432_쇠막대기자르기_김규석 {
	
	static int[] stack = new int[100001];
	static int top = 0;
	
	public static boolean isEmpty() {
		return top == 0;
	}
	public static int pop() {
		if(isEmpty()) { // 스택이 비어있는가?
			System.out.println("stack underflow");
			return -1;
		} else {
			int data = stack[top];
			top--;
			return data;
		}
	}
	public static boolean isFull() {
		
		return stack.length - 1 == top;
	}

	public static void push(int data) {
		// 스택이 꽉차지 않았는 지 확인
		if(isFull()) {
			System.out.println("stack overflow");
		} else {
		top++;
		stack[top] = data;
		}
	}
	
	public static int peek() {
		return stack[top];        
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ts = br.readLine();
		int testcase = Integer.valueOf(ts);
				
		for (int i = 1; i <= testcase; i++) {
			
			//Stack<Integer> stack = new Stack<Integer>();
			int cnt = 0; // 갯수
			
			String str = br.readLine();
			char[] c = new char[str.length()+1];
			
			for (int t = 0; t < str.length(); t++) {
				c[t] = str.charAt(t);
			}
			
			int[] arr = new int[c.length];
			
			for (int j = 0; j < c.length; j++) {
				if(c[j] == '(') {
					push(j);
					cnt++;
				}
				
				else if(c[j] == ')') {
					if(!isEmpty()) {
						if(j - peek() == 1) { // 1 차이는 레이저
							arr[j] = -1;
							cnt--;
							pop();
						}
						else {
							arr[peek()] = j;
							pop();
						}
					}
				}
			}
			
			for (int m = 0; m < c.length; m++) {
				if(arr[m] == -1) { // 레이저 일때
					for (int k = 0; k < c.length; k++) {
						if(arr[k] != -1 && arr[k] != 0) {
							if( k < m && m < arr[k]) {
								cnt++; // 잘라지면 1 증가
							}
						}
					}
				}
			}
			
			System.out.println("#"+i+ " " + cnt);
		}
			
	}
}
