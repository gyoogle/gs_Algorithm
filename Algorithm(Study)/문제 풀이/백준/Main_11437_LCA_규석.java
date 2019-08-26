package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11437_LCA {
	
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] parent;
	static int[] depth;
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		parent = new int[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		//초기화
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[p].add(c);
			list[c].add(p);
		}
		
		visited[1] = true;
		
		//트리 만들기
		dfs(1, 0);
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int res = lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			System.out.println(res);
		}
		
		
	}
	
	public static void dfs(int root, int d) {
		
		for (int i = 0; i < list[root].size(); i++) {
			int cur = list[root].get(i);
			
			if(!visited[cur]) {
				visited[cur] = true;
				parent[cur] = root;
				depth[cur] = d+1;
				dfs(cur, d+1);
			}
		}
		
	}
	
	public static int lca(int a, int b) {
		
		int res = 0;
		
		while(true) {
			int da = depth[a];
			int db = depth[b];
			
			if(da == db) {
				if(a == b) {
					res = a;
					break;
				}
				
				if(parent[a] == parent[b]) {
					res = parent[a];
					break;
				}
				else {
					a = parent[a];
					b = parent[b];
				}
			}
			else {
				if(da > db) {
					a = parent[a];
				}
				else
					b = parent[b];
			}
		}
		
		return res;
	}

}
