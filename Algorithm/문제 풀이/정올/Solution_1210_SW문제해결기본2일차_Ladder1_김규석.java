package com.ssafy.algo;

import java.util.Scanner;

public class Solution_1210_SW�����ذ�⺻2����_Ladder1_��Լ� {
	
	static int[][] data = new int[100][102];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int ts = sc.nextInt();
			
			for (int x = 0; x < data.length; x++) {
				for (int y = 1; y < data[x].length - 1; y++) {
					data[x][y] = sc.nextInt();
				}
			}
			
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length; y++) {
					if(data[x][y] == 2) {
						
						int flag = 0; // ����
						int i = x, j = y;
						
						while(true) {
							switch (flag) {
							case 0:	// ��
								if(data[i-1][j] == 1) {
									i--;
									
									if(data[i][j-1] == 1) {
										j--;
										flag = 1;
										break;
									}
									else if(data[i][j+1] == 1) {
										j++;
										flag = 2;
										break;
									}
								}
								
								break;
							case 1: // ��
								if(data[i][j-1] == 1) {
									j--;
								}
								else {
									flag = 0;
								}
								break;
							case 2: // ��
								if(data[i][j+1] == 1) {
									j++;
								}
								else {
									flag = 0;
								}
								break;
							}
							if ( i == 0 ) break; // ����
						}
						System.out.println();
						System.out.print("#" + t + " " + (j-1));
					}
				}
			}
			
				
		}	
	}
}
