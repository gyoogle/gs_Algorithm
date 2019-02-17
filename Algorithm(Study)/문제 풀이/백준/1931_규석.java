package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Seminar { // 회의 시작, 끝 저장할 클래스
	Integer start;
	Integer end;
	
	Seminar(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}
	
	public Integer getStart(){
		return start;
	}
	public Integer getEnd(){
		return end;
	}

	/*
	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
	}
	*/

}

class ArrSort implements Comparator<Seminar>{ // comparator로 끝나는 시간 정렬

	@Override
	public int compare(Seminar s1, Seminar s2) {
		if(s1.getEnd() != s2.getEnd()){
			return s1.getEnd().compareTo(s2.getEnd());
		}
		else
			return s1.getStart().compareTo(s2.getStart());
	}
	
}

public class Problem1931 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Seminar> arr = new ArrayList<Seminar>();
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < num; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Seminar s = new Seminar(start, end);
			
			arr.add(s);
		}
		
		ArrSort arrSort = new ArrSort();
		Collections.sort(arr, arrSort); // 정렬
		
		
		int chkEnd = arr.get(0).end;
		
		int count = 1; // 회의 수 저장 변수(처음 값 저장하고 시작해서 1로 선언)
		
		for (int i = 1; i < arr.size(); i++) {
			
			int e = arr.get(i).end;
			int s = arr.get(i).start;
			
			if(chkEnd <= s){
				chkEnd = e;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
