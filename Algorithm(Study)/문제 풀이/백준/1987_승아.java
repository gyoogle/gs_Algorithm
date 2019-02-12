package test;


import java.util.Scanner;

class pair{
	int first;
	int second;
	pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Main1987 {
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	static char[][] arr; 
	static boolean[] checked = new boolean[27];
	static int sum = 0,r,c,rst=Integer.MIN_VALUE;
	
	public static void dfs(int y, int x) {
		checked[arr[y][x]-'A']=true;
		sum++;
		rst = rst < sum? sum:rst;
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || ny>r-1 || nx<0 || nx>c-1 || checked[arr[ny][nx]-'A']== true) continue;
			
			dfs(ny,nx);
			checked[arr[ny][nx]-'A']=false;
			
		}
	
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		arr= new char[r][c];
		
		for(int i=0;i<r;i++) {
			String str = sc.next();
			for(int j=0;j<c;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		dfs(0,0);

		System.out.println(rst);
	} //end of main
}
