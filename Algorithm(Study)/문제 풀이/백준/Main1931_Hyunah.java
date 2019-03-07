import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1931_Hyunah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt(); // 회의 시작 시간
			arr[i][1] = sc.nextInt(); // 회의 끝나는 시간
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
                if(o1[1] == o2[1])
                    return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		int last=-1;
		int max=0;
		for(int i=0; i<n; i++) {
			if(last <= arr[i][0]) {
				last = arr[i][1];
				max++;
			}
		}
		
		System.out.println(max);
	}

}
