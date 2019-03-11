import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_����_��Լ� {

	static int N, M;
	static int[] map;
	static int cnt;
	
	public static void makeSet(int x) {
		map[x] = x; // �θ� : �ڽ��� index�� ǥ�� or -1
	}
	
	public static int findSet(int x) {
		if ( x == map[x] ) 
			return x;
		else {
			map[x] = findSet(map[x]); // Path Compression
			return map[x];
		}
	}
	
	public static void union(int x, int y) {
		int px = findSet(x); // ��ǥ�� �˾ƿ���
		int py = findSet(y);
		
		if (px != py) { // ���� �ٸ� ������ ��쿡�� ��ħ
			map[py] = px;
			cnt--;
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1];
		
		cnt = map.length - 1;
		
		for (int i = 0; i < map.length; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			union(s1, s2);
		}
		
		System.out.println(cnt);
	}
	
}