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

public class Solution1247_SW문제해결응용3일차_최적경로_김규석 {

	static pair company; // 회사(출발)
	static pair home; // 집(도착)
	static pair[] customer; // 손님
	static int ans; // 최소 경로
	
	public static int distance(pair p1, pair p2){ // 두 구간의 거리 구하는 메소드
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	public static void swap(int[] set, int i, int index) { // swap 메소드
		int temp = set[i];
		set[i] = set[index];
		set[index] = temp;
	}
	
	public static void perm(int[] set, int size, int n, int k) { // 순열 구하는 메소드
		if (size == k) { //종료조건
			int s = solve(set);

			ans = ans > s? s : ans; // 최소값 저장
			return;
		}

		for (int i = size; i < n; i++) {
			swap(set, i, size);
			perm(set, size + 1, n, k);
			swap(set, i, size);
		}
	}
	
	public static int solve(int[] set){
		int sum = 0; // 거리를 저장할 sum
		
		sum += distance(company, customer[set[0]]); // 집과 첫번째 고객과의 거리
		
		for (int i = 0; i < set.length - 1; i++) { // 고객들간의 거리
			int index = set[i];
			int next = set[i+1];
			
			sum += distance(customer[index], customer[next]);
		}
		
		sum += distance(customer[set.length-1], home); // 마지막 고객과 집까지의 거리
		
		return sum;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); // test case
		
		for (int t = 1; t <= tc; t++) {
			
			int N = Integer.parseInt(br.readLine()); // 고객 수
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(br.readLine());
			int x = Integer.parseInt(br.readLine());
			
			ans = Integer.MAX_VALUE;
			
			int[] set = new int[N];
			
			company = new pair(y, x); // 첫번째는 회사
			
			y = Integer.parseInt(br.readLine());
			x = Integer.parseInt(br.readLine());
			
			home = new pair(y, x); // 두번째는 집
			
			customer = new pair[N]; // customer 배열 생성
			
			for (int i = 0; i < N; i++) {
				y = Integer.parseInt(br.readLine());
				x = Integer.parseInt(br.readLine());
				
				customer[i] = new pair(y, x);
			}
			
			for (int i = 0; i < N; i++) { // 순열에 필요한 배열 초기값
				set[i] = i;
			}
			
			perm(set, 0, N, N); // N Perm N
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
