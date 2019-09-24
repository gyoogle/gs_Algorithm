class 가장큰정사각형찾기
{
    static int[] dy = {-1,-1, 0};
	static int[] dx = {-1, 0, -1};
	static int[][] dp;
	public static int solution(int [][]board)
    {
		dp = new int[board.length][board[0].length];
		int max = Integer.MIN_VALUE;
		
		if(board.length <= 1 || board[0].length <= 1) {
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if(board[i][j] == 1) {
						if(max < board[i][j]) max = board[i][j];
					}
				}
			}
			
		}
		
		else {
	        for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board[i].length; j++) {
					
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < dy.length; k++) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(board[ny][nx] < min) min = board[ny][nx];
					}
					if(board[i][j] == 1)
						board[i][j] = min+1;
					if(max < board[i][j]) max = board[i][j];
				}
			}
		}
        
        return max * max;
    }
}
