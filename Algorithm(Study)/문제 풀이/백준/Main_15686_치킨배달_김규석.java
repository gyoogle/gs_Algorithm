package testAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Chicken {
	int y;
	int x;
	
	Chicken(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main_15686_치킨배달_김규석 {

	static int N,M;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visited;
	static ArrayList<Chicken> home;
	static ArrayList<Chicken> chicken;
	static int[] set;
	static Chicken[] combi;
	static int count;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int disMin;
	static int min;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		count = 0; // 치킨집 수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					home.add(new Chicken(i,j));
				if(map[i][j] == 2) {
					chicken.add(new Chicken(i,j));
					count++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		set = new int[M];
		comb(set, 0, count, M, 0); // 치킨집 개수 고르기
		
		System.out.println(min);
	}
	
	public static void comb(int[] set, int size, int N, int K, int index) {
		
		if(K==0) {
			combi = new Chicken[size];
			for (int i = 0; i < size; i++) {
				combi[i] = chicken.get(set[i]);
			}
			checking(combi);
			return;
		}
		else if (N==index) return;
		
		set[size] = index;
		comb(set, size+1, N, K-1, index+1);
		comb(set, size, N, K, index+1);
	}
	
	public static int distance(Chicken home, Chicken chicken) {
		return Math.abs(chicken.y - home.y) + Math.abs(chicken.x - home.x);
	}
	
	public static void checking(Chicken[] combi) {
		
		copymap = new int[N][N];
		
		for (int i = 0; i < combi.length; i++) {
			copymap[combi[i].y][combi[i].x] = 2;
		}
		
		int sum = 0;
		
		for (int i = 0; i < home.size(); i++) {
		
			Chicken c = home.get(i);
			
			disMin = Integer.MAX_VALUE;
			
			for (int j = 0; j < combi.length; j++) {
				Chicken c1 = combi[j];
				
				int dis = distance(c, c1);
				if(dis < disMin) disMin = dis;
			}
			
			sum += disMin;
		}
		
		if(sum < min) min = sum;
		
	}
	
}
