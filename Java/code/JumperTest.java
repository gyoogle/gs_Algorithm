package com.ssafy.algo;


import java.io.FileInputStream;
import java.util.Scanner;

public class JumperTest {
	static int N, startX, startY, jumpers, dir;
	static int Ai, Aj; 

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("src\\com\\data\\Solution42.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//tc		

		for(int tc = 1; tc <= T; tc++){

			int N = sc.nextInt();//배열 차수 n*n

			int[][] map = new int[N+1][N+1];			

			int startX = sc.nextInt(); //출발점의 i좌표
			int startY = sc.nextInt(); //출발점의 j좌표
			int jumpers = sc.nextInt();//jumper 갯수 

			for(int k=0; k < jumpers; k++) {// 점퍼 갯수만큼 좌표를 입력
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = -1;
			} 

			dir = sc.nextInt();//  이동지시 갯수
			int dx[] = new int[dir];  //x 이동 방향 모음
			int dy[] = new int[dir];  // y 이동 방향 모음
			int[][] dirs = new int[dir][2];
 

			for(int k=0; k < dir; k++) {  //방향, 이동칸수 save
				dirs[k][0] = sc.nextInt();//방향
				dirs[k][1] = sc.nextInt();//이동칸수
			} 

			boolean isout = false;			

			for(int k = 0; k < dir && !isout; k++) { // 이동 지시 수 만큼 반복
				int x = dirs[k][0];  //방향
				int y = dirs[k][1];  //이동칸수 

				//상  1
				if(x == 1){//x값이 감소
					for(int d = 1; d <= y; d++){//이동칸수만큼 반복
						int nx = startX-1;
						if( nx >= 1 && map[nx][startY] !=-1){// 다음 이동칸이 경계안쪽이고  점퍼가 아니면
							startX--;
						}else{	// 그렇지 않으면 이동
							isout = true;
							break;
						}
					}
				}//우  2
				else if(x==2){//y값 증가
					for(int d=1; d<=y; d++){
						int ny = startY + 1;
						if(ny <= N && map[startX][ny]!=-1){
							startY++;
						}else{
							isout=true;
							break;
						}
					}
				}

				//하  3
				else if(x==3){//x값 증가
					for(int d=1; d<=y; d++){
						int nx = startX + 1;
						if( nx <= N && map[nx][startY]!=-1){
							startX++;
						}else{
							isout=true;
							break;
						}
					}
				}//좌  4
				else if(x==4){//y값이 감소
					for(int d=1; d<=y; d++){
						int ny = startY - 1;
						if(ny >= 1 && map[startX][ny]!=-1){
							startY--;
						}else{
							isout=true;
							break;
						}
					}
				}
			}			

			if(isout == true){
				startX = 0;
				startY = 0;
			}			

			Ai = startX;
			Aj = startY; 

			System.out.println("#"+tc+" "+Ai+" "+Aj);
		}
	}
}