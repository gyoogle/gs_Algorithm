class 카펫 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int sum = brown + red;
        int a = 0; int b = 0;
        for (int i = 3; i <= Math.sqrt(sum); i++) {
			if(sum % i == 0) {
				
				int len = sum / i;
				
				if((len*2)+((i-2)*2) == brown) {
					a = len;
					b = i;
					break;
				}
				
			}
		}
        
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}
