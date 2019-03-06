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

public class Main3055_Ż��_Sungho {
	
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
		
		int s_indexx = 0; // ����ġ ��ġ ���� ����
		int s_indexy = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') { // ���� �������� �� �־ �ٷ� ť�� ����
					w_q.add(i);
					w_q.add(j);
				}
				if(map[i][j] == 'S') { // ����ġ ��ġ ����
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

	static Queue<Integer> w_q = new LinkedList<Integer>(); // ���� q
	static Queue<Integer> s_q = new LinkedList<Integer>(); // ����ġ�� q
	static boolean[][] w_visited; // ���� visited
	static boolean[][] s_visited; // ����ġ�� visited
	
	private static int bfs(char[][] map, int sx, int sy) {
		
		s_q.add(sx); // ����ġ ��ġ ť�� ����
		s_q.add(sy);
		int cnt = 0;
		w_visited = new boolean[R][C]; // ���� visited
		s_visited = new boolean[R][C]; // ����ġ�� visited
		
		while(!s_q.isEmpty()) {
			
			cnt++;
			// ���� q�� �ִ°� ���� ����
			int wq_size = w_q.size(); // ó�� ť ����� ����
			for (int i = 0; i < wq_size/2; i++) { // ť���� x,y��ǥ�� �־ /2 ����ߵ� �׸� ŭ �ݺ�
				int w_indexx = w_q.poll();
				int w_indexy = w_q.poll();
				w_visited[w_indexx][w_indexy] = true;
				
				for (int j = 0; j < 4; j++) {
					int nx = w_indexx + dx[j];
					int ny = w_indexy + dy[j];
					// �������̰� , D�� X�� *�� �ƴϰ� , visited=false�϶��� map�� *�� �ٲٰ� ť�� add
					if(nx>=0 && nx<R && ny>=0 && ny<C &&
							map[nx][ny] != 'D' && map[nx][ny] != 'X' &&
							!w_visited[nx][ny] && map[nx][ny] != '*') {
						map[nx][ny] = '*';
						w_q.add(nx);
						w_q.add(ny);
					}
				}
			} // end of ���� for
			
			// ���� ������ ���� ����ġ �����̱�
			boolean flag = false; // for�� while ������ ���� flag
			int sq_size = s_q.size();
			for (int i = 0; i < sq_size/2; i++) {
				int s_indexx = s_q.poll();
				int s_indexy = s_q.poll();
				s_visited[s_indexx][s_indexy] = true;
				
				for (int j = 0; j < 4; j++) {
					int nx = s_indexx + dx[j];
					int ny = s_indexy + dy[j];
					// �������̰� , X�� * D S �ƴϰ� visited=false�϶� map�� S�� �ٲٰ� �� ��ġ ����***D�϶��� �߰����ϸ� �������� �ٲ��༭ D�� ��ã��***
					if(nx>=0 && nx<R && ny>=0 && ny<C &&
							map[nx][ny] != 'X' && map[nx][ny] != '*' &&
							!s_visited[nx][ny] && map[nx][ny] != 'D' && map[nx][ny] != 'S') {
						map[nx][ny] = 'S';
						s_q.add(nx);
						s_q.add(ny);
					}
					// �������̰� ������ ���� D�� ������ �����Ͽ� ���� ������ �� �ִ°�
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
			if(flag) // flag�� true�� cnt�� ����
				return cnt;
		} // end of while
		
		return -1; // while�� �� �� ���� D�� ��ã���� ������ �����
	} // end of bfs
} // end of class
