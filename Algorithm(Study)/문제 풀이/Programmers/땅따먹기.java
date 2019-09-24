class 땅따먹기 {
    static int result;
	static int solution(int[][] land) {
        result = 0;
        
        for (int i = land.length - 2; i >= 0; i--) {
			
        	for (int j = 0; j < land[i].length; j++) {
				
        		int max = Integer.MIN_VALUE;
        		for (int z = 0; z < land[i].length; z++) {
					if(j==z) continue;
					if(land[i+1][z] > max) max = land[i+1][z];
				}
        		land[i][j] += max;
			}
        	
		}
        
        for (int i = 0; i < land[0].length; i++) {
			if(result < land[0][i]) result = land[0][i];
		}
        
        return result;
    }
	
}
