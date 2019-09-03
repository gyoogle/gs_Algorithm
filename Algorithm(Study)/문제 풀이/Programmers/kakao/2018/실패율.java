import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class 실패율 {
	
	public static int N;
	public static int[] stage;
	
	public static class St implements Comparable<St>{
		
		int index;
		double fail;
		
		St(int index, double fail) {
			this.index = index;
			this.fail = fail;
		}

		@Override
		public int compareTo(St o) {
			if(this.fail == o.fail) {
				return (this.index < o.index ? -1 : 1);
			}
			else
				return this.fail > o.fail ? -1 : 1;
		}
		
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        stage = new int[N];
        int count = stages.length; //사람 수
        
        for (int i = 0; i < stages.length; i++) {
			int s = stages[i]-1;
			
			//모두 통과한 사람은 일단 넘김
			if(s >= N) continue;
			
			stage[s]++;
		}
        
        double[] avg = new double[N];
        ArrayList<St> s = new ArrayList<>();
        
        for (int i = 0; i < stage.length; i++) {
			
        	if(count <= 0) avg[i] = 0;
        	else
        		avg[i] = (stage[i] / (double)count);
        	
        	count -= stage[i];
        	
        	System.out.println((i+1) + ", " + avg[i]);
        	
        	s.add(new St(i+1, avg[i]));
		}
        
        Collections.sort(s);
        
        
        for (int i = 0; i < s.size(); i++) {
			answer[i] = s.get(i).index;
		}
        
        return answer;
    }

}
