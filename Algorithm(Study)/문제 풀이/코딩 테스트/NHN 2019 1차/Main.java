package nhn;
import java.io.*;
import java.util.*;

public class Main {
	
	static char[] answer = {'Y', 'N'}; // 가능 여부
	static int cardCnt, kinds; // 카드 총 수, 종류 수
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = str2int(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			String card = st.nextToken();
			if (map.get(card) == null)
				map.put(card, 1);
			else
				map.put(card, map.get(card) + 1);
		}
		
		cardCnt = 0;
		
		// 카드 수 많은 순으로 정렬
		Iterator it = sortByValue(map).iterator();
		
		// 가장 많이 보유한 곤충 카드
		String maxStr = (String)it.next();
		int maxCnt = map.get(maxStr);
		cardCnt += maxCnt;
		
		int count = 0;
		while(it.hasNext()) {
			String temp = (String)it.next();
			if(map.get(temp) < maxCnt) count++;
			cardCnt+=map.get(temp);
		}
		
		kinds = map.size();
		
		if(count >= 2) { // 필요한 카드가 2장 이상이라 불가능
			System.out.println(answer[1]);
			System.out.println(cardCnt);
		}
		else if(count == 1) { // 1장만 추가하면 가능
			System.out.println(answer[0]);
			System.out.println(cardCnt+1);
		}
		else { // count = 0; 모두 갯수 같아서 가능
			System.out.println(answer[0]);
			System.out.println(cardCnt);
		}
		
		System.out.println(kinds);
	}

	public static int str2int(String str) {
		return Integer.parseInt(str);
	}

	public static List sortByValue(final Map map) {

		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		
		return list;
	}

}
