package com.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int num = Integer.parseInt(st.nextToken()); // Âü°¡ÀÚ ¼ö
		int a = Integer.parseInt(st.nextToken()); // ±èÁö¹Î
		int b = Integer.parseInt(st.nextToken()); // ÀÓÇÑ¼ö
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			if(i == a-1 || i == b-1) arr.add(1);
			else arr.add(0);
		}
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;
		boolean flag = true;
		
		while(arr.size() != 1) {
			
			cnt++;
			for (int i = 0; i < arr.size(); i+=2) {
				
				if(arr.size()%2==1 && i==arr.size()-1) { // È¦¼öÀÏ ¶§
					q.add((arr.get(i)));
					continue;
				}
				
				q.add((arr.get(i) | arr.get(i+1)));
				
				if(arr.get(i) == 1 && arr.get(i+1) == 1) {
					flag = false;
					break;
				}
			}
			
			if(!flag) break;
			
			int size = q.size();
			
			arr.clear();
			for (int i = 0; i < size; i++) {
				arr.add(q.poll());
			}
		}
		System.out.println(cnt);
	}

}
