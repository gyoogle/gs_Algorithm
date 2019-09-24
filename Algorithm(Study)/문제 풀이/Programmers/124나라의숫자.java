import java.util.ArrayList;

public class 124나라의숫자 {
	
	static int[] flag = {4,1,2};
	static ArrayList<Integer> list;
	
	public static String solution(int n) {
		
		list = new ArrayList<>();
		
		while(true) {
			
			int q = n / 3; // 몫
			int r = n % 3; // 나머지
			if(r == 0) q -= 1;
			
			list.add(flag[r]);
			
			n = q;
			
			if(n == 0) break;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 15; i++) {
			System.out.print(solution(i)+" ");
		}
	}

}
