package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_�ּҽ��д�Ʈ��_��Լ� {

	static int N;
	static int E;
	
	static int[] p;
	static int[] rank;
	static long val;
	
	public static void makeSet(int x) {
		p[x] = x; // �θ� : �ڽ��� index�� ǥ�� or -1
		//rank[x] = 0; //�ʱⰪ 0��, ���� ����
	}
	
	public static int findSet(int x) {
		if ( x == p[x] ) 
			return x;
		else {
			p[x] = findSet(p[x]); // Path Compression
			//rank[x] = 1; // �� �ʿ䰡 ����. ��ǥ�ڿ� ���� ����(��ũ)�� �˸�ȴ�
			return p[x];
		}
	}
	
	public static void union(int x, int y) {
		int px = findSet(x); // ��ǥ�� �˾ƿ���
		int py = findSet(y);
		
		if (px != py) // ���� �ٸ� ������ ��쿡�� ��ħ
			//p[py] = px;
			link(px, py);
	}
	
	/** x�� ��ǥ���� ���հ� y�� ��ǥ���� ������ ��ħ. rank�� ���� */
	public static void link(int px, int py) {
		
		if(rank[px] > rank[py])
			p[py] = px; // ���� ���� ū �ʿ� ���δ�
		else {
			p[px] = py;
			if(rank[px] == rank[py]) { // ���� ���� rank ���� �����Ѵ�
				rank[py]++; // ������ ��ǥ�� ��ũ�� ������
			}
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int a; // ����1
		int b; // ����2
		int val; // ����ġ
		
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) { // �񱳱���
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
			
			Arrays.sort(edge); // compareTo()�� �ۼ�
			
			for (int i = 0; i < p.length; i++) {
				makeSet(i); // ���� 1��¥�� ���� �����
			}
			
			for (int i = 0; i < edge.length; i++) { // ����ġ�� ���� �������� �����ϱ�
				Edge e = edge[i];
				if(findSet(e.a) != findSet(e.b)) { // ���� �ٸ� ������ ��츸 ��ġ��
					union(e.a, e.b);
					val += e.val;
				}
			}
			
			
			System.out.println("#"+t+ " " + val);
		}
		
	}

}
