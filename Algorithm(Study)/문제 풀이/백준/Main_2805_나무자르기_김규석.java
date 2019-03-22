package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기_김규석 {

	static long N;
	static long M;

	static long[] tree;
	static long result;
	static long max = Long.MIN_VALUE;
	static long start, end;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());

		tree = new long[(int) N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(max < tree[i])
				max = tree[i];
		}
		
		start = 0;
		end = max;
		
		result = 0;

		while(start <= end) {
			
			long mid = (start+end)/2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(mid < tree[i])
					sum += tree[i] - mid;
			}
			
			if(sum >= M) {
				if(result < mid)
					result = mid;
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		
		
		System.out.println(result);
	}

}
