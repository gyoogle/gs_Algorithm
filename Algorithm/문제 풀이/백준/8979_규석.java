package com.ssafy.incheon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 입력 값
 * 4 3 (나라 수, 국가 번호)
 * 1 1 2 0 (국가 번호, 금메달, 은메달, 동메달)
 * 2 0 1 0
 * 3 0 1 0
 * 4 0 0 1
 * 
 * 출력 값
 * 4개 국가 중 3번째 국가 순위 출력 : 3번은 0 1 0으로 공동 2위
 * 
 * 나라 배열 생성 후, 금은동을 String으로 저장
 * 
 * 즉, 위에 입력 값은 아래와 같이
 * 
 * arr[1] = "120" (금1은2동0)
 * arr[2] = "010"
 * arr[3] = "010"
 * arr[4] = "001"
 * 
 * 추후에 내림차순 정렬하면, String이 큰수부터 차례로 정렬
 */

public class Problem8979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt(); // 나라 수 입력
		int rankChk = sc.nextInt(); // 등수 알고 싶은 나라 입력
		
		String[] countryArr = new String[count]; // 나라 저장 배열
		String[] g = new String[count]; // 금메달 저장 배열
		String[] s = new String[count]; // 은메달 저장 배열
		String[] b = new String[count]; // 동메달 저장 배열
		
		
		for (int i = 0; i < count; i++) { // 입력 값
			int country = sc.nextInt();
			int gold = sc.nextInt();
			int silver = sc.nextInt();
			int bronze = sc.nextInt();
			
			//문자열로 변환해서 각 배열에 저장
			g[country-1] = Integer.toString(gold); 
			s[country-1] = Integer.toString(silver);
			b[country-1] = Integer.toString(bronze);
		}
		
		int maxNum = 0; // 배열에서 자릿수 최대 값 저장
		
		for (int i = 0; i < count; i++) {
			//배열 돌면서 자릿수 최대 값 찾기
			int m = Math.max(g[i].length(), s[i].length());
			int num = Math.max(m, b[i].length());
			
			//maxNum에 저장
			if (maxNum <= num) maxNum = num;
		}
		
		// countryArr에 저장시키기
		// 각 메달의 자릿수가 달랐을 때 문자열 변환 저장 과정에서 순위가 잘못 출력되는 경우를 해결하기 위한 과정
		for (int i = 0; i < count; i++) {
			
			String newG = "";
			String newS = "";
			String newB = "";
			
			//각각 최대 자릿수 maxNum에서 메달 길이 만큼 뺀 값을 저장
			int chkg = maxNum - g[i].length();
			int chks = maxNum - s[i].length();
			int chkb = maxNum - b[i].length();
			
			//만약 금메달이 1000개면 1000으로 저장되고
			//만약 다른 나라의 금메달이 1개면 0001로 저장하기 위해 (이래야 비교할 수 있음)
			if(chkg > 0){
				for(int j = 0; j < chkg; j++){
					newG += "0";
				}
			}
			if(chks > 0){
				for(int j = 0; j < chks; j++){
					newS += "0";
				}
			}
			if(chkb > 0){
				for(int j = 0; j < chkb; j++){
					newB += "0";
				}
			}
			
			newG += g[i];
			newS += s[i];
			newB += b[i];
			
			//값을 countryArr 배열에 저장
			countryArr[i] = newG +','+ newS +','+ newB;
		}
		
		
		String[] copyArr = new String[count]; // 나라 저장 배열 복사
		for (int i = 0; i < count; i++) {
			copyArr[i] = countryArr[i];
		}
		
		
		
		//내림차순 정렬
		Arrays.sort(copyArr, String.CASE_INSENSITIVE_ORDER);
		
		List<String> list = Arrays.asList(copyArr);
		Collections.reverse(list);
		
		copyArr = list.toArray(new String[list.size()]); // 정렬 완료

		//순위 확인
		for (int j = 0; j < count; j++) {
			if(countryArr[rankChk-1].equals(copyArr[j])){
				System.out.println(j+1);
				break;
			}
		}
	}
}