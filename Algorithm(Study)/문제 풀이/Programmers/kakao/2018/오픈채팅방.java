import java.util.Arrays;

public class 오픈채팅방 {

	public static final int hash_size = 1000;
	public static final int hash_leng = 400;
	public static final int hash_val = 17;
	
	public static String[][] arr = new String[hash_size][hash_leng];
	public static String[][] name = new String[hash_size][hash_leng];
	public static int[] cnt = new int[hash_size];
	public static StringBuilder sb;
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        int idx = 0; int count = 0;
        
        String[][] list = new String[record.length][3];
        
        for (int i = 0; i < record.length; i++) {
        	list[i] = record[i].split(" ");
        	if(list[i][0].equals("Leave")) {
        		count++;
        		continue;
        	}
        	if(list[i][0].equals("Enter")) {
        		count++;
        	}
        	
        	int value = getHashKey(list[i][1]);
        	
        	if(cnt[value] == 0) {
        		arr[value][cnt[value]] = list[i][1];
        		name[value][cnt[value]] = list[i][2];
        		cnt[value] += 1;
        	}
        	else {
        		boolean chk = true;
        		for (int j = 0; j < cnt[value]; j++) {
					if(list[i][1].equals(arr[value][j])) {
						name[value][j] = list[i][2];
						chk = false;
						break;
					}
				}
        		if(chk) {
        			arr[value][cnt[value]] = list[i][1];
            		name[value][cnt[value]] = list[i][2];
            		cnt[value] += 1;
        		}
        	}
        	
		}
        
        answer = new String[count];
        
        for (int i = 0; i < record.length; i++) {
        	
        	String username = "";
        	
        	int value = getHashKey(list[i][1]);
        	if(cnt[value] == 1) {
        		username = name[value][0];
        	}
        	else {
        		for (int j = 0; j < cnt[value]; j++) {
					if(list[i][1].equals(arr[value][j])) {
						username = name[value][j];
						break;
					}
				}
        	}
        	
        	sb = new StringBuilder();
        	
        	switch (list[i][0]) {
			case "Enter":
				answer[idx++] = sb.append(username).append("님이 들어왔습니다.").toString();
				break;
			case "Leave":
				answer[idx++] = sb.append(username).append("님이 나갔습니다.").toString();
				break;
			default:
				break;
			}
        	
        }
        
        
        return answer;
    }
	
	public static int getHashKey(String id) {
		
		int val = 0;
		
		for (int i = 0; i < id.length(); i++) {
			val += (val*hash_val) + id.charAt(i);
		}
		
		if(val < 0) val = -val;
		
		return val % hash_size;
	}
	
	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};
		
		System.out.println(Arrays.toString(solution(record)));
	}

}
