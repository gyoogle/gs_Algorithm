package CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static final int HASH_SIZE = 1000;
	static final int HASH_LEN = 400;
	static final int HASH_VAL = 17; // �Ҽ��� �� ��
	
	static int[][] data = new int[HASH_SIZE][HASH_LEN];
	static int[] length = new int[HASH_SIZE];
	static String[][] s_data = new String[HASH_SIZE][HASH_LEN];
	static String str;
	static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // �Է� �� (1~100000)
		
		for (int i = 0; i < N; i++) {
			
			str = br.readLine();
			
			int key = getHashKey(str);
			int cnt = checking(key);
			
			if(cnt != -1) { // �̹� ���Դ� ���ڿ�
				sb.append(str).append(cnt).append("\n");
			}
			else sb.append("OK").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int getHashKey(String str) {
		
		int key = 0;
		
		for (int i = 0; i < str.length(); i++) {
			key = (key * HASH_VAL) + str.charAt(i);
		}
		
		if(key < 0) key = -key; // ���� key ���� ������ ����� �ٲ��ֱ�
		
		return key % HASH_SIZE;
		
	}
	
	public static int checking(int key) {
		
		int len = length[key]; // ���� key�� ��� �� (���� key ������ ������ ���ڿ��� ���� �� �ִ�)
		
		if(len != 0) { // �̹� ���� �� ����
			
			for (int i = 0; i < len; i++) { // �̹� ���� ���ڿ��� �ش� key �迭�� �ִ��� Ȯ��
				if(str.equals(s_data[key][i])) {
					data[key][i]++;
					return data[key][i];
				}
			}
			
		}
		
		// ���� ���� �������� �ش� key�迭���� ���ڿ��� �����ϰ� ���� 1 �ø���
		s_data[key][length[key]++] = str;

		return -1; // ó������ ���� ��� -1 ����
	}

}
