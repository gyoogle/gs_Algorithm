package nhn;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main3 {
	
	static int[] Friend; // 사탕 개수 저장
	static ArrayList<Integer>[] follow; // 팔로우 저장
	static boolean[] possibleAdd; // 팔로워 사탕 획득 여부
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = str2int(br.readLine());
		
		Friend = new int[N];
		follow = new ArrayList[N];
		
		for (int i = 0; i < follow.length; i++) {
			follow[i] = new ArrayList<>(); // 초기화
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int start = 0;
		while(st.hasMoreTokens()) {
			
			possibleAdd = new boolean[N];
			
			switch (st.nextToken()) {
			case "A": // 뽑은 플레이어 획득
				Friend[start]++;
				addFollow(start);
				break;
			case "J": // 카드를 뽑은 양옆 플레이어가 획득
				if(start == 0) {
					Friend[N-1]++;
					Friend[start+1]++;
					addFollow(N-1);
					addFollow(start+1);
				}
				else if(start == N-1) {
					Friend[start-1]++;
					Friend[0]++;
					addFollow(start-1);
					addFollow(0);
				}
				else {
					Friend[start-1]++;
					Friend[start+1]++;
					addFollow(start-1);
					addFollow(start+1);
				}
				break;
			case "Q": // 모든 플레이어가 획득
				for (int i = 0; i < N; i++) {
					Friend[i]++;
				}
				break;
			case "K": // 팔로워 지정
				int follower = str2int(st.nextToken());
				follow[start].add(follower);
				
				break;
			default:
				break;
			}
			
			start++; // 다음 사람 진행
			if(start == N) {
				start = 0;
			}
		}
		
		for (int i = 0; i < Friend.length; i++) {
			System.out.print(Friend[i] + " ");
		}
	}
	
	public static void addFollow(int start) {
		
		for (int i = 0; i < follow[start].size(); i++) {
			int followFriend = follow[start].get(i);
			if(!possibleAdd[followFriend]) {
				possibleAdd[followFriend] = true;
				Friend[followFriend]++;
				addFollow(followFriend);
			}
		}
	}
	
	public static int str2int(String str) {
		return Integer.parseInt(str);
	}
}
