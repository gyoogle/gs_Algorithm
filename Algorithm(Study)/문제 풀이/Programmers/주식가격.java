class 주식가격 {
    public static int[] solution(int[] prices) {
		int len = prices.length;
        int[] answer = new int[len];
         
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(prices[i] > prices[j] || j == len - 1){
                    answer[i] = j - i;
                    break;
                }
            }
        }
        answer[len - 1] = 0;
        return answer;
    }
}
