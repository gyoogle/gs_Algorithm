import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

	public static String[] solution(String[] record) {

		String[] answer = new String[101];
		int idx = 0;

		// 임시보관함
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {

			String[] records = record[i].split(" ");

			switch (records[0]) {
			case "RECEIVE":
				list.add(records[1]);
				break;
			case "DELETE":
				if(list.size() == 0) continue;
				list.remove(list.size() - 1);
				break;
			case "SAVE":
				if(list.size() == 0) continue;
				for (int j = 0; j < list.size(); j++) {
					answer[idx++] = list.get(j);
				}
				list.clear();
				break;
			default:
				break;
			}
		}
		
		String[] result = new String[idx];
		
		for (int j = 0; j < result.length; j++) {
			result[j] = answer[j];
		}

		return result;

	}

	public static void main(String[] args) throws Exception {

		
		String[] str = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE"};
		
		System.out.println(Arrays.toString(solution(str)));

	}

}
