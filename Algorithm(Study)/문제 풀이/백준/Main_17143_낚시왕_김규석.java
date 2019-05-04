import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_낚시왕_김규석 {

	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int s; // 속력
		int d; // 방향
		int z; // 크기
		
		public Fish(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public void setR(int r) {
			this.r = r;
		}

		public void setC(int c) {
			this.c = c;
		}

		public void setS(int s) {
			this.s = s;
		}

		public void setD(int d) {
			this.d = d;
		}

		public void setZ(int z) {
			this.z = z;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.c == o.c) {
				if(this.r == o.r){
					return this.z < o.z ? 1 : -1;
				}
				else
					return this.r < o.r ? -1 : 1;
			}
			return this.c < o.c ? -1 : 1;
		}
		
		
	}
	
	static int R,C,M;
	static int[][] map;
	static int[][] size;
	static int[][] dir;
	
	static int[] dy = {0,-1,1,0,0}; // 상,하,우,좌
	static int[] dx = {0,0,0,1,-1};
	static ArrayList<Fish> list;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		//물고기의 r,c는 각각 -1해서 넣어줘야함
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new Fish(r-1,c-1,s,d,z));
		}
		
		int time = 0;
		int result = 0; // 잡은 물고기의 합
		
		
		while(time < C) {
			
			Collections.sort(list); // 행 값이 작은 순으로 정렬
			
			// 낚시꾼이 열의 위치가 time인 곳에 있는 가장 가까운 물고기 사냥
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).c == time){
					result += list.get(i).z; // 잡은 고기 크기 더함
					list.remove(i); // 삭제
					break;
				}
			}
			
			// 물고기 이동
			for (int i = 0; i < list.size(); i++) {
				
				Fish f = list.get(i);
				int r = f.r;
				int c = f.c;
				int dir = f.d;
				int cnt = f.s;
				
				while(cnt > 0) {
					
					r+=dy[dir];
					c+=dx[dir];
					
					if(r < 0 || c < 0 || r>=R || c>=C) { // 벽에 만난 순간 (dir 변경)
						
						//다시 값 돌려주고
						r-=dy[dir];
						c-=dx[dir];
						
						if(dir == 1){
							dir = 2;
						} else if(dir == 2) {
							dir = 1;
						} else if(dir == 3) {
							dir = 4;
						} else if(dir == 4) {
							dir = 3;
						}
						
						continue; // cnt 유지한채 한번더 돌리기 위해 continue
					}
					
					cnt--;
				}
				
				list.get(i).setR(r);
				list.get(i).setC(c);
				list.get(i).setD(dir);
				
			}
			
			map = new int[R][C];
			size = new int[R][C];
			dir = new int[R][C];
			
			for (int i = 0; i < list.size(); i++) {
				int r = list.get(i).r;
				int c = list.get(i).c;
				
				if(map[r][c] == 0) {
					map[r][c] = list.get(i).z;
					size[r][c] = list.get(i).s;
					dir[r][c] = list.get(i).d;
				}
				else {
					if(map[r][c] < list.get(i).z){
						map[r][c] = list.get(i).z;
						size[r][c] = list.get(i).s;
						dir[r][c] = list.get(i).d;
					}
				}
			}
			
			list.clear();
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != 0) {
						list.add(new Fish(i, j, size[i][j], dir[i][j], map[i][j]));
					}
				}
			}
			
			
			/*
			System.out.println("------------------------");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------------------");
			*/
			
			time++;
		}
		
		System.out.println(result);
		
	}

}
