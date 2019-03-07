package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493_수의새로운연산_김규석 {

	static int[][] map;
	static int first, second, sumx, sumy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		map = new int[300][300];
		
		int num = 1;
		
		for (int x = 1; x < map.length; x++) {
			int k = x;
			int y = 1;
			while(k > 0) {
				map[y++][k--] = num++;
			}
		}
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			
			sumx = 0;
			sumy = 0;
			
			boolean chk1 = false;
			boolean chk2 = false;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					if(map[i][j] == first) {
						sumx += i;
						sumy += j;
						chk1 = true;
					}
					if(map[i][j] == second) {
						sumx += i;
						sumy += j;
						chk2 = true;
					}
					
					if(chk1 && chk2) {
						break;
					}
				}
				if(chk1 && chk2) break;
			}
			
			System.out.println("#" + t + " " + map[sumx][sumy]);
			
		}
		
	}
}
