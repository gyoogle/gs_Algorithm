package testAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese{ // ����ü ����
	int y;
	int x;
	
	Cheese(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Main_1840_ġ��_��Լ� {
	
	static int C,R; // ��� ��
	static int[][] map;
	static boolean[][] visited;
	static Queue<Cheese> chk;
	
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	static int time;
	static int lastCnt;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[C][R];
		visited = new boolean[C][R];
		
		time = 0;
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		outside(0,0); // �ٱ��� -1 �����
		
		while(true){ // ��� ġ� ������ while�� ����
			
			chk = new LinkedList<>(); // ��� ġ�� ������ ť
			
			int count = 0;
			
			for (int i = 1; i < C-1; i++) {
				for (int j = 1; j < R-1; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						if(checking(i,j)){ // ��� ġ��� true
							chk.add(new Cheese(i,j)); // ��� ġ�� ť�� ����
							count++; // ��� ġ�� �� ����
						}
					}
				}
			}
			
			
			if(count != 0)
				lastCnt = count; // ���� ������ ��� ġ���� ���� ����
			
			if(count == 0){
				break;
			}
			
			while(!chk.isEmpty()){ // ť�� ������ ��� ġ�� ��� -1�� ����
				
				Cheese c = chk.poll();
				
				map[c.y][c.x] = -1;
				visited[c.y][c.x] = true;
			}
			
			
			// ġ� ���� ��, ����� �����ϰ� �� ĭ�� -1�� ������ֱ�
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					if(map[i][j] == 0 && !visited[i][j]) {
						if(checking(i,j))
							zeroChk(i, j);
					}
				}
			}
			
			time++; // �ð� ����
			
		}
		
		System.out.println(time);
		System.out.println(lastCnt);
		
	}
	
	public static boolean checking(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<C && nx<R) {
				if(map[ny][nx] == -1){
					return true;
				}
			}
		}
		
		return false;
	}
	public static void outside(int y, int x) {
		
		map[y][x] = -1;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<C && nx<R) {
				if(map[ny][nx] == 0 && !visited[ny][nx]){
					visited[ny][nx] = true;
					outside(ny,nx);
				}
			}
		}
	}
	
	public static void zeroChk(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<C && nx<R) {
				if(map[ny][nx] == 0){
					map[ny][nx] = -1;
					visited[ny][nx] = true;
					zeroChk(ny,nx);
				}
			}
		}
	}
	
	
}
