package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10798 {

	static String[][] map;
	static int n;
	//static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new String[15][15];
		
		for (int i = 0; i < 5; i++) {
			String[] str = br.readLine().split("");
			n = str.length;
			//if(max < n) max = n;
			for (int j = 0; j < n; j++) {
				map[i][j] = str[j];
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[j][i] != null)
					System.out.print(map[j][i]);
			}
		}
		
	}

}
