package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < truck_weights.length; i++) {
			q.add(truck_weights[i]);
		}
		
		int[] time = new int[truck_weights.length];
		for (int i = 0; i < time.length; i++) {
			time[i] = bridge_length;
		}
		int idx = -1;
		int leng = truck_weights.length;
		int sum = 0;
		int truck = 0;
		while(true) {
			answer++;
			
			if(!q.isEmpty() && sum + q.peek() <= weight) {
				idx++;
				truck = q.poll();
				sum += truck;
			}
			
			
			for (int i = 0; i <= idx; i++) {
				if(time[i] == 0) continue;
				time[i]--;
				if(time[i] == 0) {
					sum -= truck_weights[i];
					leng--;
				}
			}
			
			if(leng == 0) {
				answer++;
				break;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

}
