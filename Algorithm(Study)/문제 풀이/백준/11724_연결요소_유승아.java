import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N,M;
	static boolean[][] visited;
	static Queue<Integer> q ;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		N = s.nextInt(); //정점의 개수
		M = s.nextInt(); //간선의 개수
		
		q = new LinkedList<>();
		map = new int[N+1][N+1];
		boolean[] check = new boolean[N+1];
		visited = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			check[a] = true;
			check[b]= true;
			
			map[a][b]=1;
			map[b][a]=1;
		}
		int cnt=0;
		for(int i=1;i<=N;i++)
			if(!check[i]) cnt++;
		
		for(int i=1;i<=N;i++) {
			
			for(int j=1;j<=N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					q.add(i);
					bfs();
					cnt++;
				}
			}
			
		}
		
		System.out.println(cnt);
	}

	public static void bfs() {
		
		while(!q.isEmpty()) {
		
			int now = q.poll();
			
			for(int i=1;i<=N;i++) {
				if(map[now][i]==1 && !visited[now][i]) {
					visited[now][i] = true; //간선에 대한 visited check;
					visited[i][now] = true;
					q.add(i);
				}
			}
		}
		
	} //end of bfs method
}
