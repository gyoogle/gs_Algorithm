package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Spot implements Comparable<Spot>{
	int y;
	int x;
	int cost;
	
	public Spot(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}

	@Override
	public int compareTo(Spot o) {
		return this.cost < o.cost ? -1 : 1;
	}
	
	
}

public class Problem1261 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] dist;
	static PriorityQueue<Spot> pq;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열
		
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		
		//거리값에 무한대 값 저장
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		//맵에 input 저장 (1부터 N,M까지)
		for (int y = 1; y < map.length; y++) {
			String[] str = br.readLine().split("");
			for (int x = 1; x < map[y].length; x++) {
				map[y][x] = Integer.parseInt(str[x-1]);
			}
		}
		
		
		//우선순위 큐 생성
		pq = new PriorityQueue<>();
		
		bfs();
		
		
		System.out.println(result);
	}
	
	public static void bfs(){
		
		//첫번째 시작 값 add
		pq.add(new Spot(1, 1, 0));
		dist[1][1] = 0;
		
		while(!pq.isEmpty()){
			
			Spot s = pq.poll();
			
			
			//끝까지 도착하면 가중치 값 가지고 return
			if(s.y == N && s.x == M){
				result = s.cost;
				return;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int ny = s.y + dy[i];
				int nx = s.x + dx[i];
				
				if(ny>0 && nx>0 && ny<=N && nx<=M){ // 1 ~ N,M일때만
					
					if(dist[ny][nx] > dist[s.y][s.x] + map[ny][nx]){
						dist[ny][nx] = dist[s.y][s.x] + map[ny][nx];
						pq.add(new Spot(ny, nx, dist[ny][nx]));
					}
					
				}
			}
		}
	}
	
	
}
