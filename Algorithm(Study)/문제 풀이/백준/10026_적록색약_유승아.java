import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static char[][] x_map;
	static int N;

	static int rst=0;
	static int x_rst=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		map = new char[N][N];
		x_map = new char[N][N];

		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<N;j++) {
				char c = str.charAt(j);
				map[i][j] = c;
				if(c=='G') {
					x_map[i][j]='R';
				} else {
					x_map[i][j]=c;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!='0') {
					dfs(map,i,j);
					rst++;
				}
				if(x_map[i][j]!='0') {
					dfs(x_map,i,j);
					x_rst++;
				}
			}
		}
		
		System.out.println(rst+" "+x_rst);
	}

	static int[] dy= {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	public static void dfs(char[][] mmap, int y, int x) {
		
		char now = mmap[y][x];
		//visited[y][x]= true;
		mmap[y][x] = '0';
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 ||ny >N-1 || nx<0 || nx>N-1 ) continue;
			
			char next = mmap[ny][nx];
			
			if(now == next) dfs(mmap,ny,nx);
		}
	}
}
