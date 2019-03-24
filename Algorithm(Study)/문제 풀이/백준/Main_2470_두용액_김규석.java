import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2470_�ο��_��Լ� {

	static long N;
	static ArrayList<Long> arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		arr = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(arr); // ����
		
		long min = arr.get(0) + arr.get(arr.size()-1); // ���� ���� �� + ���� ū ��
		
		long s = 0; // ����
		long e = arr.size()-1; // ��
		
		long minI = s;
		long maxI = e;
		
		while(s < e) {
			
			long sum = arr.get((int) s) + arr.get((int)e);
			
			if(Math.abs(sum) < Math.abs(min)){
				minI = s;
				maxI = e;
				min = sum;
			}
			
			if(sum < 0) s++;
			else e--;
		}
		
		System.out.println(arr.get((int) minI) + " " + arr.get((int) maxI));
	}
	
}
