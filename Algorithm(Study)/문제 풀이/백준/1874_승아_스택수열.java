import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main1875_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		int now = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<now;i++) {
			
			s.push(++cnt);
			list.add('+');
		}
		int pop = s.pop();
		list.add('-');
		
		
		for(int T=0;T<n-1;T++) {
			now = Integer.parseInt(br.readLine());
			if(now<pop) {
				//while(!s.isEmpty()) {
					if(s.isEmpty()) break;
					pop=s.pop();
					list.add('-');
					if(pop!=now) {
						System.out.println("NO");
						return;
					};
				//}
				
			} else {
				int pushed = cnt;
				for(int i=pushed+1;i<=now;i++) {
					s.push(++cnt);
					list.add('+');
				}
				pop=s.pop();
				list.add('-');
				
			}
			
		}
		
	
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
}
