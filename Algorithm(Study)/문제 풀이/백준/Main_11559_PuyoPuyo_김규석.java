import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11559_PuyoPuyo_김규석 {

	static class puyo {
		int y;
		int x;
		
		puyo(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static char[][] map = new char[12][6];
	static char[][] copy;
	static boolean[][] visit;
	static boolean[][] Alpha;
	static int AlphaCnt;
	
	static ArrayList<puyo> list;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int time;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 0; i < 12; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 6; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		
		time = 0; // 연쇄 시간
		
		sol();
		
		System.out.println(time);
	}
	
	public static void sol() {
		
		int cnt = 0;
		
		while(true) {
			
			/*
			System.out.println("cnt : " + cnt);
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			
			list = new ArrayList<>();
			
			//puyo 위치 저장 (마지막줄부터 확인하기)
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j] != '.') {
						list.add(new puyo(i,j));
					}
				}
			}
			
			if(list.size() == 0) {
				time = cnt;
				break;
			}
			//System.out.println("list size :" + list.size());
			
			visit = new boolean[12][6];
			//뿌요마다 dfs를 돌리면서 4개이상 모여있는 곳 체크 (체크된 곳 시작부분 저장)
			for (int i = 0; i < list.size(); i++) {
				
				int y = list.get(i).y;
				int x = list.get(i).x;
				
				if(visit[y][x]) continue; // 이미 뿌요인 곳은 넘어감
				
				char alpha = map[y][x];
				
				Alpha = new boolean[12][6];
				AlphaCnt = 1; // 갯수
				dfs(y,x, alpha);
				if(AlphaCnt >= 4) { // 부실 수 있음
					
					for (int j = 0; j < 12; j++) {
						for (int z = 0; z < 6; z++) {
							if(Alpha[j][z]) // true일때만
								visit[j][z] = Alpha[j][z];
						}
					}
				}
			}
			
			/*
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.print(visit[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			
			//만약 visit 배열이 모두 false면 뿌요 진행 불가능 break로 빠져나오기
			boolean check = false;
			loop : for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(visit[i][j]) {
						check = true;
						break loop;
					}
				}
			}
			
			if(!check) {
				time = cnt;
				break;
			}
			
			cnt++;
			
			//체크한 부분 모두 부시기 (부시고 빈칸 만들어주기)
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(visit[i][j]) {
						map[i][j] = '.';
					}
				}
			}
		
			
			//뿌요들 아래로 내려서 빈칸위치 채우기
			for (int i = 0; i < 6; i++) {
				
				
				ArrayList<Character> ch = new ArrayList<>();
				
				for (int j = 11; j >= 0; j--) {
					if(map[j][i] != '.') {
						ch.add(map[j][i]);
						map[j][i] = '.';
					}
				}
				
				int p = 11;
				for (int j = 0; j < ch.size(); j++) {
					map[p--][i] = ch.get(j);
				}
				
			}
			

		}
	}
	
	public static void dfs(int y, int x, char alpha) {
		
		Alpha[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) continue;
			
			if(map[ny][nx] == alpha && !Alpha[ny][nx]) {
				Alpha[ny][nx] = true;
				AlphaCnt++;
				dfs(ny, nx, alpha);
			}
		}
	}

}
