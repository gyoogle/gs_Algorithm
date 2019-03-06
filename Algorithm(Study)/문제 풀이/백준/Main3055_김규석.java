package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class map1 {
	int y;
	int x;
	
	map1(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Main3055_±è±Ô¼® {

	static int R,C;
	static char[][] map;
	static Queue<map1> q1;
	static Queue<map1> q2;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	static int min;
	static String fail = "impossible";
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		q1 = new LinkedList<>(); // °í½¿µµÄ¡
		q2 = new LinkedList<>(); // ¹°
		
		map = new char[R][C];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < R; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j].charAt(0);
				if(str[j].charAt(0) == 'S') q1.add(new map1(i,j));
				if(str[j].charAt(0) == '*') q2.add(new map1(i,j));
			}
		}
		
		cnt = 0;
		
		bfs(map);
		
		System.out.println(cnt);
		
	}
	
	public static void bfs(char[][] map) {
		
		while(true){
			
			cnt++;
			
			int size2 = q2.size();
			
			for (int s = 0; s < size2; s++) {
				map1 m1 = q2.poll();
				
				for (int i = 0; i < 4; i++) {
					int ny = m1.y + dy[i];
					int nx = m1.x + dx[i];
					
					if(ny >= 0 && nx >= 0 && ny < R && nx < C){
						if(map[ny][nx] == '.'){
							map[ny][nx] = '*';
							q2.add(new map1(ny,nx));
						}
					}
				}
			}
			
			if(q1.size() == 0){
				System.out.println(fail);
				System.exit(0);
			}
			
			int size1 = q1.size();
			
			for (int s = 0; s < size1; s++) {
				map1 m1 = q1.poll();
				
				for (int i = 0; i < 4; i++) {
					int ny = m1.y + dy[i];
					int nx = m1.x + dx[i];
					
					if(ny >= 0 && nx >= 0 && ny < R && nx < C){
						if(map[ny][nx] == 'D'){
							return;
						}
						
						if(map[ny][nx] == '.'){
							map[ny][nx] = 'S';
							q1.add(new map1(ny,nx));
						}
					}
				}
			}
			
		}			
	}

}
