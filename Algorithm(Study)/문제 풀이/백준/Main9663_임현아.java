package acmicpc;

import java.util.Scanner;

public class Main9663_������ {
	
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// ü���� �Է�, -1�� ���� ���� ���� ���� �ʱ�ȭ
		int[] chase = new int[n];
		for(int i=0; i<n; i++) chase[i] = -1; 
		
		// ��Ʈ��ŷ �Լ� ȣ��
		backtrack(chase, 0); 
		
		System.out.println(cnt);
		
	}

	/**
	 * backtracking �� ���� �Լ�
	 * @param chase : ü����
	 * @param n : �־���� idx
	 */
	private static void backtrack(int[] chase, int n) {
		// TODO Auto-generated method stub
		if(n == chase.length) { // �� �̻� �� �ڸ��� ���ٸ�
			cnt++; // cnt����
			return;
		}
		
		// n�� �־��ִ� ����
		for(int i=0; i<chase.length; i++) {
			if(chase[i] == -1 && isNotDiagonal(chase, i, n)) { // i��°�� ���� ����, �ش� ��ġ�� ���� �־ �ȴٸ�
				chase[i] = n; // ���� �־��� ��, 
				backtrack(chase, n+1); // ���� ���� �־��ֵ��� �Ѵ�.
				chase[i] = -1; // i�� n�� ���� ���� �˻������Ƿ�, �ٽ� -1���� �ʱ�ȭ ���� �Ŀ� ���� i�� ����.
			}
		}
	}

	/**
	 * �밢���� �����ϴ� ���� �˻��ϴ� �Լ�
	 * @param chase : üũ��
	 * @param i : �� �ε��� (== row)
	 * @param n : �� (== column)
	 * @return �밢���� �����Ѵٸ� false, �������� ������ true
	 */
	private static boolean isNotDiagonal(int[] chase, int i, int n) {
		// TODO Auto-generated method stub
		for(int j=0; j<chase.length; j++) { // chase�� �˻��Ѵ�.
			if(chase[j] != -1) { // ���� �����Ѵٸ�
				if(Math.abs(i - j) == Math.abs(n - chase[j])) // �ش���ǥ�� ���Ⱑ 1, -1�̸� �밢���� �ִ�.
					return false;
			}
		}
		return true;
	}
	
}
