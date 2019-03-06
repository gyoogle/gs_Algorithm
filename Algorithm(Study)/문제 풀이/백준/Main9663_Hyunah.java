import java.util.Scanner;

public class Main9663_Hyunah{
	
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 체스판 입력, -1로 퀸을 놓지 않은 곳을 초기화
		int[] chase = new int[n];
		for(int i=0; i<n; i++) chase[i] = -1; 
		
		// 백트래킹 함수 호출
		backtrack(chase, 0); 
		
		System.out.println(cnt);
		
	}

	/**
	 * backtracking 을 위한 함수
	 * @param chase : 체스판
	 * @param n : 넣어야할 idx
	 */
	private static void backtrack(int[] chase, int n) {
		// TODO Auto-generated method stub
		if(n == chase.length) {
			cnt++;
			return;
		}
		for(int i=0; i<chase.length; i++) {
			if(chase[i] == -1 && isNotDiagonal(chase, i, n)) {
				chase[i] = n;
				backtrack(chase, n+1);
				chase[i] = -1;
			}
		}
	}

	private static boolean isNotDiagonal(int[] chase, int i, int n) {
		// TODO Auto-generated method stub
		for(int j=0; j<chase.length; j++) {
			if(chase[j] != -1) {
				if(Math.abs(i - j) == Math.abs(n - chase[j]))
					return false;
			}
		}
		return true;
	}
	
}
