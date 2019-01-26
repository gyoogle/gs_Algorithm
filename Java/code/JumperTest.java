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

			int N = sc.nextInt();//�迭 ���� n*n

			int[][] map = new int[N+1][N+1];			

			int startX = sc.nextInt(); //������� i��ǥ
			int startY = sc.nextInt(); //������� j��ǥ
			int jumpers = sc.nextInt();//jumper ���� 

			for(int k=0; k < jumpers; k++) {// ���� ������ŭ ��ǥ�� �Է�
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = -1;
			} 

			dir = sc.nextInt();//  �̵����� ����
			int dx[] = new int[dir];  //x �̵� ���� ����
			int dy[] = new int[dir];  // y �̵� ���� ����
			int[][] dirs = new int[dir][2];
 

			for(int k=0; k < dir; k++) {  //����, �̵�ĭ�� save
				dirs[k][0] = sc.nextInt();//����
				dirs[k][1] = sc.nextInt();//�̵�ĭ��
			} 

			boolean isout = false;			

			for(int k = 0; k < dir && !isout; k++) { // �̵� ���� �� ��ŭ �ݺ�
				int x = dirs[k][0];  //����
				int y = dirs[k][1];  //�̵�ĭ�� 

				//��  1
				if(x == 1){//x���� ����
					for(int d = 1; d <= y; d++){//�̵�ĭ����ŭ �ݺ�
						int nx = startX-1;
						if( nx >= 1 && map[nx][startY] !=-1){// ���� �̵�ĭ�� �������̰�  ���۰� �ƴϸ�
							startX--;
						}else{	// �׷��� ������ �̵�
							isout = true;
							break;
						}
					}
				}//��  2
				else if(x==2){//y�� ����
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

				//��  3
				else if(x==3){//x�� ����
					for(int d=1; d<=y; d++){
						int nx = startX + 1;
						if( nx <= N && map[nx][startY]!=-1){
							startX++;
						}else{
							isout=true;
							break;
						}
					}
				}//��  4
				else if(x==4){//y���� ����
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