package nhn;
import java.io.*;
import java.util.*;

public class Main {
	
	static char[] answer = {'Y', 'N'}; // ���� ����
	static int cardCnt, kinds; // ī�� �� ��, ���� ��
	
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
		
		// ī�� �� ���� ������ ����
		Iterator it = sortByValue(map).iterator();
		
		// ���� ���� ������ ���� ī��
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
		
		if(count >= 2) { // �ʿ��� ī�尡 2�� �̻��̶� �Ұ���
			System.out.println(answer[1]);
			System.out.println(cardCnt);
		}
		else if(count == 1) { // 1�常 �߰��ϸ� ����
			System.out.println(answer[0]);
			System.out.println(cardCnt+1);
		}
		else { // count = 0; ��� ���� ���Ƽ� ����
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
