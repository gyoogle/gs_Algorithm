import java.util.ArrayList;

public class 뉴스클러스터링 {
	
	static ArrayList<String> arr1;
	static ArrayList<String> arr2;
	static StringBuilder sb;
	
	public static void make(ArrayList<String> arr, String str) {
		
		char c1, c2;
		int chk1 = 0; int chk2 = 0;
		
		for (int i = 0; i < str.length()-1; i++) {
			sb = new StringBuilder();
			c1 = str.charAt(i);
			c2 = str.charAt(i+1);
			chk1 = c1 - '0';
			chk2 = c2 - '0';
			
			if((chk1 >=17 && chk1 <= 42) || (chk1 >= 49 && chk1 <= 74)) {
				
			} else continue;
			
			if((chk2 >=17 && chk2 <= 42) || (chk2 >= 49 && chk2 <= 74)) {
				sb.append(c1).append(c2);
				arr.add(sb.toString());
			}
		}
	}
	
	public static int solution(String str1, String str2) {
		int answer = 0;
		
		arr1 = new ArrayList<>();
		make(arr1, str1);
		
		arr2 = new ArrayList<>();
		make(arr2, str2);
		
		int len = arr1.size() + arr2.size();
		
		int common = 0;
		
		loop : for (int i = 0; i < arr1.size(); i++) {
			String a1 = arr1.get(i).toLowerCase();
			for (int j = 0; j < arr2.size(); j++) {
				if(arr2.get(j).toLowerCase().equals(a1)) {
					common += 1;
					arr2.remove(j);
					continue loop;
				}
			}
		}
		
		len -= common;
		
		if(len == 0) {
			answer = 65536;
		}
		else {
			int d = common * 65536 / len;
			answer = d;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		String str1 = "FRANCE";
		String str2 = "french";

		System.out.println(solution(str1, str2));
	}

}
