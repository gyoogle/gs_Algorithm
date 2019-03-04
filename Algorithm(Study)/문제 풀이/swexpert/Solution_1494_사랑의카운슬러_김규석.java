package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 지렁이 개수 짝수개, 둘씩 짝을 지어줌
 * 짝을 지어주는 모든 경우의 수를 생각해보고, 각각의 짝이 연결되는 벡터룰 구해서, 벡터의 전체 합을 구한뒤, 벡터 전체합의 크기를 구한다.
 * 이렇게 만든 벡터전체합의 크기의 최소값을 찾는 문제
 * 
 * 팁 : 벡터상의 출발 위치에 있는 지렁이 좌표의 합 - 벡터상의 도착위치에 있는 지렁이 좌표의 합 = 벡터전체의 합
 * 	그러므로 출발위치 지렁이 끼리는 변경되더라도 벡터전체의 합은 동일하다
 * 		   도착위치 지렁이 끼리는 변경되더라도 벡터전체의 합은 동일하다
 * 	결국, 출발위치의 그룹, 도착위치의 그룹으로 분할하는 문제 = 출발 위치에 올 수 있는 N/2 마리 지렁이를 선택하는 조합문제
 * 
 *  1번방법 : 순수 조합문제로 조합이 완성되었을 때, 좌표들의 합을 구해서, 벡터크기의 최소값을 업데이트한다. 196ms
 *  2번방법 : 조합을 재귀호출시 지렁이의 선택여부에 따라 좌표들의 합을 매개변수로 전달한다. (효율적) 163ms
 */
public class Solution_사랑의카운슬러_김규석 {
	
	public static int sumX, sumY; //전체 X, Y 원소의 합
	public static int[][] m; // 지렁이 위치
	public static long min; // 전체 벡터합의 크기중 최소값, 크기는 좌표의 제곱이라서 int 형을 넘어갈 수 있다.
	
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
			int sumSelectX = 0; // 선택한 지렁이의 x좌표 합
			int sumSelectY = 0;
			for (int i = 0; i < size; i++) {
				sumSelectX += m[set[i]][0];
				sumSelectY += m[set[i]][1];
			}
			
			int sumUnselectX = sumX - sumSelectX; // 선택하지 않은 지렁이의 좌표의 합
			int sumUnselectY = sumY - sumSelectY;
			
			long vX = sumSelectX - sumUnselectX;
			long vY = sumSelectY - sumUnselectY;
			long v = vX * vX + vY * vY; // 벡터 전체합의 크기
			if(min > v) min = v;
			return;
			
		} else if (N == index) return;
		
		set[size] = index;
		comb(set, size+1, N, K-1, index+1);
		comb(set, size, N, K, index+1);
	}
}
