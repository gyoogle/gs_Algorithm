package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 
 * �� ���δ� �������� �̿��Ѵ�.
�� ���δ� ������ �ʹ� ���� 1�� ���� �� ���� �̿� ��ȹ�� �����ϰ� ���� ���� ������� �������� �̿��� �� �ִ� ����� ã�� �ִ�.
�����忡�� �Ǹ��ϰ� �ִ� �̿���� �Ʒ��� ���� 4 �����̴�.
    �� 1�� �̿�� : 1�� �̿��� �����ϴ�.
    �� 1�� �̿�� : 1�� ���� �̿��� �����ϴ�. 1�� �̿���� �Ŵ� 1�Ϻ��� �����Ѵ�.
    �� 3�� �̿�� : 3�� ���� �̿��� �����ϴ�. 3�� �̿���� �Ŵ� 1�Ϻ��� �����Ѵ�.
        (11��, 12������ 3�� �̿���� ����� �� �ִ�)
    �� 1�� �̿�� : 1�� ���� �̿��� �����ϴ�. 1�� �̿���� �ų� 1�� 1�Ϻ��� �����Ѵ�.
 �� ���� �̿� ��ȹ�� [Table 1]�� ���·� �����ȴ�.
          	        1��  2��  3��  4��  5��  6��  7��  8��  9��  10��  11��   12��
 �̿� ��ȹ       0��  0��  2��  9��  1��  5��  0��  0��   0��   0��  0��     0��
 
[Table 1]
�̿� ��ȹ�� ��Ÿ���� ���ڴ� �ش� �޿� �������� �̿��� ���� ���� �ǹ��Ѵ�.
�� �̿���� ��ݰ� �� ���� �̿� ��ȹ�� �Է����� �־��� ��,
���� ���� ������� �������� �̿��� �� �ִ� ����� ã�� �� ����� �������� ����ϴ� ���α׷��� �ۼ��϶�.

[����]
�����忡�� �Ǹ��ϴ� 1�� �̿��, 1�� �̿��, 3�� �̿��, 1�� �̿���� ����� ���� 10��, 40��, 100��, 300���̴�.
�� �� �������� �̿��� �� �ִ� ����� [Table 2]�� ���� �پ��� ��츦 ������ �� �ִ�.


�̿��ϴ� ���                                         			�̿��                             			���
1�� ���)                   			1�� �̿�� 17�� :      				                        170��
��� 1�� �̿�����θ� �̿��Ѵ�.     			            17 * 10�� = 170��
2�� ���)                   			1�� �̿�� 4�� :       				                        160��
��� 1�� �̿�����θ� �̿��Ѵ�.     			   	4 * 40�� = 160��
3�� ���)
3���� 1�� �̿������ �̿��ϰ�		1�� �̿�� 2��, 3�� �̿�� 1�� :				            120��
4��, 5��, 6���� 3�� �̿������ �̿��Ѵ�.			2 * 10�� + 1 * 100�� = 120��
4�� ���)
3���� 5���� 1�� �̿������ �̿��ϰ�		1�� �̿�� 3��, 1�� �̿�� 2�� :		                        	110��
4���� 6���� 1�� �̿������ �̿��Ѵ�.				3 * 10�� + 2 * 40�� = 110��
5�� ���)
1�� �̿������ �̿��Ѵ�.			1�� �̿�� 1�� :							300��
 							1 * 300�� = 300��

[Table 2]
�ٸ� ��쵵 ����������, ���� ���� ������� �������� �̿��� ���� 4�� ����̴�.
����, ������ 110�� �ȴ�.


[���� ����]
1. �ð� ���� : �ִ� 50�� �׽�Ʈ ���̽��� ��� ����ϴ� �� C/C++/Java ��� 3��
2. ��� ������ �̿�� ����� 10 �̻� 3,000 ������ �����̴�.
3. �� ���� �̿� ��ȹ�� �� ���� ������ ���ں��� ũ�� �ʴ�.
[�Է�]
�Է��� �� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����, �� ���� �ٺ��� T���� �׽�Ʈ ���̽��� �־�����.
�� �׽�Ʈ ���̽��� ù ��° �ٿ��� 1�� �̿���� ���, 1�� �̿���� ���, 3�� �̿���� ���, 1�� �̿���� ����� ������� �� ĭ�� ��� �־�����.
�� ���� �ٿ��� 1������ 12�������� �̿� ��ȹ�� �־�����.
[���]
�׽�Ʈ ���̽� ������ŭ T���� �ٿ� ������ �׽�Ʈ ���̽��� ���� ���� ����Ѵ�.
�� ���� "#t"�� �����ϰ� ������ �ϳ� �� ���� ������ ����Ѵ�. (t�� 1���� �����ϴ� �׽�Ʈ ���̽��� ��ȣ�̴�)
����ؾ� �� ������ �̿� ��ȹ��� �������� �̿��ϴ� ��� �� ���� ���� �����ϴ� ����̴�. 
[�Է� ��]											
10                                                
10 40 100 300                                     
0 0 2 9 1 5 0 0 0 0 0 0                           
10 100 50 300                                     
0 0 0 0 0 0 0 0 6 2 7 8                           
10 70 180 400                                     
6 9 7 7 7 5 5 0 0 0 0 0                           
10 70 200 550                                     
0 0 0 0 8 9 6 9 6 9 8 6                           
10 80 200 550                                     
0 8 9 15 1 13 2 4 9 0 0 0
10 130 360 1200
0 0 0 15 14 11 15 13 12 15 10 15
10 180 520 1900
0 18 16 16 19 19 18 18 15 16 17 16
10 100 200 1060
12 9 11 13 11 8 6 12 8 7 15 6
10 170 500 1980
19 18 18 17 15 19 19 16 19 15 17 18
10 200 580 2320
12 28 24 24 29 25 23 26 26 28 27 22

