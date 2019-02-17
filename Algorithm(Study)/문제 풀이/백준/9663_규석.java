package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Queen {
	int n; // n*n
	int[] col; // 열
	
	Queen(int n){
		this.n = n;
		col = new int[n];
	}
}

public class Problem9663 {
	
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queen q = new Queen(n);
		
		backtracking(q, 0);
		
		System.out.println(count);
	}
	
	public static void backtracking(Queen q, int level){
		if(level == q.n){ // 같아지면 경우의 수 증가
			count++;
			
			for (int i = 0; i < q.n; i++) {
				System.out.print(q.col[i] + " ");
			}
			System.out.println();
			
		}
		else {
			for (int i = 0; i < q.n; i++) {
				q.col[level] = i;
				
				if(check(q, level)){
					backtracking(q, level+1);
				}
			}
		}
	}
	
	public static boolean check(Queen q, int level){
		for (int i = 0; i < level; i++) {
			//같은 행과 열에 있거나 대각선에 있을 경우 false
			if(q.col[i] == q.col[level] || Math.abs(level - i) == Math.abs(q.col[level] - q.col[i])){
				return false;
			}
		}
		
		return true;
	}

}