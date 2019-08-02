package CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BetaRound4_SolutionC {
	
	static class Regist {
		
		public String name;
		public int idx;
		
		Regist(String name) {
			this.name = name;
			this.idx = 0;
		}
		
		public void addIndex() {
			this.idx++;
		}
 
		public String getName() {
			return name;
		}
 
		public void setName(String name) {
			this.name = name;
		}
 
		public int getIdx() {
			return idx;
		}
 
		public void setIdx(int idx) {
			this.idx = idx;
		}
		
	}
 
	static int N;
	static ArrayList<Regist>[] data = new ArrayList[1000];
	static String number;
	static int key;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			key = HashKey(str); // hash로 key 값을 얻어옴
			
			if(data[key] == null){ // 해당 data 공간이 비어있으면 새로 추가
				data[key] = new ArrayList<>();
				data[key].add(new Regist(str));
				System.out.println("OK");
			}
			else { // 아니면 해당 data 배열에서 같은 이름 찾기
				boolean chk = false;
				for (int j = 0; j < data[key].size(); j++) {
					if(str.equals(data[key].get(j).name)) {
						data[key].get(j).addIndex(); // 해당 값 인덱스 1 증가
						System.out.println(str + data[key].get(j).getIdx()); // 출력
						chk = true;
						break;
					}
				}
				
				if(!chk){
					data[key].add(new Regist(str));
					System.out.println("OK");
				}
			}
		}
	}
	
	public static int HashKey(String str) {
		
		int key = 0;
		
		for (int i = 0; i < str.length(); i++) {
			key = key * 23 + str.charAt(i);
		}
		
		if(key < 0) key = -key; // 만약 음수면 양수로 만들어주기
		
		return key % 1000; // 해시 사이즈를 나눈다.
	}
 
}