package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {

	static int[][] map;
	static int max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			int ts = Integer.parseInt(br.readLine());
			
			map = new int[100][100];
			max = 0;
			
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			checking(map);
			
			
			System.out.println("#" + ts + " " + max);
			
		}
	}
	
	public static void checking(int[][] map){
		
		// За
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map[i].length; j++) {
				sum += map[i][j];
			}
			
			if(max < sum) max = sum;
		}
		
		
		// ї­
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map[i].length; j++) {
				sum += map[j][i];
			}
			
			if(max < sum) max = sum;
		}
		
		int chk1 = 0;
		int chk2 = 0;
		
		for (int i = 0; i < map.length; i++) {
			chk1 += map[i][i];
			chk2 += map[i][(map.length-1)-i];
		}
		
		if(max < chk1) max = chk1;
		if(max < chk2) max = chk2;
		
	}

}
