import java.util.HashMap;

class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		HashMap<String, Integer> list = new HashMap<>();
		
		for (int i = 0; i < words.length; i++) {
			
			if(list.get(words[i]) == null) {
				list.put(words[i], 1);
			}
			else {
				int start = (i+1)%n;
				
				if(start != 0)
					answer[0] = (i+1)%n;
				else
					answer[0] = n;
				
				
				answer[1] = (i+1)/n;
				if((i+1)%n != 0) answer[1] += 1;
				break;
			}
			
			if(i>=1) {
				//System.out.println(words[i-1] + " : " + words[i]);
				if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
					int start = (i+1)%n;
					
					if(start != 0)
						answer[0] = (i+1)%n;
					else
						answer[0] = n;
					answer[1] = (i+1)/n;
					if((i+1)%n != 0) answer[1] += 1;
					break;
				}
			}
			
		}
		

		return answer;
	}

}
