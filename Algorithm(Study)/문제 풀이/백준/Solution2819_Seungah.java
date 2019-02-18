import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2819_Seungah {

	static HashSet<String> hs;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map = new char[4][4];
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			hs = new HashSet<String>();
			cnt = 0;
			check = new boolean[10000000];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			} // 입력 받기

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					solve(i, j, 0, "" + map[i][j]);
				}
			}

			System.out.println("#" + tc + " " + cnt);
		} // end of tc
	}

	static void solve(int y, int x, int depth, String s) {

		if (depth >= 6) {
			if (!check[Integer.parseInt(s)]) {
				check[Integer.parseInt(s)] = true;
				cnt++;
			}
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || ny > 3 || nx < 0 || nx > 3)
					continue;

				s = map[ny][nx] + s;

				solve(ny, nx, depth + 1, s);

				s = s.substring(1);

			}
		}

	} // end of solve
}
