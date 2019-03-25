import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스_김규석 {

	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int c;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[s][c] = 1;
			map[c][s] = 1;
		}
		
		c = 0;
		
		bfs(1);
		
		System.out.println(c);
		
	}
	
	public static void bfs(int n){
		Queue<Integer> q = new LinkedList<Integer>();
		if(visited[n]) return;
		
		q.add(n);
		
		while(!q.isEmpty()){
			
			int k = q.poll();
			visited[k] = true;
			
			for (int i = 1; i <= N; i++) {
				if(map[k][i] == 1 && !visited[i]){
					q.add(i);
					visited[i] = true;
					c++;
				}
			}
		}
		
	}

}
