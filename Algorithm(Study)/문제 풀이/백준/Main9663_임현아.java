package acmicpc;

import java.util.Scanner;

public class Main9663_임현아 {
	
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
		if(n == chase.length) { // 더 이상 들어갈 자리가 없다면
			cnt++; // cnt증가
			return;
		}
		
		// n을 넣어주는 구문
		for(int i=0; i<chase.length; i++) {
			if(chase[i] == -1 && isNotDiagonal(chase, i, n)) { // i번째에 값이 없고, 해당 위치에 값을 넣어도 된다면
				chase[i] = n; // 값을 넣어준 후, 
				backtrack(chase, n+1); // 다음 값을 넣어주도록 한다.
				chase[i] = -1; // i에 n이 있을 때를 검사했으므로, 다시 -1으로 초기화 해준 후에 다음 i를 본다.
			}
		}
	}

	/**
	 * 대각선에 존재하는 지를 검사하는 함수
	 * @param chase : 체크판
	 * @param i : 들어갈 인덱스 (== row)
	 * @param n : 값 (== column)
	 * @return 대각선에 존재한다면 false, 존재하지 않으면 true
	 */
	private static boolean isNotDiagonal(int[] chase, int i, int n) {
		// TODO Auto-generated method stub
		for(int j=0; j<chase.length; j++) { // chase를 검사한다.
			if(chase[j] != -1) { // 값이 존재한다면
				if(Math.abs(i - j) == Math.abs(n - chase[j])) // 해당좌표의 기울기가 1, -1이면 대각선에 있다.
					return false;
			}
		}
		return true;
	}
	
}
