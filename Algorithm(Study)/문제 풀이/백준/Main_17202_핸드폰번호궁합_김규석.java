package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17202_핸드폰번호궁합_김규석 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");
		
		String ans = "";
		
		for (int i = 0; i < str2.length; i++) {
			ans += str1[i];
			ans += str2[i];
		}
		
		String[] ansArr = ans.split("");
		
		while(ansArr.length != 2) {
			
			String temp = "";
			
			for (int i = 0; i < ansArr.length-1; i++) {
				
				int sum = (Integer.parseInt(ansArr[i]) + Integer.parseInt(ansArr[i+1]))%10;
				temp += Integer.toString(sum);
			}
			
			ansArr = temp.split("");
		}
		
		System.out.println(ansArr[0]+ansArr[1]);
	}

}
