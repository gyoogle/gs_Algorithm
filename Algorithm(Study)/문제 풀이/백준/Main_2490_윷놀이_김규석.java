import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490_¿∑≥Ó¿Ã_±Ë±‘ºÆ {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3; i++) {
			
			int c = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < 4; j++) {
				if(Integer.parseInt(st.nextToken()) == 0) {
					c++;
				}
			}
			
			if(c == 0) {
				System.out.println("E");
			} else if ( c == 1) {
				System.out.println("A");
			} else if ( c == 2) {
				System.out.println("B");
			} else if ( c == 3) {
				System.out.println("C");
			} else if ( c == 4) {
				System.out.println("D");
			}
		}
		
	}

}
