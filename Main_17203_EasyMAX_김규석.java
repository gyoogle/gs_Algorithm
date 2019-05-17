import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17203_EasyMAX_±è±Ô¼® {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		
		int[] num = new int[N];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			
			int sum = 0;
			
			for (int j = first; j < second; j++) {
				
				sum += Math.abs(num[j+1] - num[j]);
				
			}
			
			System.out.println(sum);
		}
	}

}
