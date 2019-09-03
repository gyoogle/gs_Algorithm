package algorithm;

public class 비밀지도 {

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < arr1.length; i++) {
			
			String temp1 = Integer.toBinaryString(arr1[i]);
			String temp2 = Integer.toBinaryString(arr2[i]);
			
			String temp = "";
			
			if(temp1.length() < n) {
				for (int j = 0; j < n-temp1.length(); j++) {
					temp += "0";
				}
				temp1 = temp + temp1;
			}
			
			temp = "";
			if(temp2.length() < n) {
				for (int j = 0; j < n-temp2.length(); j++) {
					temp += "0";
				}
				temp2 = temp + temp2;
			}
			String s = "";
			
			for (int j = 0; j < temp1.length(); j++) {
				
				if(temp1.charAt(j) == '1' || temp2.charAt(j) == '1') {
					s+="#";
				}
				else
					s+=" ";
			}
			
			answer[i] = s;
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		
		System.out.println(solution(n, arr1, arr2));
	}

}
