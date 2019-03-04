package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ ���� ¦����, �Ѿ� ¦�� ������
 * ¦�� �����ִ� ��� ����� ���� �����غ���, ������ ¦�� ����Ǵ� ���ͷ� ���ؼ�, ������ ��ü ���� ���ѵ�, ���� ��ü���� ũ�⸦ ���Ѵ�.
 * �̷��� ���� ������ü���� ũ���� �ּҰ��� ã�� ����
 * 
 * �� : ���ͻ��� ��� ��ġ�� �ִ� ������ ��ǥ�� �� - ���ͻ��� ������ġ�� �ִ� ������ ��ǥ�� �� = ������ü�� ��
 * 	�׷��Ƿ� �����ġ ������ ������ ����Ǵ��� ������ü�� ���� �����ϴ�
 * 		   ������ġ ������ ������ ����Ǵ��� ������ü�� ���� �����ϴ�
 * 	�ᱹ, �����ġ�� �׷�, ������ġ�� �׷����� �����ϴ� ���� = ��� ��ġ�� �� �� �ִ� N/2 ���� �����̸� �����ϴ� ���չ���
 * 
 *  1����� : ���� ���չ����� ������ �ϼ��Ǿ��� ��, ��ǥ���� ���� ���ؼ�, ����ũ���� �ּҰ��� ������Ʈ�Ѵ�. 196ms
 *  2����� : ������ ���ȣ��� �������� ���ÿ��ο� ���� ��ǥ���� ���� �Ű������� �����Ѵ�. (ȿ����) 163ms
 */
public class Solution_�����ī���_��Լ� {
	
	public static int sumX, sumY; //��ü X, Y ������ ��
	public static int[][] m; // ������ ��ġ
	public static long min; // ��ü �������� ũ���� �ּҰ�, ũ��� ��ǥ�� �����̶� int ���� �Ѿ �� �ִ�.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			
			m = new int[N][2];
			sumX = 0;
			sumY = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				m[i][0] = x;
				m[i][1] = y;
				
				sumX += x;
				sumY += y;
			}
			int[] set = new int[100];
			
			min = Long.MAX_VALUE;
			comb(set, 0, N, N/2, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void comb(int[] set, int size, int N, int K, int index) {
		
		if(K==0) {
			int sumSelectX = 0; // ������ �������� x��ǥ ��
			int sumSelectY = 0;
			for (int i = 0; i < size; i++) {
				sumSelectX += m[set[i]][0];
				sumSelectY += m[set[i]][1];
			}
			
			int sumUnselectX = sumX - sumSelectX; // �������� ���� �������� ��ǥ�� ��
			int sumUnselectY = sumY - sumSelectY;
			
			long vX = sumSelectX - sumUnselectX;
			long vY = sumSelectY - sumUnselectY;
			long v = vX * vX + vY * vY; // ���� ��ü���� ũ��
			if(min > v) min = v;
			return;
			
		} else if (N == index) return;
		
		set[size] = index;
		comb(set, size+1, N, K-1, index+1);
		comb(set, size, N, K, index+1);
	}
}
