package nhn;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = str2int(br.readLine());
		int[] count = new int[101];

		LinkedList<Pair> FQ = new LinkedList<>();

		int idx = 0;
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken(); // 명령어
			
			if (command.equals("enqueue")) { // enqueue 일 때, x도 받기
				int x = str2int(st.nextToken());
				count[x]++;
				if (FQ.isEmpty() || count[x] == 1) { // 큐가 비어있거나, 해당 수의 개수가 1이라면 그냥 삽입
					FQ.add(new Pair(idx++, x, count[x]));
				} else {
					// count 갱신
					for (int j = 0; j < FQ.size(); j++) {
						if (FQ.get(j).x == x) {
							FQ.get(j).frequency++;
						}
					}
					FQ.add(new Pair(idx++, x, count[x]));
				}
			} else { // dequeue일 때,
				if (FQ.isEmpty()) {
					sb.append(-1).append(" ");
					continue;
				}
				Collections.sort(FQ);
				Pair pair = FQ.getFirst();
				count[pair.x]--;
				FQ.removeFirst();
				for (int j = 0; j < FQ.size(); j++) {
					if (FQ.get(j).x == pair.x) {
						FQ.get(j).frequency--;
					}
				}
				sb.append(pair.x).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void print(LinkedList<Pair> fq) {
		System.out.println("\nidx  |  X  |  fre ");
		for (int i = 0; i < fq.size(); i++) {
			System.out.println(fq.get(i).idx + ",      " + fq.get(i).x + ",     " + fq.get(i).frequency);
		}
		System.out.println("--------------------------------");
	}

	public static class Pair implements Comparable<Pair> {
		int idx; // 들어온 순서
		int x; // 해당 수
		int frequency; // 빈도수

		public Pair(int idx, int x, int frequency) {
			this.idx = idx;
			this.x = x;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Pair o) {
			int sub = o.frequency - this.frequency;
			if (sub == 0) {
				sub = this.idx - o.idx;
			}
			return sub;
		}
	}

	public static int str2int(String str) {
		return Integer.parseInt(str);
	}
}
