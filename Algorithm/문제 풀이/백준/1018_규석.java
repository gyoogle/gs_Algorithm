import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt(); //행
		int M = s.nextInt(); //열
		
		int[][] c = new int[N][M]; // 체스판
		String[] str = new String[N]; //한줄씩 저장
		char[][] save = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			str[i] = s.next();
		}
		
		for (int i = 0; i < save.length; i++) {
			for (int j = 0; j < save[i].length; j++) {
				save[i][j] = str[i].charAt(j);
			}
		}
		
		int min = 10000;
		int result = 0;
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				
				int cnt1 = 0;
				int cnt2 = 0;
				
				for (int x = i, m=0; x < 8+i; x++, m++) {
					for (int y = j, n=0; y < 8+j; y++, n++) {
						char cp = ((x+y)%2 == 0) ? 'W' : 'B';
						if(save[x][y] != cp) cnt1++;
						else cnt2++;
					}
				}
				
				if(cnt1 > cnt2) result = cnt2;
				else result = cnt1;
				
				if(min > result) min = result;
			}
		}
		
		System.out.println(min);
		
	}

}