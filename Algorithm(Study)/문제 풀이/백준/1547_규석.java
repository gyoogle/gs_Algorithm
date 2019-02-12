import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1547 {
	
	public static void swap(int[] cup, int a, int b) {
		int temp = cup[a];
		cup[a] = cup[b];
		cup[b] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] cup = new int[3];
		
		cup[0] = 1;
		
		for (int i = 0; i < n; i++) {
			String[] str = new String[2];
			str = br.readLine().split(" ");
			
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			swap(cup, x-1, y-1);
		}
		
		for (int i = 0; i < cup.length; i++) {
			if(cup[i] == 1) {
				System.out.println(i+1);
			}
		}
	}

}