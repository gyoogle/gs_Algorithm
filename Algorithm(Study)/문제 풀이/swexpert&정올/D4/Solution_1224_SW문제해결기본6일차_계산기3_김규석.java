package com.ssafy.algo;

import java.util.Scanner;

public class Solution_1224_SW문제해결기본6일차_계산기3_김규석 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int ts = 1; ts <= 10; ts++) {
			
			int len = sc.nextInt();
			sc.nextLine();
			char[] stack = new char[len];
			String save = "";
			
			int top = -1;
			
			String[] str = sc.nextLine().split("");
			
			for (int i = 0; i < str.length; i++) {
				char c = str[i].charAt(0);

				switch (c) {
				case '(': // 우선순위 3, 무조건 스택에 넣기
					stack[++top] = c;
					break;

				case '*': // 우선순위 2
					// 스택에 나보다 작은 것이 남아있을 때까지 꺼내서 출력
					while (top > -1 && (stack[top] == '*' || stack[top] == '/')) {
						save += stack[top];
						//System.out.print(stack[top] + " ");
						top--;
					}
					stack[++top] = c;
					break;

				case '/': // 우선순위 2
					// 스택에 나보다 작은 것이 남아있을 때까지 꺼내서 출력
					while (top > -1 && (stack[top] == '*' || stack[top] == '/')) {
						save += stack[top];
						//System.out.print(stack[top] + " ");
						top--;
					}
					stack[++top] = c;
					break;

				case '+':
					// 스택에 나보다 작은 것이 남아있을 때까지 꺼내서 출력
					while (top > -1 && (stack[top] == '*' || stack[top] == '/' || stack[top] == '+' || stack[top] == '-')) {
						save += stack[top];
						//System.out.print(stack[top] + " ");
						top--;
					}
					stack[++top] = c;
					break;

				case '-':
					// 스택에 나보다 작은 것이 남아있을 때까지 꺼내서 출력
					while (top > -1 && (stack[top] == '*' || stack[top] == '/' || stack[top] == '+' || stack[top] == '-')) {
						save += stack[top];
						//System.out.print(stack[top] + " ");
						top--;
					}
					stack[++top] = c;
					break;

				case ')':
					// '(' 나올 때까지 스택에서 꺼내서 출력
					while (top > -1 && stack[top] != '(') {
						save += stack[top];
						//System.out.print(stack[top] + " ");
						top--;
					}

					if (stack[top] == '(') {
						top--;
					}

					break;
				default: // 연산자가 아닌 경우 = 숫자(피연산자)인 경우
					save += str[i];
					//System.out.print(str[i] + " ");
					break;
				}
			}
			
			while(top > -1) {
				save += stack[top--];
				//System.out.print(stack[top--] + " ");
			}
			
			
			
			String[] saveArr = save.split("");
			
			int[] st = new int[saveArr.length];
			int top1 = -1;
			
			for (int j = 0; j < saveArr.length; j++) {
				
				char c = saveArr[j].charAt(0);
				int num1, num2;
				
				switch (c) {
				case '+':
					num2 = st[top1--];
					num1 = st[top1--];
					st[++top1] = num1 + num2;
					break;
				case '-':
					num2 = st[top1--];
					num1 = st[top1--];
					st[++top1] = num1 - num2;
					break;
				case '*':
					num2 = st[top1--];
					num1 = st[top1--];
					st[++top1] = num1 * num2;
					break;
				case '/':
					num2 = st[top1--];
					num1 = st[top1--];
					st[++top1] = num1 / num2;
					break;
					
				default:
					st[++top1] = Integer.parseInt(saveArr[j]);
					break;
				}
			}
			
			System.out.println("#" + ts + " " + st[top1--]);
		}
	}

}