[��� ��]
#1 110
#2 100   
#3 400   
#4 530   
#5 430   
#6 1080  
#7 1840  
#8 800   
#9 1980  
#10 2260
 *
 */
public class ������_��Լ� {


	static String[] v;
	static int[] val;
	static int[] w;
	static int[] dp;
	static int[] copydp;
	static int[] set;
	static int threeMonth;
	static int k;
	static int min;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ts = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= 10; t++) {

			v = br.readLine().trim().split(" ");
			val = new int[v.length];
			for (int i = 0; i < val.length; i++) {
				val[i] = Integer.parseInt(v[i]);
			}

			w = new int[12];
			dp = new int[12]; // 1~12��

			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

			for (int i = 0; i < w.length; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}

			// 1�� �̿��
			for (int i = 0; i < dp.length; i++) {
				if (w[i] != 0) {
					dp[i] = w[i] * val[0];
				}
			}
			// 1�� �̿��
			for (int i = 0; i < dp.length; i++) {
				if (w[i] != 0) {
					if (dp[i] > val[1]) {
						dp[i] = val[1];
					}
				}
			}
			min = Integer.MAX_VALUE;
			// 3�� �̿��
			for (int i = 0; i < 12; i++) {
				threeMonth = 0;
				k = 0;
				copydp = new int[12];
				int chk = checking(i);
				if (chk < min) {
					min = chk;
				}
			}

			// 1�� �̿��
			int result = 0;

			if (val[3] < min) {
				result = val[3];
			} else {
				result = min;
			}

			System.out.println("#" + t + " " + result);
		}

	}

	public static int checking(int i) { // i���� i+2����
		for (int j = 0; j < copydp.length; j++) {
			copydp[j] = dp[j];
		}


		int sum = 0;
		int[] idx = new int[3];
		int index = 0;
		for (int j = i; j <= i + 2; j++) {
			k = j;
			if(k>=12) {
				k-=12;
			}
			idx[index++] = k;
			sum += copydp[k];
		}

		if (sum > val[2]) {
			threeMonth += val[2];
			for (int j = 0; j < idx.length; j++) {
				copydp[idx[j]] = 0;
			}
		}
		sum = 0;
		idx = new int[3];
		index = 0;
		int ccc = k+1;
		for (int j = ccc; j <= ccc+2; j++) {
			k = j;
			if(k>=12) {
				k-=12;
			}
			idx[index++] = k;
			sum += copydp[k];
		}
		
		if (sum > val[2]) {
			threeMonth += val[2];
			for (int j = 0; j < idx.length; j++) {
				copydp[idx[j]] = 0;
			}
		}
		sum = 0;
		idx = new int[3];
		index = 0;
		ccc = k+1;
		for (int j = ccc; j <= ccc+2; j++) {
			k = j;
			if(k>=12) {
				k-=12;
			}
			idx[index++] = k;
			sum += copydp[k];
		}
		if (sum > val[2]) {
			threeMonth += val[2];
			for (int j = 0; j < idx.length; j++) {
				copydp[idx[j]] = 0;
			}
		}
		sum = 0;
		idx = new int[3];
		index = 0;
		ccc = k+1;
		for (int j = ccc; j <= ccc+2; j++) {
			k = j;
			if(k>=12) {
				k-=12;
			}
			idx[index++] = k;
			sum += copydp[k];
		}
		if (sum > val[2]) {
			threeMonth += val[2];
			for (int j = 0; j < idx.length; j++) {
				copydp[idx[j]] = 0;
			}
		}
		int r = 0;
		for (int j = 0; j < copydp.length; j++) {
			r += copydp[j];
		}

		return r + threeMonth;
	}

}
