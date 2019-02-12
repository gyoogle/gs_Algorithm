package backjoon;

import java.util.Scanner;

public class b8979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 나라 개수
		int k = sc.nextInt(); // 등수가 궁금한 나라
		int[][] arr = new int[n][4]; // n개 나라에 나라번호 , 금 , 은 , 동 데이터 저장
		for (int i = 0; i < n; i++) { // 나라 번호와 메달 정보 입력
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int gold = arr[k-1][1]; // 등수가 궁금한 나라의 금메달 개수
		int silver = arr[k-1][2]; // 등수가 궁금한 나라의 은메달 개수
		int bronze = arr[k-1][3]; // 등수가 궁금한 나라의 동메달 개수
		int cnt_g = 0; // 금메달이 자신보다 더 많은 나라 카운트
		int cnt_s = 0; // 은메달이 자신보다 더 많은 나라 카운트
		int cnt_b = 0; // 동메달이 자신보다 더 많은 나라 카운트
		int[] same_gold = new int[1000]; // 금메달 개수가 같을때 은메달 정보 저장
		int[] same_silver = new int[1000]; // 금메달 개수가 같고 은메달 개수도 같을때 동메달 정보 저장
		int same_gold_index = 0;
		int same_silver_index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(gold < arr[i][1]) { // 금메달 개수가 자신보다 많으면 카운트
				cnt_g++;
			}
			if(gold == arr[i][1]) { // 금메달 개수가 자신과 같으면 그때의 은메달 정보 저장
				same_gold[same_gold_index++] = arr[i][2];
				if(silver == arr[i][2]) { // 금메달 개수가 자신과 같은 것들 중에서 은메달 개수도 같으면 그때의 동메달 정보를 저장
					same_silver[same_silver_index++] = arr[i][3];
				}
			}
		}
		
		for (int i = 0; i <= same_gold_index; i++) { // 금메달 개수가 같았던 나라의 은메달 정보랑 비교
			if(silver < same_gold[i]) {
				cnt_s++;
			}
			if(silver == same_gold[i]) { // 은메달도 같으면
				for(int j = 0; j < same_silver_index; j++) {
					if(bronze < same_silver[j]) { // 그때의 동메달 비교
						cnt_b++;
					}
				}
			}
		}
		
		
		/*for (int i = 0; i < same_gold_index; i++) {
			System.out.println("same gold : " + same_gold[i]);
		}
		for (int i = 0; i < same_silver_index; i++) {
			System.out.println("same silver : " + same_silver[i]);
		}
		System.out.println("cnt_g : " + cnt_g);
		System.out.println("cnt_s : " + cnt_s);
		System.out.println("cnt_b : " + cnt_b);*/
		int sum = cnt_g + cnt_s + cnt_b + 1;
		System.out.println(sum);
	}

}
