package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32 {
	static int Answer;
	static int Y, X, N, P;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\com\\data\\Solution32.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // Test case

		// fill up the data
		for (int test_case = 1; test_case <= T; test_case++) {

			Y = sc.nextInt(); // position row
			X = sc.nextInt(); // position col
			N = sc.nextInt(); // ������ ��

		//1. room �Է�
			int[][] room = new int[Y + 1][X + 1];// because start from 1;���̰����迭
			// fill up table
			for (int i = 1; i <= Y; i++) {   // ������ ���� �Է�
				for (int j = 1; j <= X; j++) {
					room[i][j] = sc.nextInt();
				}
			}

		//2. �����ڹ迭 �Է�
			int[][] player = new int[N][3];
			for (int i = 0; i < N; i++) {	//  ������ ��ġ(��,��), ����Ƚ��
				player[i][0] = sc.nextInt(); // coord Y
				player[i][1] = sc.nextInt(); // coord X
				player[i][2] = sc.nextInt(); // steps
			}

		//3. ���� �迭 �Է�
			P =sc.nextInt();//��������
			int[][] trap=new int[P][2];//���� �迭
			for(int i = 0; i < P; i++){
				trap[i][0] = sc.nextInt();//���� X ��ǥ
				trap[i][1] = sc.nextInt();//���� Y ��ǥ
			}

		//4. ������ġ 0���� ����
			Answer=0;
			for(int k = 0; k < P; k++){
				int ti=trap[k][0];
				int tj=trap[k][1];
				room[ti][tj]=0;
			}
	
		//5. ������ �� ��ŭ �ݺ�*****************************************************
			for(int i=0; i<N; i++) {		
				int x = player[i][0];		//������ ������ġ ��
				int y = player[i][1];        //������ ������ġ ��
				int Move = player[i][2];		// �̵�Ƚ��
				int reward =- 1000;
				boolean isout = false;

				for(int m=0; m<Move; m++){		// �̵� Ƚ����ŭ �ݺ�.���ڸ��� ����(�������� ������ 1~4����)�� ���ڸ��� ����ĭ��
					int dir = room[x][y]/10;	// �̵� ����. ���ڸ���
					int cnt = room[x][y]%10;	// �̵� ĭ��. ���ڸ���
				
					//��4, i�� ����
					if(dir==4){//
						if(x - cnt >= 1 && room[x-cnt][y] != 0){// ��踦 ����� �ʾҴٸ� �̵�
							x=x-cnt;

						}else{		//��踦 ����� �ߴ�
							isout=true;
							break;
						}
					}
					//��1, y�� ����
					else if(dir==1){
						if(y + cnt <= X && room[x][y+cnt] != 0){
							y = y + cnt;
						}else{
							isout = true;
							break;
						}
					}
					//��2, x�� ����
					else if(dir==2){
						if(x + cnt <= Y && room[x + cnt][y] != 0){
							x  =x + cnt;
						}else{
							isout = true;
							break;
						}
					}
					//��3, y�� ����
					else if(dir==3){
						if(y-cnt>=1 && room[x][y-cnt] != 0){
							y=y-cnt;
						}else{
							isout=true;
							break;
						}
					}

				}

				if(isout==false)
					reward = reward + room[x][y] * 100;

				Answer= Answer + reward;
			}

			System.out.println("#" + test_case + " " + Answer);
		}

	}
}
