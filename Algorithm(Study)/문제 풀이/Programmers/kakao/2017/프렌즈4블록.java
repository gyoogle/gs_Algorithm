package algorithm;

import java.util.ArrayList;

public class 프렌즈4블록 {
	
	static class Block {
		int y;
		int x;
		
		Block(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}
	}

	static char[][] map;
	static ArrayList<Block> list;

	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 0, 1 };
	
	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
		
		list = new ArrayList<>();
		
		while(true) {
			
			// map에서 지워지는 블록 찾기
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == '0') continue;
					if(check(i,j)) { // 지워지는 블록
						list.add(new Block(i,j));
					}
				}
			}
			
			// map에서 지워지는 블록 모두 지우기
			for (int i = 0; i < list.size(); i++) {
				Block b = list.get(i);
				
				if(map[b.y][b.x] != '0') {
					map[b.y][b.x] = '0';
					answer++;
				}
				
				for (int j = 0; j < 3; j++) {
					int ny = b.y + dy[j];
					int nx = b.x + dx[j];
					
					if(map[ny][nx] != '0') {
						map[ny][nx] = '0';
						answer++;
					}
				}
			}
			
			// 지워지고 빈 공간 아래로 내리기
			downBlock();
			
			// 종료 조건
			if(list.size() == 0) break;
			else {
				list.clear();
			}
		}

		return answer;
	}
	
	public static void downBlock() {
		
		char[] temp = new char[map.length];
		
		for (int i = 0; i < map[0].length; i++) {
			
			int idx = 0;
			
			for (int j = temp.length-1; j >= 0; j--) {
				
				if(map[j][i] != '0') {
					temp[idx++] = map[j][i];
				}
			}
			
			int index = 0;
			
			for (int j = map.length-1; j >= 0; j--) {
				if(Math.abs(j-temp.length) <= idx) {
					map[j][i] = temp[index++];
				}
				else {
					map[j][i] = '0';
				}
			}
			
		}
		
	}
	
	public static boolean check(int y, int x) {
		
		char c = map[y][x];
		
		for (int i = 0; i < 3; i++) {
			
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
				return false;
			}
			
			if(map[ny][nx] != c) return false;
			
		}
		
		return true;
	}
	
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String[] board = {
			"CCBDE", "AAADE", "AAABF", "CCBBF"
		};
		
		int m = 4;
		int n = 5;
		
		System.out.println(solution(m, n, board));
		
	}

}
