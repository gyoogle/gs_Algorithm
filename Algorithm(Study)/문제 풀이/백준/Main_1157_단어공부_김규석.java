package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main_1157_단어공부_김규석 {
	
	static HashSet<Character> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split("");
		
		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].toUpperCase();
		}
		
		set = new HashSet<>();
		
		for (int i = 0; i < str.length; i++) {
			set.add(str[i].charAt(0));
		}
		
		int max = 0;
		
		ArrayList<Character> arr = new ArrayList<>(set);
		int[] cnt = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < str.length; j++) {
				if(arr.get(i) == str[j].charAt(0)) {
					cnt[i]++;
				}
			}
			if(max < cnt[i])
				max = cnt[i];
		}
		
		int cnt2 = 0;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] == max) {
				cnt2++;
			}
		}
		
		if(cnt2 > 1) {
			System.out.println("?");
		}
		else {
			
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[i] == max) {
					System.out.println(arr.get(i));
				}
			}
			
		}
	}


}