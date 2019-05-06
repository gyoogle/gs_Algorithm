import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산_김규석 {

	static class Num implements Comparable<Num> {
		int n;
		int len;
		
		Num(int n, int len) {
			this.n = n;
			this.len = len;
		}

		@Override
		public int compareTo(Num o) {
			if(this.len == o.len) {
				return this.n < o.n ? -1 : 1;
			}
			return this.len < o.len ? -1 : 1;
		}
		
		
	}
	
	static int[][] map;
	static int[] cnt;
	static ArrayList<Num> list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int val = Integer.parseInt(st.nextToken());
		
		map = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = -1;
		
		while(true) {
			time++;
			
			
			if(time > 100) { // 100 넘어가면 -1
				time = -1;
				break;
			}
			
			if(r < map.length && c < map[0].length){
				if(map[r][c] == val) // 반복문 종료조건
					break;
			}
			
			int row = map.length;
			int col = map[0].length;
			
			int[][] temp = new int[101][101];
			
			if(row >= col) { // R 연산
				
				int max = Integer.MIN_VALUE;
				
				for (int i = 0; i < row; i++) {
					
					cnt = new int[101];
					for (int j = 0; j < col; j++) {
						if(map[i][j] == 0) continue;
						int n = map[i][j];
						cnt[n]++;
					}
					
					list = new ArrayList<>();
					
					for (int j = 1; j < cnt.length; j++) {
						if(cnt[j] != 0){
							list.add(new Num(j, cnt[j]));
						}
					}
					
					Collections.sort(list);
					
					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[i][z] = list.get(j).n;
						temp[i][z+1] = list.get(j).len;
						z+=2;
					}
					
					if(max < list.size()*2) max = list.size()*2;
					
				}
				if(max > 100) max = 100;
				
				map = new int[row][max];
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
				
			}
			
			else { // C 연산
				
				int max = Integer.MIN_VALUE;
				
				for (int i = 0; i < col; i++) {
					
					cnt = new int[101];
					for (int j = 0; j < row; j++) {
						if(map[j][i] == 0) continue;
						int n = map[j][i];
						cnt[n]++;
					}
					
					list = new ArrayList<>();
					
					for (int j = 1; j < cnt.length; j++) {
						if(cnt[j] != 0){
							list.add(new Num(j, cnt[j]));
						}
					}
					
					Collections.sort(list);
					
					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[z][i] = list.get(j).n;
						temp[z+1][i] = list.get(j).len;
						z+=2;
					}
					
					if(max < list.size()*2) max = list.size()*2;
				}
				
				if(max > 100) max = 100;
				
				map = new int[max][col];
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
				
			}
			
			/*System.out.println("------------------------");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------------------");*/
		}
		
		System.out.println(time);
	}

}
