package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_후위순회_김규석 {	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // 정점 개수
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		char[] arr = new char[16]; // 레벨 3 : 2^(3+1) = 16
		
		
		arr[1] = 'A'; // 루트 정점 번호를 저장
		
		while(st.hasMoreTokens()) {
			char start = st.nextToken().charAt(0); // 간선의 시작 정점
			char end = st.nextToken().charAt(0); // 간선의 끝 정점
			
			for (int i = 1; i < arr.length; i++) { // 0번 정점은 안씀, start가 저장된 배열의 위치 찾기
				if(start == arr[i]) {
					//자식 정점 저장, 왼쪽 자식이 없으면 왼쪽 저장, 있으면 오른쪽에 저장
					if (arr[i*2] == 0) { // 왼쪽자식이 없음
						arr[i*2] = end; // 왼쪽자식에 저장
					} else {
						arr[i*2 + 1] = end; // 오른쪽자식에 저장
					}
					break;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if ( i == 1 || i == 2 || i == 4 || i == 8 || i == 16) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		
		//System.out.println("\n전위순회 : ");
		//preOrder(arr, 1); // 배열, 순회를 시작할 정점(루트노트)
		//System.out.println("\n중위순회 : ");
		//inOrder(arr, 1);
		System.out.println("\n후위순회 : ");
		postOrder(arr, 1);
	}
	
	public static void postOrder(char[] arr, int index) {
		// 왼쪽 자식
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			postOrder(arr, index*2);
		}
		// 오른쪽 자식
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			postOrder(arr, index*2 + 1);
		}
		
		System.out.print(arr[index] + " "); // 부모 (나)
		
	}
	
	public static void inOrder(char[] arr, int index) {
		// 왼쪽 자식
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			inOrder(arr, index*2);
		}
		
		System.out.print(arr[index] + " "); // 부모 (나)
		
		// 오른쪽 자식
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			inOrder(arr, index*2 + 1);
		}
	}
	
	public static void preOrder(char[] arr, int index) {
		System.out.print(arr[index] + " "); // 부모 (나)
		// 왼쪽 자식
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			preOrder(arr, index*2);
		}
		// 오른쪽 자식
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			preOrder(arr, index*2 + 1);
		}
	}

}
