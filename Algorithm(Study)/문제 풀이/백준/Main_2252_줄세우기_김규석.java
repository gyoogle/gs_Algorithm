import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2252_줄세우기_김규석 {
	
	static int N, M;
	
	static ArrayList<Integer>[] list;
	
	static boolean[] visit;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			if(list[first] == null)
				list[first] = new ArrayList<>();
			
			list[first].add(second);
		}
		
		stack = new Stack<>();
		
		
		for (int i = 1; i < N+1; i++) {
			if(list[i] != null && !visit[i]) {
				dfs(i);
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!visit[i]) {
				System.out.print(i + " ");
			}
		}
		
		while(!stack.isEmpty()){
			int s = stack.pop();
			
			System.out.print(s + " ");
		}
		
	}
	
	public static void dfs(int k) {
		visit[k] = true;
		
		if(list[k] == null) {
			stack.push(k);
			return;
		}
		
		for (int i = 0; i < list[k].size(); i++) {
			
			int next = list[k].get(i);
			if(!visit[next]) {
				dfs(next);
			}
		}
		
		stack.push(k);
	}

}
