import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1057 {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		int x;
		for(int i=1;i<=N;i++) {
			x=0;
			if(i==a || i==b) {
				x = 1;
			}
			q.add(x);
		}
		
		int round=0;
		while(!q.isEmpty()) {
			++round;
			int size = q.size();
			for(int i=0;i<size/2;i++){
			
				
				int p1= q.poll();
				int p2= q.poll();
				int next = p1 | p2;
				if((p1&p2) ==1) {
					System.out.println(round);
					return;
				}
				q.add(next);
			}
			if(size%2==1) {//홀수
				q.add(q.poll());
			}
			
			
		}
		
	}
}
