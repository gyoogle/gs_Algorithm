import java.util.Arrays;

class 구명보트 {
    public static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		
		int last = people.length;
		
		for (int i = people.length-1; i >= 0; i--) {
			if(people[i] == limit) {
				answer++;
				last = i;
			}
			else break;
		}
		int start = 0;
		for (int i = 0; i < people.length; i++) {
			if(people[i] + people[last-1] <= limit) {
				answer++;
				last--;
				start = i+1;
			}
			else break;
		}
		
		for (int i = last-1; i >= start; i--) {
			if(people[i] + people[start] > limit) {
				answer++;
			}
			else {
				start++;
				answer++;
			}
		}
		
		return answer;
	}
}
