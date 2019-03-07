package testAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese{ // 구조체 생성
	int y;
	int x;
	
	Cheese(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Main_1840_치즈_김규석 {
	
	static int C,R; // 행과 열
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
		
		outside(0,0); // 바깥쪽 -1 만들기
		
		while(true){ // 녹는 치즈가 없으면 while문 종료
			
			chk = new LinkedList<>(); // 녹는 치즈 저장할 큐
			
			int count = 0;
			
			for (int i = 1; i < C-1; i++) {
				for (int j = 1; j < R-1; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						if(checking(i,j)){ // 녹는 치즈면 true
							chk.add(new Cheese(i,j)); // 녹는 치즈 큐에 저장
							count++; // 녹는 치즈 수 증가
						}
					}
				}
			}
			
			
			if(count != 0)
				lastCnt = count; // 가장 마지막 녹는 치즈의 갯수 저장
			
			if(count == 0){
				break;
			}
			
			while(!chk.isEmpty()){ // 큐에 저장한 녹는 치즈 모두 -1로 변경
				
				Cheese c = chk.poll();
				
				map[c.y][c.x] = -1;
				visited[c.y][c.x] = true;
			}
			
			
			// 치즈가 녹은 후, 공기와 접촉하게 된 칸도 -1로 만들어주기
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					if(map[i][j] == 0 && !visited[i][j]) {
						if(checking(i,j))
							zeroChk(i, j);
					}
				}
			}
			
			time++; // 시간 증가
			
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
