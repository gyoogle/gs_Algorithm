import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스_김규석 {

	static class Enemy {
		int y;
		int x;

		Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, M, D;
	static int[][] map;
	static int[][] copy;
	static ArrayList<Enemy> enemy;
	static int arr[];
	static int[] set;
	static int max;

	static ArrayList<Enemy> goung;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M]; // 궁수 배치를 위해 행 1열 더 만들어줌
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr = new int[M];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		set = new int[3];
		max = Integer.MIN_VALUE;

		comb(0, 0);

		System.out.println(max);

	}

	public static void sol(int[][] map) {

		int count = 0;

		while (enemy.size() != 0) { // 적이 다 사라질 때까지

			ArrayList<Enemy> delete = new ArrayList<>();

			for (int i = 0; i < goung.size(); i++) {
				int[] dir = new int[enemy.size()];
				int minDir = Integer.MAX_VALUE;

				for (int j = 0; j < enemy.size(); j++) { // 거리 저장
					dir[j] = direction(goung.get(i), enemy.get(j));
					if (minDir > dir[j])
						minDir = dir[j];
				}

				ArrayList<Enemy> chk = new ArrayList<>();

				for (int j = 0; j < enemy.size(); j++) {
					if (dir[j] == minDir) {
						if (dir[j] <= D) { // 최소거리면서 사정거리보다 작으면 사격가능한 적
							chk.add(enemy.get(j));
						}
					}
				}

				if (chk.size() == 0)
					continue; // 사격할 적이 없는 상황. continue로 다음으로 넘김
				else if (chk.size() == 1) { // 1개일 경우
					delete.add(chk.get(0));
				} else if (chk.size() >= 2) { // 2개 이상일 경우
					int minX = Integer.MAX_VALUE;

					for (int j = 0; j < chk.size(); j++) {
						if (minX > chk.get(j).x)
							minX = chk.get(j).x;
					}

					for (int j = 0; j < chk.size(); j++) {
						if (chk.get(j).x == minX) {
							delete.add(chk.get(j));
						}
					}
				}

			}

			// delete에 입력된 적들을 삭제
			for (int i = 0; i < delete.size(); i++) {
				for (int j = 0; j < enemy.size(); j++) {
					if (delete.get(i).y == enemy.get(j).y && delete.get(i).x == enemy.get(j).x) {
						enemy.remove(j);
						count++;
						break;
					}
				}
			}

			// 한칸씩 땡김
			int c = enemy.size(); // 사이즈 수 저장
			int idx = 0;
			while (c > 0) { // c가 0 이상일때까지 반복
				if(enemy.get(idx).y+1 != N)
					enemy.add(new Enemy(enemy.get(idx).y + 1, enemy.get(idx).x));
				enemy.remove(idx);
				c--;
			}
			
		}
		
		if(max < count) max = count;

	}

	public static void comb(int len, int k) {
		if (len == 3) {
			enemy = new ArrayList<>(); // 적을 저장할 리스트 생성
			copy = new int[N + 1][M];
			// map 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
					if (map[i][j] == 1)
						enemy.add(new Enemy(i, j));
				}
			}
			goung = new ArrayList<>();
			// 조합을 활용한 궁수 배치
			for (int i = 0; i < 3; i++) {
				copy[N][arr[set[i]]] = 2;
				goung.add(new Enemy(N, set[i]));
			}
			sol(copy);

			return;
		}
		if (k == arr.length)
			return;

		set[len] = arr[k];
		comb(len + 1, k + 1);
		comb(len, k + 1);

	}

	public static int direction(Enemy g, Enemy e) {
		return Math.abs(g.y - e.y) + Math.abs(g.x - e.x);
	}

}
