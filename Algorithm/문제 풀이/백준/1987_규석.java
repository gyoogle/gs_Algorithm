package com.prac;

import java.util.Scanner;

public class Problem1987 {
	
	static char[][] map;
	static boolean[][] visited;
	static boolean[] alpha;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int r;
	static int c;
	static int maxCnt;
	
	public static void dfs(int x, int y, int count) {
		
		visited[x][y] = true;
		alpha[map[x][y] - 'A'] = true;
		
		int ax, ay;
		
		for (int i = 0; i < 4; i++) {
			
			ax = x + dx[i];
			ay = y + dy[i];
			
			if(ax >= 0 && ay >= 0 && ax < r && ay < c && !visited[ax][ay] && !(alpha[map[ax][ay] - 'A'])) {
				//System.out.println(ax + "," + ay);
				dfs(ax, ay, count+1);
				visited[ax][ay] = false;
				alpha[map[ax][ay] - 'A'] = false;
			}
		}
		//System.out.println(max + ", " + count);
		maxCnt = Math.max(maxCnt, count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		map = new char[r+1][c+1];
		visited = new boolean[r+1][c+1];
		alpha = new boolean[27];
		
		String[] str = new String[r];
		
		for (int i = 0; i < r; i++) {
			str[i] = sc.next();
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = str[i].charAt(j);
			}
		}
		
		/*
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		*/

		dfs(0, 0, 1);
		
		System.out.println(maxCnt);
	}

}
