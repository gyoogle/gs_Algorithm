package com.ssafy.algo;

import java.util.Scanner;

// static 멤버는 non-static 멤버를 참조할 수 없다.
// static 멤버가 먼저 사용할 수 있고 : 클래스의 정보가 처음 로딩될 때부터 프로그램 끝날 때까지
// non-static 멤버는 나중에 사용할 수 있다 : 객체 생성시점 ~ 참조변수가 없어질 때까지

public class Z04_재귀메서드 {
	
	// 재귀 함수 : 나 자신의 함수를 다시 호출하는 함수
	// 반복문과 역할이 비슷 (반복)
	// 속도가 느리다, callstack 영역의 메모리를 많이 사용한다.
	// 꼭 재귀함수를 사용해야하는 경우에만 사용해야 한다
	
	static void a(int start, int end, int step) {
		
		if (start > end) { // 종료 파트
			System.out.println();
		}
		else { // 반복 파트
			System.out.print(start);
			a(start + step, end, step); // 나의 함수를 다시 호출
		}
		
	}
	
	static void b(int start, int end) {
		if(start > end) {
			System.out.println();
		}else {
			System.out.print(start + " ");
			b(start + 2, end);
		}
	}
	
	static void d(int start, int end, int step) {
		if( start > end) {
			System.out.println();
		} else { 
			System.out.print(start + " ");
			d(start+step, end, step);
		}
	}
	
	static int sum = 0;
	
	static void e(int start, int end) {
		
		if(start > end) {
			System.out.println("총 합 : " + sum);
			sum = 0; // 초기화
		} else {
			sum += start;
			e(start+1, end);
		}
	}
	
	static int f(int start, int end) {
		
		if(start == end) {
			return end;
		}else {
			return f(start+1, end) + start;
		}
	}
	;///
	public static void main(String[] args) {
		
		// for문 이용한 일반 출력
		// cpu의 연산만 사용해서 메모리의 사용은 적음
		for (int i = 0; i <= 4; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		// 재귀함수 활용한 출력
		a(0, 4, 1);
		b(2, 8); // 2 4 6 8
		
		// 1. 사용자의 입력 start, end, step을 숫자로 받아서 반복문 처럼 한줄에 출력하는 재귀함수 d작성
		// 2. 사용자의 입력 start, end을 숫자로 받아서 start~end까지 합을 출력하는 재귀함수 e작성
		
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		e(start, end);
		
		System.out.println(f(start, end));
	}
}

