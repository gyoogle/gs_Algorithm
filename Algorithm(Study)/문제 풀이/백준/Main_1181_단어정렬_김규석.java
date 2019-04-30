import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main_1181_단어정렬_김규석 {
	
	static class N implements Comparable<N> {
		String str;
		int len;
		
		N(String str, int len) {
			this.str = str;
			this.len = len;
		}

		@Override
		public int compareTo(N o) {
			if(this.len == o.len)
				return this.str.compareTo(o.str);
			return this.len < o.len ? -1 : 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < T; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		
		ArrayList<N> res = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			
			res.add(new N(s, s.length()));
		}
		
		Collections.sort(res);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).str);
		}
	}
}
