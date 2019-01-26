package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\com\\data\\Solution22.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수

		for(int tc=1; tc<=T; tc++){
			int N=sc.nextInt(); //배열의 크기 NxN
			int[][] lake=new int[N][N];//0

			int num =sc.nextInt();//소금쟁이(Strider)수
			
			int strNum = num;
			
			int[][] strider=new int[num][3];
			for(int b=0; b<num; b++){
				strider[b][0]=sc.nextInt();//행위치
				strider[b][1]=sc.nextInt();//열위치
				strider[b][2]=sc.nextInt();//방향(1:상,2:하,3:좌,4:우)
			}
			
			int answer = 0;
			int k = 0;
			boolean flag = false;
			
			for(k = 0; k < num && !flag ; k++){//소금쟁이 수만큼 반복
				int x = strider[k][0];  //시작 위치 i
				int y = strider[k][1];  //시작 위치 j
				int dir = strider[k][2]; //방향
			
				if(lake[x][y]==1) { 
					strNum--;
					break;  //이미 누군가 뛴 자리라면 걔는 멈춰야
				}
				lake[x][y]=1;  // 뛴 흔적 저장
				
				if(dir == 1){//1.상
					for(int a = 3; a >= 1; a--){
						x = x - a;
						if(x >= 0){//in lake
							if(lake[x][y] == 1) {
								flag = true;
								strNum--;
								break;  //이미 누군가 뛴 자리라면
							}
							lake[x][y]=1;
						}else{//out lake
							strNum--;
							break;
						}
					}						
				}
				else if(dir == 2){//2.하
					for(int a = 3; a >= 1; a--){
						x = x + a;
						if(x < N){//in lake
							if(lake[x][y] == 1) {
								flag = true;
								strNum--;
								break;  //이미 누군가 뛴 자리라면
							}
							lake[x][y]=1;
						}else{//out lake
							strNum--;
							break;
						}
					}						
				}
				else if(dir == 3){//3.좌
					for(int a = 3; a >= 1; a--){
						y= y-a;
						if(y >= 0){//in lake
							if(lake[x][y] == 1) {
								flag = true;
								strNum--;
								break;  //이미 누군가 뛴 자리라면
							}
							lake[x][y]=1;
						}else{//out lake
							strNum--;
							break;
						}
					}						
				}
				else if (dir == 4){//4.우
					for(int a=3; a>=1; a--){
						y=y+a;
						if(y<N){//
							if(lake[x][y]==1) {
								flag = true;
								strNum--;
								break;  //이미 누군가 뛴 자리라면
							}else 
								lake[x][y]=1;								
						}else{
							strNum--;
							break;
						}
					}
				}							
			}//for strider
			
			if(k < num) //뛴 자리가 겹쳐서 중간에 멈춘 경우, 아니면 k는 num과 같음
				answer = strNum-1;
			else
				answer = strNum;
			
			System.out.println("#"+tc+" "+answer);
		}//test case
	}//main

}
