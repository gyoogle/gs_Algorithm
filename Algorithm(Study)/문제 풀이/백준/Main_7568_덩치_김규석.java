import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_7568_µ¢Ä¡_±è±Ô¼® {
	
	static class Person {
		int w;
		int h;
		
		Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
	
	static ArrayList<Person> person;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		person = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			person.add(new Person(w,h));
		}
		
		int[] rank = new int[n];
		
		
		for (int i = 0; i < rank.length; i++) {
			int cnt = 1;
			for (int j = 0; j < rank.length; j++) {
				if(i==j) continue;
				if(person.get(i).w < person.get(j).w && person.get(i).h < person.get(j).h) {
					cnt++;
				}
			}
			
			rank[i] = cnt;
		}
		
		for (int i = 0; i < rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
	}

}
