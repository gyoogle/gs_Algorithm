import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 하노이탑 {
	
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		sb.append((1<<num)-1).append("\n");
		hanoi(num, '1', '2', '3');
		System.out.println(sb.toString());
	}
	
	public static void hanoi(int top, char from, char mid, char to) {
		if(top == 1) {
			sb.append(from).append(" ").append(to).append("\n");
		}
		else {
			hanoi(top-1, from, to, mid);
			sb.append(from).append(" ").append(to).append("\n");
			hanoi(top-1, mid, from, to);
		}
	}

}
