import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1427_�����λ��̵�_��Լ� {

	static class N implements Comparable<N>{
		int n;
		
		N(int n){
			this.n = n;
		}

		@Override
		public int compareTo(N o) {
			return this.n < o.n ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("");
		
		ArrayList<N> list = new ArrayList<>();
		
		for (int i = 0; i < s.length; i++) {
			list.add(new N(Integer.parseInt(s[i])));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).n);
		}
	}

}
