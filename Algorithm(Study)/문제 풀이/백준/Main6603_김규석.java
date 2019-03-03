package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {

	static int[] map;
	static int[] set;
	static int N;
	static int K = 6;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean chk = true;
		
		while(chk){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) { // 0 들어오면 나가기
				chk = false;
				break;
			}
			
			map = new int[N];
			set = new int[10000000];
			
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(set, 0, N, K, 0);
			System.out.println();
		}
	}
	
	public static void comb(int[] set, int size, int N, int K, int index){
		
		if(K==0){
			for (int i = 0; i < size; i++) {
				System.out.print(map[set[i]] + " ");
			}
			System.out.println();
			return;
		}
		if(index==N) return;
		
		set[size] = index;
		comb(set, size+1, N, K-1, index+1);
		comb(set, size, N, K, index+1);
	}

}
