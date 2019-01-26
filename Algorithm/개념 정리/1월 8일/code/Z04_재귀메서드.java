package com.ssafy.algo;

import java.util.Scanner;

// static ����� non-static ����� ������ �� ����.
// static ����� ���� ����� �� �ְ� : Ŭ������ ������ ó�� �ε��� ������ ���α׷� ���� ������
// non-static ����� ���߿� ����� �� �ִ� : ��ü �������� ~ ���������� ������ ������

public class Z04_��͸޼��� {
	
	// ��� �Լ� : �� �ڽ��� �Լ��� �ٽ� ȣ���ϴ� �Լ�
	// �ݺ����� ������ ��� (�ݺ�)
	// �ӵ��� ������, callstack ������ �޸𸮸� ���� ����Ѵ�.
	// �� ����Լ��� ����ؾ��ϴ� ��쿡�� ����ؾ� �Ѵ�
	
	static void a(int start, int end, int step) {
		
		if (start > end) { // ���� ��Ʈ
			System.out.println();
		}
		else { // �ݺ� ��Ʈ
			System.out.print(start);
			a(start + step, end, step); // ���� �Լ��� �ٽ� ȣ��
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
			System.out.println("�� �� : " + sum);
			sum = 0; // �ʱ�ȭ
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
		
		// for�� �̿��� �Ϲ� ���
		// cpu�� ���길 ����ؼ� �޸��� ����� ����
		for (int i = 0; i <= 4; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		// ����Լ� Ȱ���� ���
		a(0, 4, 1);
		b(2, 8); // 2 4 6 8
		
		// 1. ������� �Է� start, end, step�� ���ڷ� �޾Ƽ� �ݺ��� ó�� ���ٿ� ����ϴ� ����Լ� d�ۼ�
		// 2. ������� �Է� start, end�� ���ڷ� �޾Ƽ� start~end���� ���� ����ϴ� ����Լ� e�ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		e(start, end);
		
		System.out.println(f(start, end));
	}
}

