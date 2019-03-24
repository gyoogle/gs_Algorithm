import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_설탕배달_김규석 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int min = Integer.MAX_VALUE;
		int cnt = 0;

		if (N % 5 == 0) { // 5킬로 봉지만으로 모두 가능하면
			cnt = N / 5;
			if (min > cnt)
				min = cnt;
		}
		if (N % 3 == 0) { // 3킬로 봉지만으로 모두 가능하면
			cnt = N / 3;
			if (min > cnt)
				min = cnt;
		}

		cnt = 0;
		while (N > 5) { // 5를 빼주면서 3과 나눠지는지 확인
			cnt++; //5봉지 수 추가
			N -= 5;

			if (N % 3 == 0) { // 3과 나눠주면 개수 체크
				int res = cnt + N / 3;
				if (min > res)
					min = res;
			}
		}

		if (min == Integer.MAX_VALUE) // min값 변화 없으면 -1
			min = -1;

		System.out.println(min);
	}

}
