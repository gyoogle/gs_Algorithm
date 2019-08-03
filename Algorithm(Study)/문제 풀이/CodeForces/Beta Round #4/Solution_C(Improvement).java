package CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static final int HASH_SIZE = 1000;
	static final int HASH_LEN = 400;
	static final int HASH_VAL = 17; // 소수로 할 것
	
	static int[][] data = new int[HASH_SIZE][HASH_LEN];
	static int[] length = new int[HASH_SIZE];
	static String[][] s_data = new String[HASH_SIZE][HASH_LEN];
	static String str;
	static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 입력 수 (1~100000)
		
		for (int i = 0; i < N; i++) {
			
			str = br.readLine();
			
			int key = getHashKey(str);
			int cnt = checking(key);
			
			if(cnt != -1) { // 이미 들어왔던 문자열
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
		
		if(key < 0) key = -key; // 만약 key 값이 음수면 양수로 바꿔주기
		
		return key % HASH_SIZE;
		
	}
	
	public static int checking(int key) {
		
		int len = length[key]; // 현재 key에 담긴 수 (같은 key 값으로 들어오는 문자열이 있을 수 있다)
		
		if(len != 0) { // 이미 들어온 적 있음
			
			for (int i = 0; i < len; i++) { // 이미 들어온 문자열이 해당 key 배열에 있는지 확인
				if(str.equals(s_data[key][i])) {
					data[key][i]++;
					return data[key][i];
				}
			}
			
		}
		
		// 들어온 적이 없었으면 해당 key배열에서 문자열을 저장하고 길이 1 늘리기
		s_data[key][length[key]++] = str;

		return -1; // 처음으로 들어가는 경우 -1 리턴
	}

}
