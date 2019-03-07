import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class C implements Comparable<C> {
	int start;
	int end;
	
	C(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(C o) {
		return this.start < o.start ? -1 : 1;
	}
}

public class Main1828_³ÃÀå°í_±è±Ô¼® {

	static int cnt = 1;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		C[] c = new C[N];
		
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			c[i] = new C(s1, s2);
		}
		
		Arrays.sort(c);
		
		
		int max = c[0].end;
		
		for (int i = 1; i < c.length; i++) {
			
			
			if(c[i].start > max) {
				cnt++;
				max = c[i].end;
			}	
			else {
				if(c[i].end < max) {
					max = c[i].end;
				}
			
			}
			
		}
		
		System.out.println(cnt);
	}

}
