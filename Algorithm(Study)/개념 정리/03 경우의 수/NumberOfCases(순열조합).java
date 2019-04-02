import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfCases {
	static char[] arr = { 'a', 'b', 'c', 'd' };
	static int r = 2;

	//arr배열에서 r개를 선택한다.
	//선택된 요소들은 set배열에 저장.
	public static void main(String[] args) {

		set = new char[r];
		System.out.println("==조합==");
		// nCr(0,0);
		// comb(0,0);

		System.out.println("==중복조합==");
		Hcomb(0, 0);
		// nHr(0,0);
		// System.out.println("==중복순열==");
		// nPir(0);
		setList = new ArrayList<>();
		// subset(0,0);

		visit = new boolean[arr.length];
		// nPr(0);
	}

	static char[] set;

	public static void nCr(int len, int k) { // 조합
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}

		for (int i = k; i < arr.length; i++) {
			set[len] = arr[i];
			nCr(len + 1, i + 1);
		}
	}

	public static void comb(int len, int k) { // 조합
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}
		if (k == arr.length)
			return;

		set[len] = arr[k];

		comb(len + 1, k + 1);
		comb(len, k + 1);

	}

	public static void Hcomb(int len, int k) { // 중복조합
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}
		if (k == arr.length)
			return;

		set[len] = arr[k];

		Hcomb(len + 1, k);
		Hcomb(len, k + 1);

	}

	public static void nHr(int len, int k) { // 중복조합
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}

		for (int i = k; i < arr.length; i++) {
			set[len] = arr[i];
			nHr(len + 1, i);
		}
	}

	static boolean[] visit;

	public static void nPr(int len) {// 순열
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				set[len] = arr[i];
				visit[i] = true;
				nPr(len + 1);
				visit[i] = false;
			}
		}
	}

	public static void nPir(int len) {// 중복순열
		if (len == r) {
			System.out.println(Arrays.toString(set));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			set[len] = arr[i];
			nPir(len + 1);
		}
	}

	static ArrayList<Character> setList;

	public static void subset(int len, int k) {// 부분집합
		System.out.println(setList);
		if (len == arr.length) {
			return;
		}
		for (int i = k; i < arr.length; i++) {
			setList.add(arr[i]);
			subset(len + 1, i + 1);
			setList.remove(setList.size() - 1);
		}
	}
}
