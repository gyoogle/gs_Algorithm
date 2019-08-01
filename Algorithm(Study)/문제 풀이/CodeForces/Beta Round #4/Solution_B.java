import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B {

	static int d, sumTime;
	static int min, max;
	static int[] minArr;
	static int[] maxArr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		d = Integer.parseInt(st.nextToken());
		sumTime = Integer.parseInt(st.nextToken());
		
		int minNum = 0;
		int maxNum = 0;
		minArr = new int[d];
		maxArr = new int[d];
		
		for (int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			minArr[i] = min;
			maxArr[i] = max-min;
			minNum += min;
			maxNum += max;
		}
		
		if(sumTime < minNum || sumTime > maxNum) System.out.println("NO");
		else {
			System.out.println("YES");
			
			int n = sumTime - minNum;
			
			for (int i = 0; i < d; i++) {
				
				if(maxArr[i] <= n) {
					minArr[i] += maxArr[i];
					n -= maxArr[i];
					if(n == 0) break;
				}
				else { // maxArr[i] > n
					minArr[i] += n;
					break;
				}
			}
			
			for (int i = 0; i < minArr.length; i++) {
				System.out.print(minArr[i] + " ");
			}
		}
	}

}
