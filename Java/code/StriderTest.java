package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StriderTest {

	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\com\\data\\Solution21.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//�׽�Ʈ ���̽� ��

		for(int tc=1; tc<=T; tc++){
			int N=sc.nextInt(); //�迭�� ũ�� NxN
			int[][] lake=new int[N][N];//0

			int num =sc.nextInt();//�ұ�����(Strider)��
			
			int[][] strider=new int[num][3];
			for(int b=0; b<num; b++){
				strider[b][0]=sc.nextInt();//����ġ
				strider[b][1]=sc.nextInt();//����ġ
				strider[b][2]=sc.nextInt();//����(1:��,2:��)
			}
			
			int answer = 0;
			int k = 0;
			boolean flag = false;
			
			for(k = 0; k < num && !flag ; k++){//�ұ����� ����ŭ �ݺ�
				int x = strider[k][0];  //���� ��ġ i
				int y = strider[k][1];  //���� ��ġ j
				int dir = strider[k][2]; //����
			
				if(lake[x][y]==1) break;  //�̹� ������ �� �ڸ���� �´� �����
				lake[x][y]=1;  // �� ���� ����
				
				if(dir == 1){//1.��
					for(int a = 3; a >= 1; a--){
						x = x + a;
						if(x < N){//in lake
							if(lake[x][y] == 1) {
								flag = true;
								break;  //�̹� ������ �� �ڸ����
							}
							lake[x][y]=1;
						}else{//out lake
							break;
						}
					}						
				}else{//2.��
					for(int a=3; a>=1; a--){
						y=y+a;
						if(y<N){//
							if(lake[x][y]==1) {
								flag = true;
								break;  //�̹� ������ �� �ڸ����
							}else 
								lake[x][y]=1;								
						}else{
							break;
						}
					}
				}							
			}//for strider
			
			if(k < num) //�� �ڸ��� ���ļ� �߰��� ���� ���, �ƴϸ� k�� num�� ����
				answer = k;
			
			System.out.println("#"+tc+" "+answer);
		}//test case
	}//main
}//class









