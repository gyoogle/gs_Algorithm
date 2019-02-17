package hwalgo13_seoul_05_kimgyuseok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2819 {
	
	static String[][] map;
	static HashSet<String> set; // 중복을 저장하지 않기 위한 HashSet
	
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};

	public static void dfs(int x, int y, int cnt, String str){
		
		if(cnt == 7) { // 7개 채우면 hashset에 저장 후 return
			set.add(str);
			return;
		}
		
		for (int i = 0; i < 4; i++) { // 상하좌우 움직이기
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue; // 배열 밖으로 벗어나면 continue
			else {
				dfs(nx, ny, cnt+1, str+map[nx][ny]); // cnt 늘리고, str에 해당 수 추가
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ts = Integer.parseInt(st.nextToken());
		set = new HashSet<String>();
		
		for (int t = 1; t <= ts ; t++) {
			
			map = new String[4][4];
			set.clear(); // 다음 테스트 케이스를 위해 hashset 비워주기
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");				
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					String str = map[i][j]; // 첫번째 값 저장
					dfs(i, j, 1, str);
				}
			}
			
			System.out.println("#"+t+ " " + set.size());
		}
	}

}
