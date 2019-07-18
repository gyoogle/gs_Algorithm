import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프_김규석 {

	static String[][] arr;
	static HashSet<String> set;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new String[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, arr[i][j]);
			}
		}
		
		System.out.println(set.size());
	}
	
	public static void dfs(int y, int x, int depth, String str) {
		
		if(depth == 5) {
			set.add(str);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
			
			String s = arr[ny][nx];
			dfs(ny,nx,depth+1,str+s);
		}
		
	}

}
