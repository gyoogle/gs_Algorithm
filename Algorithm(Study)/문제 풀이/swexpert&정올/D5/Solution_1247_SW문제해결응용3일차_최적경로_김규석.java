package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class pair {
	int y;
	int x;
	
	pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Solution1247_SW�����ذ�����3����_�������_��Լ� {

	static pair company; // ȸ��(���)
	static pair home; // ��(����)
	static pair[] customer; // �մ�
	static int ans; // �ּ� ���
	
	public static int distance(pair p1, pair p2){ // �� ������ �Ÿ� ���ϴ� �޼ҵ�
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	public static void swap(int[] set, int i, int index) { // swap �޼ҵ�
		int temp = set[i];
		set[i] = set[index];
		set[index] = temp;
	}
	
	public static void perm(int[] set, int size, int n, int k) { // ���� ���ϴ� �޼ҵ�
		if (size == k) { //��������
			int s = solve(set);

			ans = ans > s? s : ans; // �ּҰ� ����
			return;
		}

		for (int i = size; i < n; i++) {
			swap(set, i, size);
			perm(set, size + 1, n, k);
			swap(set, i, size);
		}
	}
	
	public static int solve(int[] set){
		int sum = 0; // �Ÿ��� ������ sum
		
		sum += distance(company, customer[set[0]]); // ���� ù��° ������ �Ÿ�
		
		for (int i = 0; i < set.length - 1; i++) { // ���鰣�� �Ÿ�
			int index = set[i];
			int next = set[i+1];
			
			sum += distance(customer[index], customer[next]);
		}
		
		sum += distance(customer[set.length-1], home); // ������ ���� �������� �Ÿ�
		
		return sum;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); // test case
		
		for (int t = 1; t <= tc; t++) {
			
			int N = Integer.parseInt(br.readLine()); // �� ��
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(br.readLine());
			int x = Integer.parseInt(br.readLine());
			
			ans = Integer.MAX_VALUE;
			
			int[] set = new int[N];
			
			company = new pair(y, x); // ù��°�� ȸ��
			
			y = Integer.parseInt(br.readLine());
			x = Integer.parseInt(br.readLine());
			
			home = new pair(y, x); // �ι�°�� ��
			
			customer = new pair[N]; // customer �迭 ����
			
			for (int i = 0; i < N; i++) {
				y = Integer.parseInt(br.readLine());
				x = Integer.parseInt(br.readLine());
				
				customer[i] = new pair(y, x);
			}
			
			for (int i = 0; i < N; i++) { // ������ �ʿ��� �迭 �ʱⰪ
				set[i] = i;
			}
			
			perm(set, 0, N, N); // N Perm N
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
