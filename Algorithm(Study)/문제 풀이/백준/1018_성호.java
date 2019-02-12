package backjoon;

import java.util.Scanner;

public class b1018 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		char[][] arr = new char[N][M];
		String[] array = new String[N]; 
		
		// String으로 입력해서 한글자씩 char형태로
		for(int i = 0; i < N; i++) {
			array[i] = sc.next();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = array[i].charAt(j);
			}
		}
		
		int cnt_b = 0, cnt_w = 0;
		int min_b = 999, min_w = 999, min_result = 0;
		int i_index = 0, j_index = 0;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				cnt_b = 0;
				
				for(int x = i; x < i + 8; x++) {
					for(int y = j; y < j + 8; y++) {
						if((x%2==0 && y%2==0) || (x%2!=0 && y%2!=0)) {
							if(arr[x][y] != 'B')
								cnt_b++;
							continue;
						}
						if((x%2==0 && y%2!=0) || (x%2!=0 && y%2==0)) {
							if(arr[x][y] != 'W')
								cnt_b++;
							continue;
						}
					}
				}
				if(min_b > cnt_b)
					min_b = cnt_b;
			}
		}
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				cnt_w = 0;
				
				for(int x = i; x < i + 8; x++) {
					for(int y = j; y < j + 8; y++) {
						if((x%2==0 && y%2==0) || (x%2!=0 && y%2!=0)) {
							if(arr[x][y] != 'W')
								cnt_w++;
							continue;
						}
						if((x%2==0 && y%2!=0) || (x%2!=0 && y%2==0)) {
							if(arr[x][y] != 'B')
								cnt_w++;
							continue;
						}
					}
				}
				if(min_w > cnt_w) {
					i_index = i;
					j_index = j;
					min_w = cnt_w;
				}
			}
		}
		
		min_result = (min_b < min_w) ? min_b:min_w;
		//System.out.println("i_index : " + i_index);
		//System.out.println("j_index : " + j_index);
		//System.out.println("min_b : " + min_b);
		//System.out.println("min_w : " + min_w);
		System.out.println(min_result);
		
	}// end of main
}
