package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1931_ȸ�ǽǹ���_�ּ�ȣ {
	
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1]==o1[1]) { // ȸ�� ������ �ð��� ������
					return o1[0]-o2[0]; // ȸ�� ���� �ð����� ����
				}
				else return o1[1]-o2[1]; // �ƴϸ� ������ �ð����� ����
			}
		});
		
		int now = 0;
		int cnt = 1;
		
		for (int i = 1; i < n; i++) {
			// ���� ȸ���� ���۽ð��� ���� ȸ���� ����ð����� ������ continue
			if(arr[i][0] < arr[now][1]) continue;
			cnt++;
			now = i;
		}
		
		System.out.println(cnt);
		
	} // end of main
} // end of class
