import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 여행경로 {
	
	static ArrayList<String> list;
	static String[] result;
	static int[][] map;
	static int index = 0;
	
	public static String[] solution(String[][] tickets) {
        
        map = new int[tickets.length+1][tickets.length+1];
        result = new String[tickets.length+1];
        
        HashMap<String, Integer> hm = new HashMap<>();
        list = new ArrayList<>();
        
        for (int i = 0; i < tickets.length; i++) {
        	String start = tickets[i][0];
        	String end = tickets[i][1];
        	
        	if(hm.get(start) == null) {
        		list.add(start);
        		hm.put(start, index++);
        	}
        	if(hm.get(end) == null) {
        		list.add(end);
        		hm.put(end, index++);
        	}
        	
        	int idx1 = hm.get(start);
        	int idx2 = hm.get(end);
        	
        	map[idx1][idx2] += 1;
		}
        
        for (int i = 0; i < tickets.length; i++) {
        	
        	String start = tickets[i][0];
        	String end = tickets[i][1];
        	int idx1 = hm.get(start);
        	int idx2 = hm.get(end);
        	
        	boolean[][] visit = new boolean[tickets.length+1][tickets.length+1];
        	String[] route = new String[tickets.length+1];
        	route[0] = start;
        	route[1] = end;
        	if(map[idx1][idx2] == 1)
        		visit[idx1][idx2] = true;
        	map[idx1][idx2] -= 1;
        	dfs(map, visit, idx2, route, 1);
        	map[idx1][idx2] += 1;
		}
                
        return result;
    }
	
	public static void dfs(int[][] map, boolean[][] visit, int start, String[] route, int len) {
		if(len == map.length-1) {
			if(!route[0].equals("ICN")) {
				return;
			}
			
			if(result[0] == null) { // 처음 들어온 상황
				for (int i = 0; i < route.length; i++) {
					result[i] = route[i];
				}
			}
			else {
				boolean chk = true;
				for (int i = 0; i < route.length; i++) {
					if(result[i].compareTo(route[i]) < 0) break;
					else if(result[i].compareTo(route[i]) > 0) {
						chk = false;
						break;
					}
				}
				if(!chk) {
					for (int i = 0; i < route.length; i++) {
						result[i] = route[i];
					}
				}
			}
			return;
		}
		
		for (int i = 0; i < map[start].length; i++) {
			if(map[start][i] >= 1 && !visit[start][i]) {
				if(map[start][i] == 1)
					visit[start][i] = true;
				route[len] = list.get(start);
				route[len+1] = list.get(i);
				map[start][i] -= 1;
				dfs(map, visit, i, route, len+1);
				route[len+1] = null;
				map[start][i] += 1;
				if(map[start][i] == 1) {
					visit[start][i] = false;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}

}
