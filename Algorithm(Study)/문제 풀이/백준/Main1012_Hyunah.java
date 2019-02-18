import java.util.Scanner;

public class Main1012_Hyunah {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] gd = new int[m][n];
			boolean[][] visit = new boolean[m][n];
			int k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				gd[sc.nextInt()][sc.nextInt()] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < gd.length; i++) {
				for (int j = 0; j < gd[0].length; j++) {
					if (!visit[i][j] && gd[i][j] == 1) {
						protect(gd, visit, i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void protect(int[][] gd, boolean[][] visit, int a, int b) {
		// TODO Auto-generated method stub
		visit[a][b] = true;
		for (int i = 0; i < 4; i++) {
			int rx = a + dx[i];
			int ry = b + dy[i];
			if (rx >= 0 && rx < gd.length && ry >= 0 && ry < gd[0].length) {
				if (gd[rx][ry] == 1 && !visit[rx][ry])
					protect(gd, visit, rx, ry);
			}
		}
	}

}
