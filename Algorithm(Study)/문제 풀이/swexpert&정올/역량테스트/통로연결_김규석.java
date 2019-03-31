import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 통로연결_김규석 {

	static int R, C;
	static int targetY, targetX;
	static char[][] map;
	static char result;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static boolean[] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ts = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= ts; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			targetY = 0;
			targetX = 0;
			chk = new boolean[4];

			for (int i = 0; i < R; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < C; j++) {
					map[i][j] = str[j].charAt(0);
				}
			}

			// 낭비되는 곳 없기 때문에 지워진 위치 확인하면 해당 y,x값 갖고 break로 나오기
			loop: for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					switch (map[i][j]) {
					case '|':
						if (map[i - 1][j] == '.') {
							targetY = i - 1;
							targetX = j;
							break loop;
						}
						if (map[i + 1][j] == '.') {
							targetY = i + 1;
							targetX = j;
							break loop;
						}
						break;
					case '-':
						if (map[i][j - 1] == '.') {
							targetY = i;
							targetX = j - 1;
							break loop;
						}
						if (map[i][j + 1] == '.') {
							targetY = i;
							targetX = j + 1;
							break loop;
						}
						break;
					case '+':
						if (map[i - 1][j] == '.') {
							targetY = i - 1;
							targetX = j;
							break loop;
						}
						if (map[i + 1][j] == '.') {
							targetY = i + 1;
							targetX = j;
							break loop;
						}
						if (map[i][j - 1] == '.') {
							targetY = i;
							targetX = j - 1;
							break loop;
						}
						if (map[i][j + 1] == '.') {
							targetY = i;
							targetX = j + 1;
							break loop;
						}
						break;
					case '1':
						if (map[i + 1][j] == '.') {
							targetY = i + 1;
							targetX = j;
							break loop;
						}
						if (map[i][j + 1] == '.') {
							targetY = i;
							targetX = j + 1;
							break loop;
						}
						break;
					case '2':
						if (map[i - 1][j] == '.') {
							targetY = i - 1;
							targetX = j;
							break loop;
						}
						if (map[i][j + 1] == '.') {
							targetY = i;
							targetX = j + 1;
							break loop;
						}
						break;
					case '3':
						if (map[i - 1][j] == '.') {
							targetY = i - 1;
							targetX = j;
							break loop;
						}
						if (map[i][j - 1] == '.') {
							targetY = i;
							targetX = j - 1;
							break loop;
						}
						break;
					case '4':
						if (map[i + 1][j] == '.') {
							targetY = i + 1;
							targetX = j;
							break loop;
						}
						if (map[i][j - 1] == '.') {
							targetY = i;
							targetX = j - 1;
							break loop;
						}
						break;
					}
				}
			}

			
			//빈곳 위치의 4방향 탐색 후 어떤 블록인지 찾기
			for (int dir = 0; dir < 4; dir++) {
				int ny = targetY + dy[dir];
				int nx = targetX + dx[dir];

				if (ny < 0 || nx < 0 || ny >= R || nx >= C)
					continue;

				if (dir == 0) { // 빈 블록의 상 위치
					if (map[ny][nx] == '|' || map[ny][nx] == '+' || map[ny][nx] == '1' || map[ny][nx] == '4')
						chk[0] = true;
				} else if (dir == 1) { // 빈 블록의 하 위치
					if (map[ny][nx] == '|' || map[ny][nx] == '+' || map[ny][nx] == '2' || map[ny][nx] == '3')
						chk[1] = true;
				} else if (dir == 2) { // 빈 블록의 좌 위치
					if (map[ny][nx] == '-' || map[ny][nx] == '+' || map[ny][nx] == '1' || map[ny][nx] == '2')
						chk[2] = true;
				} else if (dir == 3) { // 빈 블록의 우 위치
					if (map[ny][nx] == '-' || map[ny][nx] == '+' || map[ny][nx] == '3' || map[ny][nx] == '4')
						chk[3] = true;
				}
			}

			if (chk[0] && chk[1] && chk[2] && chk[3]) { // 모두 true면 +
				result = '+';
			} else if (chk[0]) {
				if (chk[1])
					result = '|';
				else if (chk[3])
					result = '2';
				else if (chk[2])
					result = '3';
			} else if (chk[1]) {
				if (chk[3])
					result = '1';
				else if (chk[2])
					result = '4';
			} else {
				result = '-';
			}

			System.out.println("#" + t + " " + (targetY + 1) + " " + (targetX + 1) + " " + result);
		}
	}

}
