import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시_김규석 {

	static class pair{
		int y;
		int x;
		
		pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N,M;
	static int[][] map;
	static int[][] copy;
	static ArrayList<pair> num;
	static int[] arr;
	static int[] set;
	static int r;
	
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	
	static int min;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		num = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					num.add(new pair(i,j));
				}
			}
		}
		
		arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		set = new int[num.size()];
		r = set.length;
		
		min = Integer.MAX_VALUE;
		
		rperm(0);
		
		System.out.println(min);
	}
	
	public static void sol(int idx, int dir) {
		
		pair p = num.get(idx);
		
		int n = copy[p.y][p.x];
		int y = p.y;
		int x = p.x;
		
		switch (n) {
		case 1:
			y = p.y;
			x = p.x;
			
			while(true) {
				y += dy[dir];
				x += dx[dir];
				
				if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
				
				if(copy[y][x] != 0) continue;
				
				copy[y][x] = -1;
			}
			break;
		case 2:
			
			if(dir == 1 || dir == 3){ // 상,하
				
				y = p.y;
				x = p.x;
				
				while(true) { // 상
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) { // 하
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
			}
			
			else if(dir == 2 || dir == 4) { // 좌,우
				
				y = p.y;
				x = p.x;
				
				while(true) { // 좌
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) { // 우
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			
			break;
		case 3:
			
			if(dir == 1) { // 상, 우
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 2) { // 우, 하
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 3) { // 하, 좌
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 4) { // 좌, 상
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			
			break;
		case 4:
			
			if(dir == 1) { // 상, 우
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 2) { // 우, 하
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 3) { // 하, 좌
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[2];
					x += dx[2];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			else if(dir == 4) { // 좌, 상
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[3];
					x += dx[3];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[1];
					x += dx[1];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
				
				y = p.y;
				x = p.x;
				
				while(true) {
					y += dy[4];
					x += dx[4];
					
					if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
					
					if(copy[y][x] != 0) continue;
					
					copy[y][x] = -1;
				}
			}
			
			break;
		case 5:
			
			y = p.y;
			x = p.x;
			
			while(true) {
				y += dy[1];
				x += dx[1];
				
				if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
				
				if(copy[y][x] != 0) continue;
				
				copy[y][x] = -1;
			}
			
			y = p.y;
			x = p.x;
			
			while(true) {
				y += dy[2];
				x += dx[2];
				
				if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
				
				if(copy[y][x] != 0) continue;
				
				copy[y][x] = -1;
			}
			
			y = p.y;
			x = p.x;
			
			while(true) {
				y += dy[3];
				x += dx[3];
				
				if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
				
				if(copy[y][x] != 0) continue;
				
				copy[y][x] = -1;
			}
			
			y = p.y;
			x = p.x;
			
			while(true) {
				y += dy[4];
				x += dx[4];
				
				if(y < 0 || x < 0 || y >= N || x >= M || copy[y][x] == 6) break;
				
				if(copy[y][x] != 0) continue;
				
				copy[y][x] = -1;
			}
			
			break;
		default:
			break;
		}
		
	}
	
	public static void rperm(int len) {
		
		if(len == r) {
			copy = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			
			for (int i = 0; i < set.length; i++) {
				int dir = set[i];
				sol(i, dir);
			}
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy[i][j] == 0) cnt++;
				}
			}
			
			if(min > cnt) min = cnt;
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			set[len] = arr[i];
			rperm(len+1);
		}
	}
}
