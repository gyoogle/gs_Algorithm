class 정수삼각형 {
    public static int solution(int[][] triangle) {
		int answer = 0;
		
		for (int i = triangle.length-1; i > 0; i--) {
			
			for (int j = 0; j < triangle[i].length-1; j++) {
				
				if(triangle[i][j] >= triangle[i][j+1]) {
					triangle[i-1][j] += triangle[i][j];
				}
				else {
					triangle[i-1][j] += triangle[i][j+1];
				}
				
			}
			
		}
		
		answer = triangle[0][0];
		
		return answer;
	}
}
