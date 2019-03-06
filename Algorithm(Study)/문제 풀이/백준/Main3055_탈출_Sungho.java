package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055_탈출_Sungho {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int R;
	static int C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int s_indexx = 0; // 고슴도치 위치 저장 변수
		int s_indexy = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') { // 물은 여러개일 수 있어서 바로 큐에 저장
					w_q.add(i);
					w_q.add(j);
				}
				if(map[i][j] == 'S') { // 고슴도치 위치 저장
					s_indexx = i;
					s_indexy = j;
				}
			}
		}
		int number = bfs(map, s_indexx, s_indexy);
		
		if(number == -1) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(number);
		}
		
	} // end of main

	static Queue<Integer> w_q = new LinkedList<Integer>(); // 물의 q
	static Queue<Integer> s_q = new LinkedList<Integer>(); // 고슴도치의 q
	static boolean[][] w_visited; // 물의 visited
	static boolean[][] s_visited; // 고슴도치의 visited
	
	private static int bfs(char[][] map, int sx, int sy) {
		
		s_q.add(sx); // 고슴도치 위치 큐에 저장
		s_q.add(sy);
		int cnt = 0;
		w_visited = new boolean[R][C]; // 물의 visited
		s_visited = new boolean[R][C]; // 고슴도치의 visited
		
		while(!s_q.isEmpty()) {
			
			cnt++;
			// 물의 q에 있는게 먼저 퍼짐
			int wq_size = w_q.size(); // 처음 큐 싸이즈를 저장
			for (int i = 0; i < wq_size/2; i++) { // 큐에는 x,y좌표로 있어서 /2 해줘야됨 그만 큼 반복
				int w_indexx = w_q.poll();
				int w_indexy = w_q.poll();
				w_visited[w_indexx][w_indexy] = true;
				
				for (int j = 0; j < 4; j++) {
					int nx = w_indexx + dx[j];
					int ny = w_indexy + dy[j];
					// 범위안이고 , D와 X와 *이 아니고 , visited=false일때만 map을 *로 바꾸고 큐에 add
					if(nx>=0 && nx<R && ny>=0 && ny<C &&
							map[nx][ny] != 'D' && map[nx][ny] != 'X' &&
							!w_visited[nx][ny] && map[nx][ny] != '*') {
						map[nx][ny] = '*';
						w_q.add(nx);
						w_q.add(ny);
					}
				}
			} // end of 물의 for
			
			// 물이 번지고 나서 고슴도치 움직이기
			boolean flag = false; // for문 while 나오기 위한 flag
			int sq_size = s_q.size();
			for (int i = 0; i < sq_size/2; i++) {
				int s_indexx = s_q.poll();
				int s_indexy = s_q.poll();
				s_visited[s_indexx][s_indexy] = true;
				
				for (int j = 0; j < 4; j++) {
					int nx = s_indexx + dx[j];
					int ny = s_indexy + dy[j];
					// 범위안이고 , X와 * D S 아니고 visited=false일때 map을 S로 바꾸고 그 위치 저장***D일때를 추가안하면 마지막에 바꿔줘서 D를 못찾음***
					if(nx>=0 && nx<R && ny>=0 && ny<C &&
							map[nx][ny] != 'X' && map[nx][ny] != '*' &&
							!s_visited[nx][ny] && map[nx][ny] != 'D' && map[nx][ny] != 'S') {
						map[nx][ny] = 'S';
						s_q.add(nx);
						s_q.add(ny);
					}
					// 범위안이고 인전한 곳에 D가 있으면 다음턴에 집에 도착할 수 있는거
					else if(nx>=0 && nx<R && ny>=0 && ny<C &&
							map[nx][ny] == 'D'){
						flag = true;
					}
					if(flag)
						break;
				}
				if(flag)
					break;
			}
			if(flag) // flag가 true면 cnt를 리턴
				return cnt;
		} // end of while
		
		return -1; // while문 다 돌 동안 D를 못찾으면 못가는 경우임
	} // end of bfs
} // end of class
