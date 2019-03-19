package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3074_�Ա��ɻ�_��Լ� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	//�ɻ�밳�� 1<=N<=10^5
			int M = Integer.parseInt(st.nextToken());	//������ο��� 1<=M<=10^9
			int[] t = new int [N];
			for (int i = 0; i < t.length; i++) {
				t[i] = Integer.parseInt(br.readLine().trim());
			}
			long start = 0;
			long end = 1000000000L * M;
			long min = Long.MAX_VALUE;	//time �ּҰ�
			while(start <= end) {
				long mid = (start + end) / 2;
				long cnt = 0;	//������ mid �ð��ȿ� ����� �� �ִ� �ο���
				for (int i = 0; i < t.length; i++) {
					cnt += mid / t[i];
				}
				if(cnt >= M && min > mid) {
					min = mid;
				}
				if(cnt < M) {
					start = mid + 1;
				} else if(M <= cnt) {
					end = mid - 1;
				}
			}
			System.out.println(min);
		}
	}//end of main
}//end of class
