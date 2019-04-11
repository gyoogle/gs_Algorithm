import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_김규석 {

	static class Fish { // 상어, 물고기 저장할 class 선언
		int y;
		int x;

		Fish(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Dir { // 상어부터 물고기들 간의 거리를 저장할 class 선언
		int y;
		int x;
		int val;

		Dir(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}

	static int N;
	static int[][] map;
	static int[][] copy;
	
	static Fish shark; // 상어는 한마리
	static ArrayList<Fish> fish; // 나머지 물고기들

	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int result;
	static int sharkSize;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fish = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) // 9면 상어 위치
					shark = new Fish(i, j);
				if (map[i][j] != 0 && map[i][j] != 9) // 0과 9가 아니면 물고기 위치
					fish.add(new Fish(i, j));
			}
		}
		result = 0;
		
		sol(shark.y, shark.x);
		
		System.out.println(result);

	}
	
	public static void sol(int y, int x) {
		
		int sharkY = y; // 상어의 첫 위치 y,x 저장
		int sharkX = x;
		
		sharkSize = 2; // 상어의 처음 크기는 2
		int count = 0; // 물고기를 먹을 때마다 증가시킬 변수
		
		while(true) {
			
			copy = new int[N][N];
			visit = new boolean[N][N];
			
			checking(sharkY, sharkX, copy); // 현재 상어 위치에서 물고기까지 가는데 걸리는 거리 함수
			
			// 먹을 수 있는 물고기 중 최소 이동거리 저장
			int minDir = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 0보다 크고 상어 크기보다 작으며, 거리가 0보다 큰 곳 (copy[i][j] > 0 : 거리에 대한 조건을 주지 않으면 테스트케이스는 모두 맞지만 반례가 존재하는 문제)
					if(map[i][j] < sharkSize && map[i][j] > 0 && copy[i][j] > 0) {
						if(minDir > copy[i][j]) minDir = copy[i][j];
					}
				}
			}
			
			ArrayList<Fish> list = new ArrayList<>(); // 먹을 수 있는 물고기 체크
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 0보다 크고 상어 크기보다 작으며, 거리가 최소와 같은 곳
					if(map[i][j] < sharkSize && map[i][j] > 0 && copy[i][j] == minDir)
						list.add(new Fish(i,j));
				}
			}
			
			if(list.size() == 0) { // 더 이상 먹을 물고기가 없다면 끝
				break;
			}
			else if(list.size() == 1) { // 먹을 수 있는 물고기가 1마리 -> 그 물고기를 먹으면 됨
				
				int fy = list.get(0).y;
				int fx = list.get(0).x;
				
				result += copy[fy][fx]; // 이동거리 더하기
				map[fy][fx] = 0; // 먹은 자리 값 0으로 만들기
				count++; // 먹은 카운트 수 증가
				
				if(count == sharkSize) { // 먹은 물고기 수가 상어 크기랑 같아지면 크기 1 증가
					sharkSize++;
					count = 0; // 크기 증가되면 다시 카운트 0으로 초기화
				}
				
				map[sharkY][sharkX] = 0; // 원래 상어자리 0으로 만들기
				sharkY = fy; // 상어 위치 갱신
				sharkX = fx;
				continue;
				
			} 
			else { // 2마리 이상
				
				int minY = Integer.MAX_VALUE;
				
				// 먹을 수 있는 물고기 중 가장 위에 있는 y인덱스 찾기
				for (int i = 0; i < list.size(); i++) {
					if(minY > list.get(i).y)
						minY = list.get(i).y;
				}
				
				int minX = Integer.MAX_VALUE;
				int minCnt = 0;
				
				// 가장 위에 있는 먹을 수 있는 물고기 중 왼쪽에 있는 x인덱스 찾기
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).y == minY){
						minCnt++;
						if(list.get(i).x < minX) minX = list.get(i).x;
					}
				}
				
				if(minCnt == 1) { // 가장 위에 있는 물고기가 하나 -> 그 물고기 먹으면 됨
					int fy = 0;
					int fx = 0;
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).y == minY){
							fy = list.get(i).y;
							fx = list.get(i).x;
							break;
						}
					}
					
					result += copy[fy][fx]; // 이동거리 더하기
					map[fy][fx] = 0;
					count++;
					
					if(count == sharkSize) { // 먹은 물고기 수가 상어 크기랑 같아지면 크기 1 증가
						sharkSize++;
						count = 0;
					}
					map[sharkY][sharkX] = 0;
					sharkY = fy;
					sharkX = fx;
					continue;
				}
				
				else { // 둘 이상이면 가장 최소 x인덱스 물고기를 먹어야 함
					int fy = 0;
					int fx = 0;
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).y == minY && list.get(i).x == minX){
							fy = list.get(i).y;
							fx = list.get(i).x;
							break;
						}
					}
					
					result += copy[fy][fx]; // 이동거리 더하기
					map[fy][fx] = 0;
					count++;
					
					if(count == sharkSize) { // 먹은 물고기 수가 상어 크기랑 같아지면 크기 1 증가
						sharkSize++;
						count = 0;
					}
					map[sharkY][sharkX] = 0;
					sharkY = fy;
					sharkX = fx;
					continue;
				}
			}
		}
		
	}
	
	
	public static void checking(int y, int x, int[][] copy) { // 거리를 구하는 bfs 함수
		
		int count = 0;
		Queue<Dir> q = new LinkedList<>();
		q.add(new Dir(y, x, count));
		copy[y][x] = count;
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			
			Dir d = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = d.y + dy[i];
				int nx = d.x + dx[i];
				int nval = d.val;
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				
				if(!visit[ny][nx] && map[ny][nx] <= sharkSize) { // 아직 방문하지 않았고, 상어 크기보다 작은 곳일 때
					q.add(new Dir(ny,nx, nval+1));
					copy[ny][nx] = nval+1;
					visit[ny][nx] = true;
				}
			}
			
		}
	}
}
