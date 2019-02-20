import java.util.Arrays;

/**
 *
 * 특정 문자열의 모든 부분 문자열을 정렬된 상태로 알고 싶을 때
 * 특정 문자열의 모든 접미사를 구함 -> 정렬 -> 각 접미사의 모든 접두사를 구함
 * 
 * 트라이(Trie) : 문자열의 집합을 표현하는 트리
 * 접미사의 트라이 : 문자열의 접미사의 트라이의 압축된 표현
 *
 * 접미어 트리(Suffix Tree) : Compressed Trie를 개선, 문자열 끝에 $를 붙여서 표시
 *     생성 시간복잡도 O[n^2] => O[n log n] => O[n]
 * 접미어 배열(Suffix Array) : 접미어들을 사전식으로 나열한 배열, 속도가 느림, 메모리 절약 1/4, 소스가 간단
 *      생성 시간복잡도 O[n log n]
 * LCP 배열 : (Longest Common Prefix) 최장 공통 접두어, 접미어 배열을 사용시 보조적으로 필요함
 *     두 문자열 사이의 공통 접두어의 길이
 * 
 */

public class Z40_SuffixArray {

	public static void main(String[] args) {
		
		// banana의 모든 부분 문자열을 정렬된 상태로 출력
		String s = "banana";
		
		// s 문자열의 모든 접미사 생성
		int[] sa = new int[s.length()]; // Suffix Array : index번째에서 시작하는 문자열s의 접미사
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i;
		}
		
		// s 문자열의 모든 접미사 정렬 => 전체 알고리즘에서 가장 오래 걸리는 부분
		for (int i = 0; i < sa.length; i++) { // 선택 정렬
			int minIndex = i;
			for (int j = i; j < sa.length; j++) {
				// s.substring(sa[minIndex])와 s.substring(sa[j])을 비교
				if(s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					minIndex = j;
				}
			}
			
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
		}
		
		// LCP 최장 공통 접두어 저장할 배열을 준비
		int[] LCP = new int[s.length()];
		// LCP[4] = s.substring(sa[3])와 substring(sa[4])의 최장공통접두어의 개수
		for (int i = 1; i < LCP.length; i++) { // 1번부터 시작한다
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while( s1.length() > LCP[i] // 글자가 적을 경우 index 에러 발생할 수 있음 
					&& s2.length() > LCP[i] 
					&& s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		
		System.out.println(Arrays.toString(LCP) + " : LCP");
		
		
		/*
		// 출력
		System.out.println(Arrays.toString(sa) + " : Suffix Array");
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]); // 접미사
			System.out.println("<"+str+">");
			
			// 각 접미사의 모든 접두사를 생성
			for (int j = 1; j <= str.length(); j++) {
				System.out.println(str.substring(0, j)); // 접두사 = i~j의 부분문자열
			}
			
			System.out.println(str.length() + " : 접두사의 개수"); // = 해당 접미사의 길이
			System.out.println(LCP[i] + " : 최장공통 접두사의 개수"); // 중복된 문자열의 개수를 파악하기 위해서 사용
			System.out.println(str.length() - LCP[i] + " : 유효한 부분 문자열의 개수"); 
		}
		*/
		
		System.out.println("\n\n문제풀이");
		System.out.println("s문자열에서 만들 수 있는 모든 부분 문자열의 사전식 정렬상태에서 k번째 문자열");
		
		int k = 13;
		int index = k;
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]);
			if (index - (str.length() - LCP[i]) > 0) {
				index = index - (str.length() - LCP[i]); // 유효한 문자열의 개수를 차감
			} else { // 이 접미사의 접두사들에서 k번째 문자열이 포함되어 있다
				System.out.println(str.substring(0, LCP[i] + index)); // k번째 접미사
				break;
			}
		}
		
	} // end of main
} // end of class
