package SW;
// SWEA 5650 핀볼게임 (19/04/04)
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임_김규석 {

	static class space {
		int y;
		int x;

		space(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int[][] map;
	static ArrayList<space> list;

	static int[] dy = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dx = { 0, 0, -1, 1 };
	static int count;
	
	//원래 위치 y,x 값 저장할 변수 선언
	static int originY, originX;

	static int max;
	
	//웜홀 저장할 리스트 선언
	static ArrayList<space> list6;
	static ArrayList<space> list7;
	static ArrayList<space> list8;
	static ArrayList<space> list9;
	static ArrayList<space> list10;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ts = Integer.parseInt(br.readLine());

		for (int t = 1; t <= ts; t++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			
			list = new ArrayList<>();
			list6 = new ArrayList<>();
			list7 = new ArrayList<>();
			list8 = new ArrayList<>();
			list9 = new ArrayList<>();
			list10 = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) { //빈칸
						list.add(new space(i, j));
					}
					if (map[i][j] == 6) {
						list6.add(new space(i, j));
					}
					if (map[i][j] == 7) {
						list7.add(new space(i, j));
					}
					if (map[i][j] == 8) {
						list8.add(new space(i, j));
					}
					if (map[i][j] == 9) {
						list9.add(new space(i, j));
					}
					if (map[i][j] == 10) {
						list10.add(new space(i, j));
					}
				}
			}

			max = Integer.MIN_VALUE;

			//빈칸마다 상,하,좌,우로 진행
			for (int i = 0; i < list.size(); i++) {

				int y = list.get(i).y;
				int x = list.get(i).x;

				// 비교할 원래 y,x 값 저장
				originY = y;
				originX = x;

				// 4방향 진행
				for (int dir = 0; dir < 4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					count = 0;
					sol(ny, nx, dir);
				}

			}

			System.out.println("#" + t + " " + max);
		}
	}

	public static void sol(int y, int x, int dir) {
		
		int cnt = 1;

		while (true) {
			
			//이미 방향을 정해서 왔기 때문에 처음엔 안 더하고 시작하기 위함
			if(cnt != 1){
				y += dy[dir];
				x += dx[dir];
			}
			cnt = 0;
			
			//벽을 만나면 리턴
			if (y < 0 || x < 0 || y >= N || x >= N) {
				count = count * 2 + 1;
				if (max < count)
					max = count;
				return;
			} 
			
			else {
				// 원래 값 돌아오면 리턴
				if (y == originY && x == originX) {
					if (max < count)
						max = count;
					return;
				}
				else {
					
					//블록을 만났을 때 (카운트 늘려주고, 방향 변경)
					if (map[y][x] == 1 || map[y][x] == 2 || map[y][x] == 3 || map[y][x] == 4 || map[y][x] == 5) {
						count++;
						if (map[y][x] == 1) {
							if (dir == 0 || dir == 3) {
								dir = wallDir(dir);
								continue;
							} else if (dir == 1) {
								dir = 3;
								continue;
							} else {
								dir = 0;
								continue;
							}
						} else if (map[y][x] == 2) {
							if (dir == 1 || dir == 3) {
								dir = wallDir(dir);
								continue;
							} else if (dir == 0) {
								dir = 3;
								continue;
							} else {
								dir = 1;
								continue;
							}
						} else if (map[y][x] == 3) {
							if (dir == 1 || dir == 2) {
								dir = wallDir(dir);
								continue;
							} else if (dir == 0) {
								dir = 2;
								continue;
							} else {
								dir = 1;
								continue;
							}
						} else if (map[y][x] == 4) {
							if (dir == 0 || dir == 2) {
								dir = wallDir(dir);
								continue;
							} else if (dir == 1) {
								dir = 2;
								continue;
							} else {
								dir = 0;
								continue;
							}
						} else if (map[y][x] == 5) {
							dir = wallDir(dir);
							continue;
						}
					} 
					// 블랙홀 만났을 때 (리턴)
					else if (map[y][x] == -1) {
						if (max < count)
							max = count;
						return;
					} 
					// 빈칸 만났을 때 (continue)
					else if (map[y][x] == 0) {
						continue;
					} 
					else { // 웜홀
						if (map[y][x] == 6) {
							int y1 = list6.get(0).y;
							int x1 = list6.get(0).x;
							int y2 = list6.get(1).y;
							int x2 = list6.get(1).x;

							if (y == y1 && x == x1) {
								y = y2;
								x = x2;
								continue;
							} else {
								y = y1;
								x = x1;
								continue;
							}
						} else if (map[y][x] == 7) {
							int y1 = list7.get(0).y;
							int x1 = list7.get(0).x;
							int y2 = list7.get(1).y;
							int x2 = list7.get(1).x;

							if (y == y1 && x == x1) {
								y = y2;
								x = x2;
								continue;
							} else {
								y = y1;
								x = x1;
								continue;
							}
						} else if (map[y][x] == 8) {
							int y1 = list8.get(0).y;
							int x1 = list8.get(0).x;
							int y2 = list8.get(1).y;
							int x2 = list8.get(1).x;

							if (y == y1 && x == x1) {
								y = y2;
								x = x2;
								continue;
							} else {
								y = y1;
								x = x1;
								continue;
							}
						} else if (map[y][x] == 9) {
							int y1 = list9.get(0).y;
							int x1 = list9.get(0).x;
							int y2 = list9.get(1).y;
							int x2 = list9.get(1).x;

							if (y == y1 && x == x1) {
								y = y2;
								x = x2;
								continue;
							} else {
								y = y1;
								x = x1;
								continue;
							}
						} else if (map[y][x] == 10) {
							int y1 = list10.get(0).y;
							int x1 = list10.get(0).x;
							int y2 = list10.get(1).y;
							int x2 = list10.get(1).x;

							if (y == y1 && x == x1) {
								y = y2;
								x = x2;
								continue;
							} else {
								y = y1;
								x = x1;
								continue;
							}
						}
					}
				}
			}
		}

	}

	// 벽 만났을 때 방향 변경해주는 함수
	public static int wallDir(int dir) {
		if (dir == 0)
			dir = 1;
		else if (dir == 1)
			dir = 0;
		else if (dir == 2)
			dir = 3;
		else if (dir == 3)
			dir = 2;

		return dir;
	}

}
