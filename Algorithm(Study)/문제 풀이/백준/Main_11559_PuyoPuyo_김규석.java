import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_11559_PuyoPuyo_김규석 {

	static class puyo {
		int y;
		int x;

		puyo(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static char[][] map = new char[12][6]; // 뿌요뿌요 map 12x6

	static boolean[][] visit; // 전체 visit 배열
	static boolean[][] Alpha; // 세부 visit 배열

	static int AlphaCnt; // 터질 수 있는지 개수 체크

	static ArrayList<puyo> list; // 뿌요 저장하는 리스트

	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	static int time; // 연쇄시간

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 6; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}

		time = 0;
		
		sol();

		System.out.println(time);
	}

	public static void sol() {

		int cnt = 0; // 연쇄 시간

		while (true) {

			list = new ArrayList<>();

			// puyo 위치 저장 (마지막줄부터 확인하기)
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						list.add(new puyo(i, j));
					}
				}
			}

			// 아무것도 없으면 종료
			if (list.size() == 0) {
				time = cnt;
				break;
			}
			

			visit = new boolean[12][6];
			
			// 뿌요마다 dfs를 돌리면서 4개이상 모여있는 곳 체크 (체크된 곳 시작부분 저장)
			for (int i = 0; i < list.size(); i++) {

				int y = list.get(i).y;
				int x = list.get(i).x;

				if (visit[y][x])
					continue; // 이미 뿌요인 곳은 넘어감

				char alpha = map[y][x];

				Alpha = new boolean[12][6];
				
				AlphaCnt = 1; // 갯수
				dfs(y, x, alpha);
				
				if (AlphaCnt >= 4) { // 부실 수 있음

					for (int j = 0; j < 12; j++) {
						for (int z = 0; z < 6; z++) {
							if (Alpha[j][z]) // true일때만 전체 visit에 넣어주기
								visit[j][z] = Alpha[j][z];
						}
					}
				}
			}

			// 만약 visit 배열이 모두 false면 뿌요 진행 불가능 break로 빠져나오기
			boolean check = false;
			loop: for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visit[i][j]) {
						check = true;
						break loop;
					}
				}
			}

			if (!check) {
				time = cnt;
				break;
			}

			// 연쇄시간 증가
			cnt++;

			// 체크한 부분 모두 부시기 (부시고 빈칸 만들어주기)
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visit[i][j]) {
						map[i][j] = '.';
					}
				}
			}

			// 뿌요들 아래로 내려서 빈칸위치 채우기
			for (int i = 0; i < 6; i++) {

				ArrayList<Character> ch = new ArrayList<>();

				for (int j = 11; j >= 0; j--) {
					if (map[j][i] != '.') {
						ch.add(map[j][i]);
						map[j][i] = '.';
					}
				}

				// 다시 아래서부터 채워주기
				int p = 11;
				for (int j = 0; j < ch.size(); j++) {
					map[p--][i] = ch.get(j);
				}

			}

		}
	}

	// 뿌요뿌요 성립하는지 찾는 dfs
	public static void dfs(int y, int x, char alpha) {

		Alpha[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6)
				continue;

			if (map[ny][nx] == alpha && !Alpha[ny][nx]) {
				Alpha[ny][nx] = true;
				AlphaCnt++; // 같은 알파벳이 있으면 갯수 증가
				dfs(ny, nx, alpha);
			}
		}
	}

}
