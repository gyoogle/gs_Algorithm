class 기능개발 {
    static int[] count;
	static int[] cnt;
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        count = new int[101];
        cnt = new int[101];
        int idx = 0;
        
        int len = progresses.length;
        
        for (int i = 0; i < progresses.length; i++) {
			
        	int n = (100 - progresses[i])/speeds[i];
        	if((100 - progresses[i])%speeds[i] != 0) n +=1;
        	
        	if(i>=1) {
        		if(count[idx-1] >= n) {
        			count[idx] = count[idx-1];
        			len--;
        		}
        		else count[idx] = n;
        	}
        	else
        		count[idx] = n;
        	idx++;
		}
        
        for (int i = 0; i < idx; i++) {
			cnt[count[i]]++;
		}
        
        answer = new int[len];
        int answerIdx = 0;
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0)
				answer[answerIdx++] = cnt[i];
		}
        
        return answer;
    }
}
