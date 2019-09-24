import java.util.ArrayList;

class 섬연결하기 {
    static class Info {
		
		int target;
		int value;
		
		Info(int target, int value) {
			this.target = target;
			this.value = value;
		}
		
	}
	
	static ArrayList<Info>[] list; // 이동 경로 저장할 리스트
	static boolean[] visited; // 방문 여부 확인
	static int[] direction; // 점마다 저장된 최소 경로 값
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        list = new ArrayList[n];
        visited = new boolean[n];
        direction = new int[n];
        
        // 초기화 과정
        for (int i = 0; i < n; i++) {
        	list[i] = new ArrayList<>();
        	direction[i] = Integer.MAX_VALUE;
		}
        
        for (int i = 0; i < costs.length; i++) {
        	list[costs[i][0]].add(new Info(costs[i][1], costs[i][2]));
        	list[costs[i][1]].add(new Info(costs[i][0], costs[i][2]));
		}
        
        int start = 0;
        direction[start] = 0;
        visited[start] = true;
        
        while(true) {
        	
        	for (int i = 0; i < list[start].size(); i++) {
				int target = list[start].get(i).target;
				int value = list[start].get(i).value;
				
				if(!visited[target]) {
					if(direction[target] > value) direction[target] = value;
				}
			}
        	
        	boolean chk = true;
        	int min = Integer.MAX_VALUE;
        	for (int i = 0; i < direction.length; i++) {
				
        		if(visited[i] || direction[i] == Integer.MAX_VALUE) continue;
        		
        		if(min > direction[i]) {
        			min = direction[i];
        			start = i;
        			chk = false;
        		}
        		
			}
        	
        	if(chk) break;
        	
        	visited[start] = true;
        	answer += min;
        	
        }
        
        return answer;
    }
}
