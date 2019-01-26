package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution13 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\com\\data\\Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		
		
		for(int i = 0; i < ts; i++) {
			
			int count = 0;
			int size = sc.nextInt();
			boolean chk = true;
			
			int[] cnt = new int[ts];
			int[] cnt2 = new int[ts];
			
			char [][] place = new char [size][size];
			
			
			for(int x = 0; x < place.length; x++) {
				for(int y = 0; y < place[x].length; y++) {
					place[x][y] = sc.next().charAt(0);
				}
			}
			
			char check[][] = new char[size+2][size+2];
			
			for(int x = 1; x < check.length-1; x++) {
				for(int y = 1; y < check[x].length-1; y++) {
					check[x][y] = place[x-1][y-1];
				}
			}
			
			for(int x = 1; x < check.length-1; x++) {
				for(int y = 1; y < check.length-1; y++) {
					
					chk = true;
					
					count = 0;
					
					if (check[x][y] == 'B') {
						
						for(int a = x-1; a <x+2; a++) {
							for(int b = y-1; b<y+2; b++) {
								
								if(check[a][b] == 'G') {
									//System.out.println(x + ", " + y + "에서 (" + a + ", " + b + ")에 걸림");
									count = 2;
									cnt[i] = count;
									chk = false;
								}
							}
						}
						
						if(chk == true) {
							for(int a = 0; a < check[x].length; a++) {
								if (check[x][a] == 'B') count++;
							}
							for(int a = 0; a < check[x].length; a++) {
								if (check[a][y] == 'B') count++;
							}
							count-=1;
							
							if(cnt2[i] <= count) // 더 큰거 저장
								cnt2[i] = count;
						}
						
						if(cnt2[i] > cnt[i])
							cnt[i] = cnt2[i];
						
					}
					else continue;
				}
			}
			System.out.println("#" + (int)(i+1) + " " + cnt[i]);
		}
		
	}

}
