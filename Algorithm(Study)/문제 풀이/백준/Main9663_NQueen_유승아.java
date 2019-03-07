import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ :: 9663 N-Queen
//2019-03-05
public class Main9663_NQueen_유승아 {
	static int[][] map;
	static int n,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		ans=0;
		map= new int[n][n];
		
		for(int j=0;j<n;j++) {
	
			solve(0,j,1);
			
			map[0][j]--; //visited
			//System.out.println("Q("+y+","+x+")");
			
			for(int i=0;i<8;i++) {
				int ny=0,nx=j;
				while(true) {
					ny +=dy[i];
					nx +=dx[i];
					
					if(ny<0|| ny>n-1 || nx<0 || nx>n-1  ) break;
					map[ny][nx]--;
				}
			}
			
			//System.out.println();
		}
		System.out.println(ans);
	}
	static int[] dx = {-1,0,1,0,1,-1,1,-1};
	static int[] dy = {0,1,0,-1,-1,-1,1,1};
	
	public static void solve(int y,int x,int q){
		
	
		
		map[y][x]++; //visited
		//System.out.println("Q("+y+","+x+")");
		
		for(int i=0;i<8;i++) {
			int ny=y,nx=x;
			while(true) {
				ny +=dy[i];
				nx +=dx[i];
				
				if(ny<0|| ny>n-1 || nx<0 || nx>n-1  ) break;
				map[ny][nx]++;
			}
		}
		
		if(q==n) {//종료조건 
			ans++;
			return; 
		}
		
		
		for(int k=0;k<n;k++) {
			if(map[y+1][k] > 0) continue; //방문한 곳은 continue;
			
			solve(y+1,k,q+1);
			
			map[y+1][k]--;
			
			for(int i=0;i<8;i++) {
				int ny=y+1,nx=k;
				while(true) {
					ny +=dy[i];
					nx +=dx[i];
					
					if(ny<0|| ny>n-1 || nx<0 || nx>n-1  ) break;
					map[ny][nx]--;
				}
			}
			//System.out.println();
			
		}
		
		
	}
}
