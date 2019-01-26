package com.ssafy.algo;

import java.util.Arrays;

public class ArrayPractice {

		public static int[] list={34,23,64,25,12,75,22,88,53,37};
		public static void print(){
			for(int i = 0; i < list.length; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		} 
		
		public static void total(){
			int sum = 0;
			for(int i = 0; i < list.length; i++) {
				sum += list[i];
			}
			System.out.println("배열의 합 : " + sum);
		} 
		
		public static void average(){
			int sum = 0;
			for(int i = 0; i < list.length; i++) {
				sum += list[i];
			}
			
			double average = sum / list.length;
			System.out.println("배열의 평균 : " + average);
		} 
		public static void minimum(){
			int minimum = list[0];
			for(int i = 0; i < list.length; i++) {
				if(minimum >= list[i]) minimum = list[i];
			}
			System.out.println("배열의 최소값 : " + minimum);
		} 
		public static void selectionSort(){
			Arrays.sort(list);
		} 
		
		
		public static void main(String[] args) { 
			print(); 
			total(); 
			average(); 
			minimum(); 
			System.out.println("=== selection sort (Ascending Order)==="); 
			selectionSort(); 
			print(); 
		}
		
}
