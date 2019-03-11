package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기_김규석 {
	private static int[] digit;
	private static int X, min, push;
	private static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			digit = new int[10];
			list = new ArrayList<Integer>();
			set = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 10; i++) {
				digit[i] = Integer.parseInt(st.nextToken());
			}

			String tmp = br.readLine();
			X = Integer.parseInt(tmp);

			//각각의 숫자를 직접 누를 수 있으면 숫자 개수 만큼 출력하고 continue;
			boolean tmpflag = true;
			for (int i = 0; i < tmp.length(); i++) {
				if (digit[tmp.charAt(i) - '0'] == 0) {
					tmpflag = false;
					break;
				}
			}
			if (tmpflag) {
				System.out.println("#" + tc + " " + (int) (tmp.length() + 1));
				continue;

			}

			//약수구하기
			for (int i = 1; i <= Math.sqrt(X); i++) {
				if (X % i != 0)
					continue;

				int val = i;
				boolean flag = true;
				while (val > 0) {
					int r = val % 10; // 1 의 자리 숫자
					if (digit[r] == 0) {
						flag = false;
						break;
					}
					val /= 10;
				}

				if (flag && i != 1)
					list.add(i);

				val = X / i;
				flag = true;
				while (val > 0) {
					int r = val % 10; // 1 의 자리 숫자
					if (digit[r] == 0) {
						flag = false;
						break;
					}
					val /= 10;
				}

				if (flag)
					list.add(X / i);

			}

			min = Integer.MAX_VALUE;
			solve(0, 0);

			System.out.println("#" + tc + " " + ((min < Integer.MAX_VALUE) ? min : -1));
		} // end of tc

	} // end of main

	public static ArrayList<Integer> set;

	public static void solve(int len, int k) {

		// System.out.println(set);

		push = 0;
		set.sort(null);
		cal(X);

		if (len == list.size()) {
			return;
		}

		for (int i = k; i < list.size(); i++) {
			set.add(list.get(i));
			solve(len + 1, i + 1);
			set.remove(set.size() - 1);
		}

	}

	public static void cal(int val) {
		if (val == 1) {
			min = min > push ? push : min;
			return;
		}

		for (int i = set.size() - 1; i >= 0; i--) {

			int y = set.get(i);
			if (val % y == 0) {
				val /= y;
				push += (Integer.toString(y).length() + 1);
				cal(val);
			}
		}
	} // end of cal

}