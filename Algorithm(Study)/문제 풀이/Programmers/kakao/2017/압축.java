import java.util.ArrayList;

class 압축 {
  static final int hash_size = 1000;
	static final int hash_len = 400;
	static final int hash_val = 17;
	static String[][] arr;
	static int[][] n;
	static int[] cnt;
	static int count;
	
	static ArrayList<Integer> list;
	
	public static void init() {
		arr = new String[hash_size][hash_len];
		n = new int[hash_size][hash_len];
		cnt = new int[hash_size];
		list = new ArrayList<>();
		count = 1;
	}
	
	public static int[] solution(String msg) {
		int[] answer = {};
		
		init();
		String alpha = "";
		int key = 0;
		for (int i = 1; i <= 26; i++) {
			alpha = String.valueOf((char)(i+64));
			
			key = getHashKey(alpha);
			
			if(cnt[key] == 0) {
				arr[key][cnt[key]] = alpha;
				n[key][cnt[key]++] = count++;
			}
			else {
				arr[key][cnt[key]] = alpha;
				n[key][cnt[key]++] = count++;
			}
		}
		
		loop : for (int i = 0; i < msg.length(); i++) {
			
			String word = "";
			int idx = i;
			
			while(true) {
				
				if(idx == msg.length()) {
					
					break;
				}
				word += msg.charAt(idx);
				
				int k = getHashKey(word);
				int checkResult = checking(k, word);
				
				if(checkResult == -1) { // 존재하지 않으면
					arr[k][cnt[k]] = word;
					n[k][cnt[k]++] = count++;
					break;
				}
				
				else {
					if(idx+1 == msg.length()) {
						list.add(n[k][checkResult]);
						break loop;
					}
					String tempStr = word+msg.charAt(idx+1);
					int tempInt = getHashKey(tempStr);
					int tempCheck = checking(tempInt, tempStr);
					
					if(tempCheck != -1) {
						idx++;
						continue;
					}
					list.add(n[k][checkResult]);
					i = idx;
					idx++;
				}
			}
			
			
		}
		
		answer = new int[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static int getHashKey(String str) {
		
		int key = 0;
		
		for (int i = 0; i < str.length(); i++) {
			key = (key*hash_val) + str.charAt(i);
		}
		
		if(key<0) key = -key;
		
		return key % hash_size;
		
	}
	
	public static int checking(int key, String str) {
		
		for (int i = 0; i < cnt[key]; i++) {
			if(arr[key][i].equals(str)) {
				return i;
			}
		}
		
		return -1;
		
	}
}
