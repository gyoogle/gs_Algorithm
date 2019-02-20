package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_김규석 {

	static int N;
	static int E;
	
	static int[] p;
	static int[] rank;
	static long val;
	
	public static void makeSet(int x) {
		p[x] = x; // 부모 : 자신의 index로 표시 or -1
		//rank[x] = 0; //초기값 0임, 생략 가능
	}
	
	public static int findSet(int x) {
		if ( x == p[x] ) 
			return x;
		else {
			p[x] = findSet(p[x]); // Path Compression
			//rank[x] = 1; // 할 필요가 없음. 대표자에 대한 깊이(랭크)만 알면된다
			return p[x];
		}
	}
	
	public static void union(int x, int y) {
		int px = findSet(x); // 대표자 알아오기
		int py = findSet(y);
		
		if (px != py) // 서로 다른 집합일 경우에만 합침
			//p[py] = px;
			link(px, py);
	}
	
	/** x의 대표자의 집합과 y의 대표자의 집합을 합침. rank도 맞춤 */
	public static void link(int px, int py) {
		
		if(rank[px] > rank[py])
			p[py] = px; // 작은 쪽을 큰 쪽에 붙인다
		else {
			p[px] = py;
			if(rank[px] == rank[py]) { // 같은 경우는 rank 값이 증가한다
				rank[py]++; // 집합의 대표자 랭크가 증가됨
			}
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int a; // 정점1
		int b; // 정점2
		int val; // 가중치
		
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) { // 비교기준
			return this.val - o.val;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			val = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			rank = new int[N+1];
			
			
			Edge edge[] = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edge); // compareTo()를 작성
			
			for (int i = 0; i < p.length; i++) {
				makeSet(i); // 원소 1개짜리 집합 만들기
			}
			
			for (int i = 0; i < edge.length; i++) { // 가중치가 낮은 간선부터 선택하기
				Edge e = edge[i];
				if(findSet(e.a) != findSet(e.b)) { // 서로 다른 집합일 경우만 합치기
					union(e.a, e.b);
					val += e.val;
				}
			}
			
			
			System.out.println("#"+t+ " " + val);
		}
		
	}

}
