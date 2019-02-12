package com.ssafy.algo;

public class DR_CountSort {

	public static void main(String[] args) {
		int[] data = {0, 4, 1, 3, 1, 2, 4, 1};
		
		int[] counts = new int[5];
		
		for (int i = 0; i < data.length; i++) {
			counts[data[i]]++;
		}
		
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		int[] temp = new int[data.length+1];
		
		for (int j = data.length - 1; j >= 0; j--) {
			temp[counts[data[j]]] = data[j];
			
			if(counts[data[j]] != 0) {
				counts[data[j]]--;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		
	}

}
