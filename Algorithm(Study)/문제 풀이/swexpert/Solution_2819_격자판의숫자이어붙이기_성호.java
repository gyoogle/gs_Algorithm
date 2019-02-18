package com.sea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class hwalgo13_seoul_05_�ּ�ȣ {

	static int[][] arr;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int cnt; // 6�� �̵��ϵ��� ���� �ִ� cnt
	static boolean[] count; // s�� �ε����� �ϴ� counting ����Ʈ

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// �Է�
		int tc = sc.nextInt();
		arr = new int[4][4];
		for (int i = 1; i <= tc; i++) {
			count = new boolean[10000000];
			cnt = 0;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			// dfs�� ���� visited üũ ���ʿ� ����(�ߺ� ������ִϱ�)
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					dfs(j, k, "");
				}
			}
			System.out.println("#" + i + " " + cnt);
			
		} // end of tc
	} // end of main

	public static void dfs(int x, int y, String s) {

		s += arr[x][y];
		
		if(s.length() == 7) {
			if(!count[Integer.parseInt(s)]) {
				count[Integer.parseInt(s)] = true;
				cnt++;
			}
			return;
		}
		
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i]; // �����˻�
			ny = y + dy[i]; // �����˻�

			if (nx < 0 || nx > 3 || ny < 0 || ny > 3)
				continue; // �迭 ���� �Ѿ ���
			dfs(nx, ny, s);
		}

	} // end of dfs
} // end of class
